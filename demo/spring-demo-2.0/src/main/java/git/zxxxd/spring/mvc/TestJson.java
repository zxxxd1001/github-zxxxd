package git.zxxxd.spring.mvc;


import java.util.Date;

public class TestJson {
    private String name="Asd";
    private int age =123;
    private Date d=new Date();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Date getD() {
        return d;
    }

    public void setD(Date d) {
        this.d = d;
    }
}
