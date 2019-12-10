package org.datahem.patcher;

import com.google.gson.Gson;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.google.gson.stream.JsonReader;
import java.io.StringReader;

/*
PATCH_CONFIG='{
  "patches":[
    {
      "fileDescriptorBucket":"mathem-ml-datahem-test-descriptor",
      "fileDescriptorName":"schemas.desc",
      "descriptorFullName":"mathem.distribution.tms_truck_temperature.truck_temperature.v1.TruckTemperature",
      "taxonomyResourcePattern":".*590903188537942776.*",
      "tables":[
        {
          "tableReference":{
            "projectId":"mathem-ml-datahem-test",
            "datasetId":"test",
            "tableId":"json_debug"
          }
          "createDisposition":"CREATE_IF_NEEDED",
          "timePartitioning":{
              "field":"LastModifiedDate",
              "requirePartitionFilter": false
          },
          "clustering":{
              "fields":["foo","bar"]
          }
        }
      ]
    }
  ]
}'
*/


public class Config {
	private static final Logger LOG = LoggerFactory.getLogger(Config.class);
	
	static public class PatchConfig {
        
        public List<Patch> patches;
		
		static public class Patch {
            public String fileDescriptorBucket;
            public String fileDescriptorName;
            public String descriptorFullName;
            public String taxonomyResourcePattern;
			public List<Table> tables;
			
			static public class Table{
                public TableReference tableReference;
                public String createDisposition;
                public TimePartitioning timePartitioning;
                public Clustering clustering;

                static public class TableReference{
                    public String projectId;
                    public String datasetId;
                    public String tableId;
			    }

                static public class TimePartitioning{
				    public String field;
                    public boolean requirePartitionFilter;
                    public Long expirationMs;
			    }

                static public class Clustering{
				    public List<String> fields;
			    }
			}
		}
	}

	public static List<PatchConfig.Patch> read(String config) {
		LOG.info("config:" + config);
		Gson gson = new Gson();
		JsonReader reader = new JsonReader(new StringReader(config));
		reader.setLenient(true);
		try {
			PatchConfig patch = gson.fromJson(reader, PatchConfig.class);
			return patch.patches;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}