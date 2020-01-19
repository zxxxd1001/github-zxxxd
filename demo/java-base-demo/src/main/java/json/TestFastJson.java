package json;


import com.alibaba.fastjson.JSON;
import json.entity.Person;

import java.util.*;

public class TestFastJson {
    public static void main(String[] args) throws Exception{
        List<Person> list=new ArrayList<>();
        Person p=new Person("张三",20);
        p.setList(Arrays.asList("123","456","789"));
        Map map=new HashMap();
        map.put("a","1");
        map.put("b","2");
        p.setMap(map);
        list.add(p);
        String jsonOutput = JSON.toJSONString(list);
        System.out.println(jsonOutput);
        List<Person> people = JSON.parseArray(jsonOutput, Person.class);
        System.out.println(people);
    }
}
