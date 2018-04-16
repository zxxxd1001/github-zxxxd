package test.jdkHttp;

import java.util.HashMap;
import java.util.Map;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import test.jdkHttp.utils.XmlUtils;

public class Context {
    private static Map<String,HttpDispatch> contextMap = new HashMap<>();
    public static String contextPath = "";
    public static void load(){
        try{
            Document doc = XmlUtils.load(Context.class.getResource("/").getPath()+ "../../resources/main/context.xml");
            Element root = doc.getDocumentElement();

            contextPath = XmlUtils.getAttribute(root,"context");
            Element[] handlers = XmlUtils.getChildrenByName(root, "handler");
            for(Element ele : handlers){

                String handle_class = XmlUtils.getChildText(ele, "handler-class");
                String url_pattern = XmlUtils.getChildText(ele, "url-pattern");

                Class<?> cls = Class.forName(handle_class);
                Object newInstance = cls.newInstance();
                if(newInstance instanceof HttpDispatch){
                    contextMap.put(contextPath+url_pattern, (HttpDispatch)newInstance);
                }
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public static HttpDispatch getHandler(String key){
        return contextMap.get(key);
    }
}

