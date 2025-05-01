package Utils;

import java.io.IOException;
import java.util.Properties;

public class configUtils {
    private static Properties props;
    public configUtils() throws IOException {
        props = configProperties.properties();
    }
    public static String getName(){
        return props.getProperty("validname");
    }

    public static String getPassword(){
        return props.getProperty("validpass");
    }


}
