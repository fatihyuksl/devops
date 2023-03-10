package utilities;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
    private static Properties properties;
    static{      //buranın herşeyden önce çalışması için static bloğa aldık
        String path="configuration.properties";   //configuration.properties dosyasının yolunu aldık
        try{
            FileInputStream fis = new FileInputStream(path);
            properties=new Properties();
            properties.load(fis);  //fis'in okudugu bilgileri properties'e yükledi

            fis.close();
        }  catch (IOException e) {
            //    e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
    public static String getProperty(String key){
        /*
Test methodundan yolladigimiz String key degerini alip properties classindan
getProperty() methodunu kullanarak bu key'e ait value'yu bize getirir
 */
        return properties.getProperty(key);
    }
}

