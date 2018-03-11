package git.zxxxd.spring.bean;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.Map.Entry;

public class MessageBean {
    private String name;
    private Integer age;
    private Date birth;
    private Date date;
    private List<String> friends;
    private Set<String> cities;
    private Map<String,String> books;
    private Properties db;

    public String toString() {
        show();
        return "";
    }
    private void show(){
        System.out.println("name:"+name);
        System.out.println("age:"+age);
        System.out.println("birth:"+birth);
        System.out.println("list:"+friends.toString());
        System.out.println("set:"+cities.toString());
        System.out.println("date:"+date);
        Set<Entry<String,String>> set=books.entrySet();
        System.out.println("map:"+set.toString());
        System.out.println("Properties:"+db.toString());
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Date getBirth() {
        return birth;
    }

    public void setBirth(String birth) {
        DateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd");
        Date date= null;
        try {
            date = dateFormat.parse(birth);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        this.birth = date;
    }

    public List<String> getFriends() {
        return friends;
    }

    public void setFriends(List<String> friends) {
        this.friends = friends;
    }

    public Set<String> getCities() {
        return cities;
    }

    public void setCities(Set<String> cities) {
        this.cities = cities;
    }

    public Map<String, String> getBooks() {
        return books;
    }

    public void setBooks(Map<String, String> books) {
        this.books = books;
    }

    public Properties getDb() {
        return db;
    }

    public void setDb(Properties db) {
        this.db = db;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
