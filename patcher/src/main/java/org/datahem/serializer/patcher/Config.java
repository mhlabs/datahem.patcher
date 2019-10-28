package org.datahem.serializer.patcher;

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
      "tableReferences":[
        {
          "bigQueryProject":"mathem-ml-datahem-test",
          "bigQueryDataset":"test",
          "bigQueryTable":"json_debug"
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
			public List<TableReference> tableReferences;
			
			static public class TableReference{
				public String bigQueryProject;
                public String bigQueryDataset;
                public String bigQueryTable;
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