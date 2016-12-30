package bean;

import bean.entity.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Calendar;
import java.util.Date;

public class TestBean{
    public static void main(String[] args) {
        //gradle 在生成class文件是为什么没有吧 xml一块放到classes 中去
        //标准的maven结构
        //resources 和 java 是同一层 打包 classes和resources里面的文件会合并  也就是说打包 会去掉classes和resources 这两目录
        /**
         * ClassPathXmlApplicationContext 是根据类路径寻找的 classes 里面需要有applicationContext这个文件
         * FileSystemXmlApplicationContext 它是根据指定的路径来进行寻找，所以要把路径写完整。
         * WebApplicationContextUtils.getWebApplicationContext
         */
        System.out.println(TestBean.class.getResource("").getPath());
        ApplicationContext ac=null;
        ac=new ClassPathXmlApplicationContext("applicationContextBean.xml");
        /*
        * 这样写在打包完成后不能运行 不一定在这个指定目录 路径问题
        * ac=new FileSystemXmlApplicationContext("spring-demo-zxxxd/src/main/applicationContextBean.xml");
        */

        Computer c=ac.getBean("computer",Computer.class);
        System.out.println("电脑："+c.toString());

        Phone p=ac.getBean("phone",Phone.class);
        System.out.println("手机："+p.toString());

        Person person=(Person) ac.getBean("person");
        System.out.println(person.toString());

        System.out.println("------------------------------------");

        Date date1=(Date) ac.getBean("date1");
        Date date2=ac.getBean("date2",Date.class);
        System.out.println("是否为单利："+(date1==date2)+","+date2.getTime());

        Calendar calendar1=ac.getBean("GregorianCalendar1",Calendar.class);
        Calendar calendar2=ac.getBean("GregorianCalendar2",Calendar.class);
        System.out.println(calendar1);
        System.out.println(calendar2);
        Date date3=ac.getBean("date3",Date.class);
        System.out.println(date3);

        System.out.println("------------------------------------");

        AbstractApplicationContext aac=new ClassPathXmlApplicationContext("applicationContextBean.xml");
        BeanLifecycle beanLifecycle=aac.getBean("lifecycle",BeanLifecycle.class);
        beanLifecycle.execute();
        BeanLifecycle beanLifecycle2=aac.getBean("lifecycle",BeanLifecycle.class);
        System.out.println("是否为单利："+(beanLifecycle==beanLifecycle2));
        aac.close();

        System.out.println("------------------------------------");

        MessageBean messageBean=ac.getBean("message",MessageBean.class);
        messageBean.toString();

        System.out.println("------------------------------------");

        MessageBean messageTwo=ac.getBean("messageTwo",MessageBean.class);
        messageTwo.toString();
    }
}