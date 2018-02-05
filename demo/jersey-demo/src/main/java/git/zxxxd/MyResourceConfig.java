package git.zxxxd;

import com.fasterxml.jackson.jaxrs.json.JacksonJaxbJsonProvider;
import org.glassfish.jersey.media.multipart.MultiPartFeature;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.server.ServerProperties;

public class MyResourceConfig extends ResourceConfig {
    public MyResourceConfig(String packages) {
        register(JacksonJaxbJsonProvider.class);
        register(MultiPartFeature.class);
        property(ServerProperties.BV_DISABLE_VALIDATE_ON_EXECUTABLE_OVERRIDE_CHECK, true);
        property(ServerProperties.RESPONSE_SET_STATUS_OVER_SEND_ERROR, true);
        packages(packages);
    }
}
