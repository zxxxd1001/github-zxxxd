package entity;

import javax.persistence.Embeddable;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created by zhangxuedong on 2017/3/30.
 */
@Embeddable
public class InsurPatientPK implements Serializable{
    private Integer id;
    private String insurId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getInsurId() {
        return insurId;
    }

    public void setInsurId(String insurId) {
        this.insurId = insurId;
    }
}
