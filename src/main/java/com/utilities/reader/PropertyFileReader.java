package com.utilities.reader;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PropertyFileReader implements PropertyReader {

    private String propertyFile;

    private final Logger logger = LoggerFactory.getLogger(PropertyFileReader.class);

    public void setPropertyFile(String file)
    {
        this.propertyFile = file;
    }

   public String getProperty(String key)
    {
        return getProperties().getProperty(key);
    }

    private Properties getProperties()
    {
        Properties prop = new Properties();
        try
        {
            File file = new File(this.propertyFile);
            FileInputStream input = new FileInputStream(file);
            prop.load(input);
            input.close();
        }
        catch (IOException e)
        {
            logger.info("File not found");
            e.printStackTrace();
        }

        return prop;
    }
}
