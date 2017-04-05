package entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="score")
public class Score implements Serializable{
    @Id
    @Column(name="score_id")
    private Integer scoreId;

    @Id
    @Column(name ="id")
    private Integer id;

    @Column(name ="students_score")
    private String studentsScore;

    public Integer getScoreId() {
        return scoreId;
    }

    public void setScoreId(Integer scoreId) {
        this.scoreId = scoreId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStudentsScore() {
        return studentsScore;
    }

    public void setStudentsScore(String studentsScore) {
        this.studentsScore = studentsScore;
    }

    public Score() {
    }

    public Score(Integer scoreId, Integer id, String studentsScore) {
        this.scoreId = scoreId;
        this.id = id;
        this.studentsScore = studentsScore;
    }
}
