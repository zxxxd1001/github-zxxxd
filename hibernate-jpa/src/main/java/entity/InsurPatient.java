package entity;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="insur_patient")
public class InsurPatient {
    //@Id 与@EmbeddedId
    @EmbeddedId
    private InsurPatientPK insurPatientPK;

    private String name;

    public InsurPatientPK getInsurPatientPK() {
        return insurPatientPK;
    }

    public void setInsurPatientPK(InsurPatientPK insurPatientPK) {
        this.insurPatientPK = insurPatientPK;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
