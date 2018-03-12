package git.zxxxd.spring.bean;

import git.zxxxd.spring.bean.annotation.Person;
import git.zxxxd.spring.bean.annotation.BeanLifecycle;
import git.zxxxd.spring.bean.annotation.BeanInterFace;
import git.zxxxd.spring.bean.annotation.ReadProperties;
import org.junit.Test;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class TestAnnotation {
    @Test
    public void test(){
        AbstractApplicationContext ac=new ClassPathXmlApplicationContext("applicationContextAnnotationBean.xml");
        Person p=ac.getBean("person",Person.class);
        System.out.println(p.getName()+","+p.getWang());
        p.getBeanInterFace().whatYouName();
        System.out.println("");
        for(BeanInterFace b:p.getBeanInterFaces()){
            b.whatYouName();
        }

        //spring默认创建类是单利模式
        Person p1=ac.getBean("person",Person.class);
        System.out.println(p.getBeanInterFaces()==p1.getBeanInterFaces());
        System.out.println(p==p1);
        System.out.println();

        //spring初始化方法和销毁方法、修改scope
        BeanLifecycle b=ac.getBean("lifecycle",BeanLifecycle.class);

        System.out.println(ac.getBean("readProperties",ReadProperties.class));
        System.out.println();
        ac.close();
    }
}
