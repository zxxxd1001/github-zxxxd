package my.jpa.readyml;

import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

public class ReadYmlTest {
    @Test
    public void test(){
        try {
            JpaConfiguration d= Configuration.read(fixture("/config.yml"), JpaConfiguration.class);
            DatabaseConfiguration configuration=d.getDatabase();
            System.out.println(configuration);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private InputStream fixture(String fixture) {
        return getClass().getResourceAsStream(fixture);
    }
}