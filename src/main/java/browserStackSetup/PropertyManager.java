package browserStackSetup;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertyManager {

    private static PropertyManager instance;
    private static final Object lock = new Object();
    private static String propertyFilePath = System.getProperty("user.dir")+
            "/src/main/resources/config.properties";
    private static String url;
    private static String macChromeDriver;

    /**
     *
     */

    public static PropertyManager getInstance(){
        if(instance==null)
        {
            synchronized (lock){
                instance = new PropertyManager();
                instance.loadData();
            }
        }

        return instance;
    }


    private void loadData(){
        Properties properties = new Properties();
        try{
            properties.load(new FileInputStream(propertyFilePath));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Configuration properties file cannot be found");
        }

        url = properties.getProperty("url");
        macChromeDriver = properties.getProperty("macChromeDriver");
    }

    public String getUrl(){
        return url;
    }

    public  String getMacChromeDriver() {
        return macChromeDriver;
    }
}
