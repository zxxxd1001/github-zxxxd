package json;


import com.fasterxml.jackson.databind.ObjectMapper;
import json.entity.Person;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TestJackson {
    public static void main(String[] args)throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        Person p=new Person("张三",20);
        p.setList(Arrays.asList("123","456","789"));
        Map map=new HashMap();
        map.put("a","1");
        map.put("b","2");
        p.setMap(map);

//        写为字符串
        String pJson = mapper.writeValueAsString(p);
        System.out.println(pJson);
//        从字符串中读取
        Person person = mapper.readValue(pJson, Person.class);
        System.out.println("从字符串中读取：" + person);

//         写为文件
//        mapper.writeValue(new File("person.json"), p);
//         从文件中读取
        Person readF = mapper.readValue(TestJackson.class.getResourceAsStream("/person.json"), Person.class);
        System.out.println("从文件中读取：" + readF);

//        写为字节流
        byte[] bytes = mapper.writeValueAsBytes(p);
//        从字节流中读取
        Person byteP = mapper.readValue(bytes, Person.class);
        System.out.println("从字节流中读取：" + byteP);
    }
}
