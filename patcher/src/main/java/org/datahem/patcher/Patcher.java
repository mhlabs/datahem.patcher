//mvn compile exec:java -Dexec.mainClass=org.datahem.patcher.Patcher -Dexec.args="'$PATCH_CONFIG'"

package org.datahem.patcher;

import org.datahem.patcher.ProtobufUtils;
import io.anemos.metastore.core.proto.*;

import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.googleapis.auth.oauth2.GoogleCredential;
import com.google.api.client.googleapis.json.GoogleJsonResponseException;

import com.google.api.services.bigquery.BigqueryScopes;
import com.google.api.services.bigquery.Bigquery;
import com.google.api.services.bigquery.Bigquery.Tables;
import com.google.api.services.bigquery.model.Table;
import com.google.api.services.bigquery.model.TableSchema;
import com.google.api.services.bigquery.model.TableReference;
import com.google.api.services.bigquery.model.TimePartitioning;
import com.google.api.services.bigquery.model.Clustering;

import com.google.protobuf.DescriptorProtos.FileDescriptorSet;
import com.google.protobuf.Descriptors.FileDescriptor;
import com.google.protobuf.DescriptorProtos.FileDescriptorProto;
import com.google.protobuf.Descriptors.Descriptor;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Patcher 
{
    private static final Logger LOG = LoggerFactory.getLogger(Patcher.class);

    public static void main( String[] args ){

        if(args.length != 1){
            LOG.error("Wrong number of arguments, should only be one (1) configuration argument");
        }

        for (Config.PatchConfig.Patch patch : Config.read(args[0])) {
            LOG.info(patch.fileDescriptorBucket);

            HttpTransport transport = new NetHttpTransport();
            JsonFactory jsonFactory = new JacksonFactory();
            GoogleCredential credential;
            
            try {
                credential = GoogleCredential.getApplicationDefault(transport,jsonFactory);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            if (credential.createScopedRequired()) {
                credential = credential.createScoped(BigqueryScopes.all());
            }

            try{
                ProtoDescriptor protoDescriptor = ProtobufUtils.getProtoDescriptorFromCloudStorage(patch.fileDescriptorBucket, patch.fileDescriptorName);
                Descriptor descriptor = protoDescriptor.getDescriptorByName(patch.descriptorFullName);
                TableSchema newSchema = ProtobufUtils.makeTableSchema(protoDescriptor, descriptor, patch.taxonomyResourcePattern);
                //LOG.info("eventSchema: " + newSchema.toString());
                
                Table table = new Table();
                table.setSchema(newSchema);
                Bigquery.Tables bqTables = new Bigquery.Builder(transport, jsonFactory, credential).build().tables();
                //TableSchema oldSchema = null;

                for(Config.PatchConfig.Patch.TableReference tableReference : patch.tableReferences){
                        TableReference tableRef = new TableReference()
                            .setProjectId(tableReference.bigQueryProject)
                            .setDatasetId(tableReference.bigQueryDataset)
                            .setTableId(tableReference.bigQueryTable);

                        TimePartitioning timePartitioning = new TimePartitioning()
                            .setField(tableReference.timePartitioning.field)
                            .setRequirePartitionFilter(tableReference.timePartitioning.requirePartitionFilter);

                        Clustering clustering = new Clustering()
                            .setFields(tableReference.clustering.fields);

                        table
                            .setTableReference(tableRef)
                            .setTimePartitioning(timePartitioning)
                            .setClustering(clustering);

                        try{
                            LOG.info("Get current table schema");
                            Bigquery.Tables.Get bqTableGet = bqTables.get(tableReference.bigQueryProject, tableReference.bigQueryDataset, tableReference.bigQueryTable);
                            Table bqTable = bqTableGet.execute();
                            TableSchema oldSchema = bqTable.getSchema();
                            if(oldSchema.equals(newSchema)){ //if old schema equals new schema do nothing
                                LOG.info("Current schema equals new schema");
                            }else{ //if old schema doesn't equals new schema, patch the table
                                LOG.info("Current schema doesn't equal new schema -> patch table schema");
                                Bigquery.Tables.Patch bqTablePatch = bqTables.patch(tableReference.bigQueryProject, tableReference.bigQueryDataset, tableReference.bigQueryTable, table);
                                bqTablePatch.execute();
                            }
                        }catch (GoogleJsonResponseException e) {
                            if(e instanceof GoogleJsonResponseException){
                                int statusCode = e.getStatusCode();
                                if(statusCode == 404 && tableReference.createDisposition.equals("CREATE_IF_NEEDED")){
                                    LOG.info("Couldn't find table -> create new table");
                                    /*
                                    TableReference tableRef = new TableReference();
                                    tableRef.setProjectId(tableReference.bigQueryProject);
                                    tableRef.setDatasetId(tableReference.bigQueryDataset);
                                    tableRef.setTableId(tableReference.bigQueryTable);
                                    table.setTableReference(tableRef);*/
                                    Bigquery.Tables.Insert bqTableInsert = bqTables.insert(tableReference.bigQueryProject, tableReference.bigQueryDataset, table);
                                    bqTableInsert.execute();
                                }else{
                                    e.printStackTrace();
                                    System.exit(1);
                                }
                            }
                        }
                }
            }catch (Exception e) {
                e.printStackTrace();
                //throw new RuntimeException(e);
                System.exit(1);
            }
        }
    }
}