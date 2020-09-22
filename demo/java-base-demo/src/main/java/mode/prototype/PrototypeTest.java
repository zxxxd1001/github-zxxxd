package mode.prototype;

import java.util.Date;

/**
 * 原型模式
 */
public class PrototypeTest {
    public static void main(String[] args) throws CloneNotSupportedException {
        Date birthday = new Date(0L);
        Mail m=new Mail("张三","zxxxd1001@126.com","prototype",birthday);
        System.out.println(m);
        Mail mail=(Mail) m.clone();
        System.out.println(mail);
        System.out.println();
        m.getBirthday().setTime(666666666666L);
        System.out.println(m);
        System.out.println(mail);
    }
}
