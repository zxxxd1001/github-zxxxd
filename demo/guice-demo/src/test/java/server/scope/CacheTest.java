package server.scope;

import com.git.zxxxd.server.scope.CacheModule;
import com.git.zxxxd.server.scope.GuiceDemoCache;
import com.google.common.cache.Cache;
import com.google.inject.Guice;
import com.google.inject.Inject;
import org.junit.Before;
import org.junit.Test;

import java.util.List;
import java.util.Map;

public class CacheTest {
    @Inject
    private Cache<String,String> cache;
    @Inject
    private Cache<String,String> cache1;
    @Inject
    private GuiceDemoCache guiceDemoCache;
    @Inject
    private GuiceDemoCache guiceDemoCache1;

    @Inject
    private Map<String,String> map;
    @Inject
    private Map<String,String> map1;

    @Inject
    private List l;
    @Inject
    private List ll;

    @Before
    public void setUp() {
        Guice.createInjector(new CacheModule()).injectMembers(this);
    }

    @Test
    public void test() {
        cache.put("1","2");
        String s=cache1.getIfPresent("1");
        System.out.println("2"==s);
        System.out.println("cache :"+cache.hashCode());
        System.out.println("cache1 :"+cache1.hashCode());

        guiceDemoCache.put("1","2");
        String ss= guiceDemoCache1.getIfPresent("1");
        System.out.println("2"==ss);
        System.out.println("guiceDemoCache :"+guiceDemoCache.hashCode());
        System.out.println("guiceDemoCache1 :"+guiceDemoCache1.hashCode());

        map.put("1","2");
        System.out.println("map :"+("2"==map1.get("1")));

        l.add(1);
        System.out.println("list :"+(l.size()==ll.size()));

    }
}
