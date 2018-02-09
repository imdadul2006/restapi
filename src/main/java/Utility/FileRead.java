package Utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class FileRead {

    static Properties generalProperties;

    static {
        try {
            generalProperties = Property();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Properties Property(String FileName) throws IOException {
        Properties fin = new Properties();
        FileInputStream fis = new FileInputStream(new File(FileName));
        fin.load(fis);
        return fin;
    }

    public static Properties Property() throws IOException {
        Properties fin = new Properties();
        FileInputStream fis = new FileInputStream(new File("target/classes/fms.properties"));
        fin.load(fis);
        return fin;
    }

    public static String getfmsServer(){
        return "http://"+generalProperties.getProperty("fms");
    }
    public static String getfmsUserName(){
        return generalProperties.getProperty("username");
    }
    public static String getfmsPassword(){
        return generalProperties.getProperty("password");
    }
    public static String getfmsDomain(){
        return generalProperties.getProperty("domain");
    }


}
