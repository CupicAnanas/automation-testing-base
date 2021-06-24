package rs.ananas.automation.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

// Used for accessing and initializing test.properties file
public class AccessProperties {

    private static final Properties properties = new Properties();

    public String getProperty(String propertyName) throws IOException {
        InputStream inputStream = new FileInputStream("src/test/resources/test.properties");
        properties.load(inputStream);
        String property = properties.getProperty(propertyName);
        if(property != null){
            return property;
        } else {
            System.out.println("Property you are trying to access is null!");
            return "";
        }
    }

}
