package com.utilities.reader;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TestDataReader {

    static
    {
        String delimiter = "/";
        String envFolder = "stable";
    }

    private static final String delimiter = "/";
    private static final String envFolder = "stable";
    private static final String extension = ".properties";
    private PropertyFileReader reader = new PropertyFileReader();
    private final Logger logger = LoggerFactory.getLogger(TestDataReader.class);

    private  String globalDataPath =  this.getClass().getClassLoader().getResource("data/").getPath();

    private  String getTestData(String key, String functionality)
    {
        String dataPath = globalDataPath + envFolder + delimiter + functionality + extension;
        reader.setPropertyFile(dataPath);

        String value = reader.getProperty(key);
        logger.info("fetching test data");

        try {
            if (value == null) {
                throw new RuntimeException("Key not found"+ key);
            }
        }catch (Exception e)
        {
            logger.info("Key not found in the given path");
        }
        return value;
    }

    public String getLoginData(String key)
    {
       return getTestData(key,"login");
    }

    public String getTestDataWithKey(String key)
    {
        return getTestData(key,"testdata");
    }

}
