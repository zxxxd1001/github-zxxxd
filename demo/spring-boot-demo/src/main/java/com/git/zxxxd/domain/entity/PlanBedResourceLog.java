package com.git.zxxxd.domain.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Date;

@Entity
@Table(name="PLAN_BED_RESOURCE_LOG")
@XmlRootElement
public class PlanBedResourceLog {
    @Id
    @Column(name = "LOG_ID")
    private Long logId;

    @Column(name = "BED_NO")
    private Integer bedNo;

    @Column(name = "PLAN_PATIENT_ID")
    private String planPatientId;

    @Column(name = "PLAN_ENTER_DATE")
    private Date planEnterDate;

    @Column(name = "OPERATOR_ID")
    private String operatorId;

    @Column(name = "OPERATOR_NAME")
    private String operatorName;

    @Column(name = "OPERATOR_DATE_TIME")
    private Date operatorDateTime;

    @Column(name = "MEMO")
    private String memo;

    public Long getLogId() {
        return logId;
    }

    public void setLogId(Long logId) {
        this.logId = logId;
    }

    public Integer getBedNo() {
        return bedNo;
    }

    public void setBedNo(Integer bedNo) {
        this.bedNo = bedNo;
    }

    public String getPlanPatientId() {
        return planPatientId;
    }

    public void setPlanPatientId(String planPatientId) {
        this.planPatientId = planPatientId;
    }

    public Date getPlanEnterDate() {
        return planEnterDate;
    }

    public void setPlanEnterDate(Date planEnterDate) {
        this.planEnterDate = planEnterDate;
    }

    public String getOperatorId() {
        return operatorId;
    }

    public void setOperatorId(String operatorId) {
        this.operatorId = operatorId;
    }

    public String getOperatorName() {
        return operatorName;
    }

    public void setOperatorName(String operatorName) {
        this.operatorName = operatorName;
    }

    public Date getOperatorDateTime() {
        return operatorDateTime;
    }

    public void setOperatorDateTime(Date operatorDateTime) {
        this.operatorDateTime = operatorDateTime;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PlanBedResourceLog that = (PlanBedResourceLog) o;

        return logId != null ? logId.equals(that.logId) : that.logId == null;
    }

    @Override
    public int hashCode() {
        return logId != null ? logId.hashCode() : 0;
    }
}
