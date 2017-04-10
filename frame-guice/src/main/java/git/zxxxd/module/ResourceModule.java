package git.zxxxd.module;

import com.google.inject.servlet.GuiceFilter;
import com.sun.jersey.guice.JerseyServletModule;
import com.sun.jersey.guice.spi.container.servlet.GuiceContainer;
import git.zxxxd.api.TestResource;
import git.zxxxd.facade.TestFacade;

import java.util.HashMap;
import java.util.Map;

import static com.sun.jersey.api.core.PackagesResourceConfig.PROPERTY_PACKAGES;

public class ResourceModule extends JerseyServletModule{

    protected void configureServlets() {

        bind(GuiceContainer.class);
        binder().requireExplicitBindings();
        //启动类 和在web.xml里配置的是一样的效果
        bind(GuiceFilter.class);


        install(new DBModule());

        bind(TestResource.class);
        bind(TestFacade.class);

        Map<String, String> params = new HashMap<String, String>();
        params.put(PROPERTY_PACKAGES, "git.zxxxd.api.*");
//        filter("/api/*").through(CorsFilter.class);
        serve("/api/*").with(GuiceContainer.class, params);
    }
}
