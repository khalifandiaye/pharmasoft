package fr.mmm.pharmaSoft.commun;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Properties;

public class LoadProperties {
	private static  Properties properties = new Properties();
    
    public  static Properties getProperties() {
    	LoadProperties props = new LoadProperties();
        props.loadProps();
        return properties;
    }
 
    public void loadProps() {

        InputStream in = this.getClass().getResourceAsStream("/messages.properties");
        
        try {
        	properties.load(in);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public static String getProperty(String s) {
    	
        return getProperties().getProperty(s);
    }
     
}
