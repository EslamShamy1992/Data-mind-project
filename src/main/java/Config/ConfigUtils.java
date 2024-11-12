package Config;

import java.util.Properties;

public class ConfigUtils {

    private Properties properties;
    private static ConfigUtils configUtils;
    public ConfigUtils(){
        properties = PropertyUtils.loadproperties("src/main/java/Config/staging.properties");
    }

    public static ConfigUtils getInstance(){
        if(configUtils == null){
            configUtils= new ConfigUtils();

        }
        return configUtils;
    }



    public String getBaseUrl() {
        String prop = properties.getProperty("baseUrl");
        if(prop != null ) return prop;
        throw new RuntimeException("couldn't find base uel");

    }
    public String getEmail() {
        String prop = properties.getProperty("AdminEmail");
        if(prop != null ) return prop;
        throw new RuntimeException("couldn't find email");


    }

    public String getPassword() {
        String prop = properties.getProperty("AdminPassword");
        if(prop != null ) return prop;
        throw new RuntimeException("couldn't find password");

    }
    public String InfoType() {
        String prop = properties.getProperty("InformationType");
        if(prop != null ) return prop;
        throw new RuntimeException("couldn't find password");

    }
    public String DocType() {
        String prop = properties.getProperty("DocumentType");
        if(prop != null ) return prop;
        throw new RuntimeException("couldn't find password");

    }
    public String FileType() {
        String prop = properties.getProperty("FileType");
        if(prop != null ) return prop;
        throw new RuntimeException("couldn't find password");

    }
}
