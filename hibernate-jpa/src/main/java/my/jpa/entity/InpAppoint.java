package my.jpa.entity;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.util.Date;

@Entity
@Table(name = "Inp_Appoint")
@XmlRootElement
public class InpAppoint {
    //住院流水号
    @Id
    @Column(name = "APPLY_NO")
    private String applyNo;

    //病人标识
    @Column(name = "PATIENT_ID")
    private String patientId;

    //等床科室
    @Column(name = "DEPT_ADMISSION_TO")
    private String deptAdmissionTo;
    //取消预约时间
    @Column(name = "CANCEL_DATE_TIME")
    @Temporal(TemporalType.TIMESTAMP)
    private Date cancelDateTime;
    //预约流转状态
    @Column(name = "APPOINT_ADT_STATUS")
    private String appointAdtStatus;

    public String getApplyNo() {
        return applyNo;
    }

    public void setApplyNo(String applyNo) {
        this.applyNo = applyNo;
    }

    public String getPatientId() {
        return patientId;
    }

    public void setPatientId(String patientId) {
        this.patientId = patientId;
    }

    public String getDeptAdmissionTo() {
        return deptAdmissionTo;
    }

    public void setDeptAdmissionTo(String deptAdmissionTo) {
        this.deptAdmissionTo = deptAdmissionTo;
    }

    public Date getCancelDateTime() {
        return cancelDateTime;
    }

    public void setCancelDateTime(Date cancelDateTime) {
        this.cancelDateTime = cancelDateTime;
    }

    @XmlJavaTypeAdapter(AppointAdtType.XmlAdapter.class)
    public AppointAdtType getAppointAdtStatus() {
        return AppointAdtType.fromValue(appointAdtStatus);
    }

    public void setAppointAdtStatus(String appointAdtStatus) {
        this.appointAdtStatus =AppointAdtType.fromValue(appointAdtStatus).getValue();
    }

    public static enum AppointAdtType {
        REGIST("已登记"),APPOINTED("已预约"),ADMIT("待入院");
        private String value;
        AppointAdtType(String value) {this.value = value;}
        public String getValue() {return value;}
        public static AppointAdtType fromValue(String value) {
            for (AppointAdtType appointAdtType : AppointAdtType.values()) {
                if (appointAdtType.getValue().equals(value)) {
                    return appointAdtType;
                }
            }
            throw new RuntimeException("未知的预约流转状态");
        }

        public static class XmlAdapter extends javax.xml.bind.annotation.adapters.XmlAdapter<String, AppointAdtType> {
            public AppointAdtType unmarshal(String v) throws Exception {
                return AppointAdtType.fromValue(v);
            }
            public String marshal(AppointAdtType v) throws Exception {
                return v.getValue();
            }
        }
    }
}
