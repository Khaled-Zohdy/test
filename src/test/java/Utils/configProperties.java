package Utils;

import java.io.*;
import java.util.Properties;

public class configProperties {
    public static Properties properties() throws IOException {
        File file;
        String path = System.setProperty("path","old");
        switch (path){
            case"new":
                 file = new File("src/test/java/Properties/testNewData.properties");
                break;
            case "old":
                 file = new File("src/test/java/Properties/testData.properties");
                break;
            default:
                throw new RuntimeException("no file");
        }
        InputStream inputStream = new FileInputStream(file);
        Properties properties = new Properties();
        properties.load(inputStream);
        inputStream.close();
        return properties;
    }
}
