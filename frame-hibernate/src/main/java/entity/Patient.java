package entity;

import java.math.BigDecimal;
import java.sql.Blob;
import java.util.Date;

/**
 * Created by zhangxuedong on 2017/3/28.
 */
public class Patient {
    private String patientId;
    private String name;
    private Date   birthday;
    private BigDecimal money;
    private Blob  picture;

    private Students students;

    public Patient() {
    }

    public Students getStudents() {
        return students;
    }

    public void setStudents(Students students) {
        this.students = students;
    }

    public String getPatientId() {
        return patientId;
    }

    public void setPatientId(String patientId) {
        this.patientId = patientId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public BigDecimal getMoney() {
        return money;
    }

    public void setMoney(BigDecimal money) {
        this.money = money;
    }

    public Blob getPicture() {
        return picture;
    }

    public void setPicture(Blob picture) {
        this.picture = picture;
    }
}
