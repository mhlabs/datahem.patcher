//mvn compile exec:java -Dexec.mainClass=org.datahem.serializer.patcher.Patcher -Dexec.args="'$PATCH_CONFIG'"

package org.datahem.serializer.patcher;

import org.datahem.serializer.patcher.ProtobufUtils;
import io.anemos.metastore.core.proto.*;

import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.googleapis.auth.oauth2.GoogleCredential;

import com.google.api.services.bigquery.BigqueryScopes;
import com.google.api.services.bigquery.Bigquery;
import com.google.api.services.bigquery.Bigquery.Tables;
import com.google.api.services.bigquery.model.Table;
import com.google.api.services.bigquery.model.TableSchema;
import com.google.api.services.bigquery.model.TableReference;

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
                TableSchema eventSchema = ProtobufUtils.makeTableSchema(protoDescriptor, descriptor, patch.taxonomyResourcePattern);
                LOG.info("eventSchema: " + eventSchema.toString());
                
                Table table = new Table();
                table.setSchema(eventSchema);
                Bigquery.Tables bqTables = new Bigquery.Builder(transport, jsonFactory, credential).build().tables();

                for(Config.PatchConfig.Patch.TableReference tableReference : patch.tableReferences){
                    Bigquery.Tables.Patch bqTablePatch = bqTables.patch(tableReference.bigQueryProject, tableReference.bigQueryDataset, tableReference.bigQueryTable, table);
                    bqTablePatch.execute();
                }
            }catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}