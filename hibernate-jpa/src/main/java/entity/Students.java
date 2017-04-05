package entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="students")
public class Students {
    @Id
    @Column(name ="id")
    private Integer id;

    @Column(name ="name")
    private String name;

    @OneToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name="p_id")
    private IdCard idCard;

    @OneToMany(cascade = {CascadeType.ALL},fetch = FetchType.EAGER)
    @JoinColumn(name = "id", updatable = false, insertable = false)
    private List<Score> score;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public IdCard getIdCard() {
        return idCard;
    }

    public void setIdCard(IdCard idCard) {
        this.idCard = idCard;
    }

    public List<Score> getScore() {
        return score;
    }

    public void setScore(List<Score> score) {
        this.score = score;
    }
}
