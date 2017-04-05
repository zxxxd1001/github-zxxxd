package entity;

import javax.persistence.*;

@Entity
@Table(name="id_card")
public class IdCard {
    @Id
    @Column(name ="p_id")
    private Integer pId;

    @Column(name ="sax")
    private String sax;
//双向一对一 被控方设置mappedBy
    @OneToOne(mappedBy = "idCard")
    private Students students;

    public Integer getpId() {
        return pId;
    }
    public void setpId(Integer pId) {
        this.pId = pId;
    }

    public String getSax() {
        return sax;
    }

    public void setSax(String sax) {
        this.sax = sax;
    }

    public Students getStudents() {
        return students;
    }

    public void setStudents(Students students) {
        this.students = students;
    }
}
