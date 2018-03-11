package git.zxxxd.spring.bean;


import java.text.SimpleDateFormat;
import java.util.Date;

public class Person {
    private String name;
    private Date age;

    public Person(String name, Date age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return "Person{ " +
                "name='" + name + '\'' +
                ", age=" + sdf.format(age) +
                " }";
    }
}
