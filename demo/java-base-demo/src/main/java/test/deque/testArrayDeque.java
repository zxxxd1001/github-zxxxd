package test.deque;

import java.util.*;

/**
 * Created by zhangxuedong on 2017/8/23.
 */
public class testArrayDeque {
    public static void main(String[] args) {
        testArrayDeque();
    }
    private static void testArrayDeque(){
        Deque d=new ArrayDeque();
        d.add("1");
        d.add("3");
        //ArrayDeque不可以插入null元素
//        d.add(null);
        System.out.println(d.size());
        Deque l=new LinkedList();
        l.add("1");
        //LinkedList可以插入null元素
        l.add(null);
        System.out.println(l.size());
        Set s=new HashSet();
        s.add(null);
        System.out.println(s.size());

        String str="bbbbb";
        int fs = 0;//用于存取最后要返回的长度
        //1.创建一个map，key：字符，value: 字符下标  `
        Map<Character,Integer> map = new HashMap<>();
        //2.遍历字符串，并将字符串存入map中
        for (int start = 0,end = 0; end < str.length(); end++) {
            char ch = str.charAt(end);
            if (map.containsKey(ch)){ //若已经存在于map中，则将其对应的value拿出来
                start = Math.max(map.get(ch),start);
            }
            // 取较大值
            fs = Math.max(fs,end - start +1);
            //存入map中
            map.put(ch,end + 1);
        }
        System.out.println(fs);
    }
}
