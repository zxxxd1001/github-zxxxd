package mode.builder;

import java.util.HashMap;
import java.util.Map;

public class TestBuilder {
    public static void main(String[] args) {
        Student s = new Student().anStudentBuilder().name("zhangs").age(18).build();
        System.out.println(s);
    }
}

class Student {
    private String name = "";
    private String sex = "";
    private int age = 0;
    private String school = "";

    Student() {

    }

    public Student(String name, String sex, int age, String school) {
        this.name = name;
        this.sex = sex;
        this.age = age;
        this.school = school;
    }

    public StudentBuilder anStudentBuilder() {
        return new StudentBuilder();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", age=" + age +
                ", school='" + school + '\'' +
                '}';
    }

    static class StudentBuilder {
        private String name = "";
        private String sex = "";
        private int age = 0;
        private String school = "";

        StudentBuilder() {

        }

        public StudentBuilder name(String name) {
            this.name = name;
            return this;
        }
        public StudentBuilder sex(String sex) {
            this.sex = sex;
            return this;
        }

        public StudentBuilder age(int age) {
            this.age = age;
            return this;
        }

        public StudentBuilder school(String school) {
            this.school = school;
            return this;
        }

        public Student build() {
            return new Student(name, sex, age, school);
        }

    }
}