package git.zxxxd.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static javax.persistence.TemporalType.DATE;

@Entity
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@Table(name = "PAT_MASTER_INDEX")
public class Patient {

    @Id
    @Column(name = "PATIENT_ID")
    private String patientId;

    @Column(name = "OUTP_NO")
    private String outpNo;

    @Column(name = "INP_NO")
    @Size(max = 8, message = "住院号不能超过8位")
    private String inpNo;

    @Column(name = "NAME")
    @NotNull(message = "姓名不能为空")
    private String name;

    @Column(name = "NAME_PHONETIC")
    private String namePhonetic;

    @Column(name = "SEX")
    @NotNull(message = "性别不能为空")
    private String sex;

    @Column(name = "DATE_OF_BIRTH")
    @Temporal(DATE)
    private Date dateOfBirth;

    @Column(name = "ID_NO")
    private String idNo;

    @Column(name = "SECURITY_TYPE")
    private String securityType;

    @Column(name = "SECURITY_NO")
    private String securityNo;

    @Column(name = "CITIZENSHIP")
    private String citizenship;

    @Column(name = "NATION")
    private String nation;

    @Column(name = "IDENTITY")
    private String identity;

    @Column(name = "CHARGE_TYPE")
    @NotNull
    private String chargeType;

    @Column(name = "UNIT_IN_CONTRACT")
    private String unitInContract;

    @Column(name = "BIRTH_PLACE_PROVINCE")
    private String birthPlaceProvince;

    @Column(name = "BIRTH_PLACE_CITY")
    private String birthPlaceCity;

    @Column(name = "BIRTH_PLACE_COUNTY")
    private String birthPlaceCounty;

    @Column(name = "PRESENT_ADDRESS_PROVINCE")
    private String presentAddressProvince;

    @Column(name = "PRESENT_ADDRESS_CITY")
    private String presentAddressCity;

    @Column(name = "PRESENT_ADDRESS_COUNTY")
    private String presentAddressCounty;

    @Column(name = "PRESENT_ADDRESS_OTHERS")
    private String presentAddressOthers;

    @Column(name = "PRESENT_ADDRESS_ZIPCODE")
    private String presentAddressZipcode;

    @Column(name = "SERVICE_AGENCY")
    private String serviceAgency;

    @Column(name = "WORKING_ADDRESS")
    private String workingAddress;

    @Column(name = "WORKING_ADDRESS_ZIPCODE")
    private String workingAddressZipcode;

    @Column(name = "PHONE_NUMBER_BUSINESS")
    private String phoneNumberBusiness;

    @Column(name = "EMAIL")
    private String email;

    @Column(name = "PHONE_NUMBER")
    private String phoneNumber;

    @Column(name = "NEXT_OF_KIN")
    private String nextOfKin;

    @Column(name = "RELATIONSHIP")
    private String relationship;

    @Column(name = "NATIVE_PLACE")
    private String nativePlace;

    @Transient
    private String nativePlaceString;

    @Transient
    private String relationshipString;

    @Transient
    private String citizenshipString;

    @Column(name = "NEXT_OF_KIN_ADDR")
    private String nextOfKinAddr;

    @Column(name = "NEXT_OF_KIN_PHONE")
    private String nextOfKinPhone;

    @Column(name = "UNKNOWN_INDICATOR")
    private Integer unknownIndicator;

    @Column(name = "VIP_INDICATOR")
    private Integer vipIndicator;

    @Column(name = "SECURE_GRADE")
    private Integer secureGrade;

    @Column(name = "MERGED_INDICATOR")
    private Integer mergedIndicator;

    @Column(name = "LAST_VISIT_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastVisitDate;

    @Column(name = "CREATE_DATE_TIME")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createDateTime;

    @Column(name = "OPERATOR_NAME")
    private String operatorName;

    @Column(name = "NEXT_OF_KIN_ZIP_CODE")
    private String nextOfKinZipCode;
    //出生地编码
    @Column(name = "BIRTH_PLACE_CODE")
    private String birthPlaceCode;
    //现住址编码
    @Column(name = "PRESENT_ADDRESS_CODE")
    private String presentAddressCode;
    //户口地址-省（自治区、直辖市）
    @Column(name = "REGISTERED_RESIDENCE_PROVINCE")
    private String registeredResidenceProvince;
    //户口地址-市（地区）
    @Column(name = "REGISTERED_RESIDENCE_CITY")
    private String registeredResidenceCity;
    //户口地址-县（区）
    @Column(name = "REGISTERED_RESIDENCE_COUNTY")
    private String registeredResidenceCounty;
    //户口地址-乡（镇、街道办事处）、村（街、路、弄等）、门牌号码
    @Column(name = "REGISTERED_RESIDENCE_OTHERS")
    private String registeredResidenceOthers;
    //户口地址编码
    @Column(name = "REGISTERED_RESIDENCE_CODE")
    private String registeredResidenceCode;
    //户口地址邮编
    @Column(name = "REGISTERED_RESIDENCE_ZIPCODE")
    private String registeredResidenceZipCode;

    public String getPatientId() {
        return patientId;
    }

    public void setPatientId(String patientId) {
        this.patientId = patientId;
    }

    public String getOutpNo() {
        return outpNo;
    }

    public void setOutpNo(String outpNo) {
        this.outpNo = outpNo;
    }

    public String getInpNo() {
        return inpNo;
    }

    public void setInpNo(String inpNo) {
        this.inpNo = inpNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNamePhonetic() {
        return namePhonetic;
    }

    public void setNamePhonetic(String namePhonetic) {
        this.namePhonetic = namePhonetic;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getIdNo() {
        return idNo;
    }

    public void setIdNo(String idNo) {
        this.idNo = idNo;
    }

    public String getSecurityType() {
        return securityType;
    }

    public void setSecurityType(String securityType) {
        this.securityType = securityType;
    }

    public String getSecurityNo() {
        return securityNo;
    }

    public void setSecurityNo(String securityNo) {
        this.securityNo = securityNo;
    }

    public String getCitizenship() {
        return citizenship;
    }

    public void setCitizenship(String citizenship) {
        this.citizenship = citizenship;
    }

    public String getNation() {
        return nation;
    }

    public void setNation(String nation) {
        this.nation = nation;
    }

    public String getIdentity() {
        return identity;
    }

    public void setIdentity(String identity) {
        this.identity = identity;
    }

    public String getChargeType() {
        return chargeType;
    }

    public void setChargeType(String chargeType) {
        this.chargeType = chargeType;
    }

    public String getUnitInContract() {
        return unitInContract;
    }

    public void setUnitInContract(String unitInContract) {
        this.unitInContract = unitInContract;
    }

    public String getBirthPlaceProvince() {
        return birthPlaceProvince;
    }

    public void setBirthPlaceProvince(String birthPlaceProvince) {
        this.birthPlaceProvince = birthPlaceProvince;
    }

    public String getBirthPlaceCity() {
        return birthPlaceCity;
    }

    public void setBirthPlaceCity(String birthPlaceCity) {
        this.birthPlaceCity = birthPlaceCity;
    }

    public String getBirthPlaceCounty() {
        return birthPlaceCounty;
    }

    public void setBirthPlaceCounty(String birthPlaceCounty) {
        this.birthPlaceCounty = birthPlaceCounty;
    }

    public String getPresentAddressProvince() {
        return presentAddressProvince;
    }

    public void setPresentAddressProvince(String presentAddressProvince) {
        this.presentAddressProvince = presentAddressProvince;
    }

    public String getPresentAddressCity() {
        return presentAddressCity;
    }

    public void setPresentAddressCity(String presentAddressCity) {
        this.presentAddressCity = presentAddressCity;
    }

    public String getPresentAddressCounty() {
        return presentAddressCounty;
    }

    public void setPresentAddressCounty(String presentAddressCounty) {
        this.presentAddressCounty = presentAddressCounty;
    }

    public String getPresentAddressOthers() {
        return presentAddressOthers;
    }

    public void setPresentAddressOthers(String presentAddressOthers) {
        this.presentAddressOthers = presentAddressOthers;
    }

    public String getPresentAddressZipcode() {
        return presentAddressZipcode;
    }

    public void setPresentAddressZipcode(String presentAddressZipcode) {
        this.presentAddressZipcode = presentAddressZipcode;
    }

    public String getServiceAgency() {
        return serviceAgency;
    }

    public void setServiceAgency(String serviceAgency) {
        this.serviceAgency = serviceAgency;
    }

    public String getWorkingAddress() {
        return workingAddress;
    }

    public void setWorkingAddress(String workingAddress) {
        this.workingAddress = workingAddress;
    }

    public String getWorkingAddressZipcode() {
        return workingAddressZipcode;
    }

    public void setWorkingAddressZipcode(String workingAddressZipcode) {
        this.workingAddressZipcode = workingAddressZipcode;
    }

    public String getPhoneNumberBusiness() {
        return phoneNumberBusiness;
    }

    public void setPhoneNumberBusiness(String phoneNumberBusiness) {
        this.phoneNumberBusiness = phoneNumberBusiness;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getNextOfKin() {
        return nextOfKin;
    }

    public void setNextOfKin(String nextOfKin) {
        this.nextOfKin = nextOfKin;
    }

    public String getRelationship() {
        return relationship;
    }

    public void setRelationship(String relationship) {
        this.relationship = relationship;
    }

    public String getNativePlace() {
        return nativePlace;
    }

    public void setNativePlace(String nativePlace) {
        this.nativePlace = nativePlace;
    }

    public String getNativePlaceString() {
        return nativePlaceString;
    }

    public void setNativePlaceString(String nativePlaceString) {
        this.nativePlaceString = nativePlaceString;
    }

    public String getRelationshipString() {
        return relationshipString;
    }

    public void setRelationshipString(String relationshipString) {
        this.relationshipString = relationshipString;
    }

    public String getCitizenshipString() {
        return citizenshipString;
    }

    public void setCitizenshipString(String citizenshipString) {
        this.citizenshipString = citizenshipString;
    }

    public String getNextOfKinAddr() {
        return nextOfKinAddr;
    }

    public void setNextOfKinAddr(String nextOfKinAddr) {
        this.nextOfKinAddr = nextOfKinAddr;
    }

    public String getNextOfKinPhone() {
        return nextOfKinPhone;
    }

    public void setNextOfKinPhone(String nextOfKinPhone) {
        this.nextOfKinPhone = nextOfKinPhone;
    }

    public Integer getUnknownIndicator() {
        return unknownIndicator;
    }

    public void setUnknownIndicator(Integer unknownIndicator) {
        this.unknownIndicator = unknownIndicator;
    }

    public Integer getVipIndicator() {
        return vipIndicator;
    }

    public void setVipIndicator(Integer vipIndicator) {
        this.vipIndicator = vipIndicator;
    }

    public Integer getSecureGrade() {
        return secureGrade;
    }

    public void setSecureGrade(Integer secureGrade) {
        this.secureGrade = secureGrade;
    }

    public Integer getMergedIndicator() {
        return mergedIndicator;
    }

    public void setMergedIndicator(Integer mergedIndicator) {
        this.mergedIndicator = mergedIndicator;
    }

    public Date getLastVisitDate() {
        return lastVisitDate;
    }

    public void setLastVisitDate(Date lastVisitDate) {
        this.lastVisitDate = lastVisitDate;
    }

    public Date getCreateDateTime() {
        return createDateTime;
    }

    public void setCreateDateTime(Date createDateTime) {
        this.createDateTime = createDateTime;
    }

    public String getOperatorName() {
        return operatorName;
    }

    public void setOperatorName(String operatorName) {
        this.operatorName = operatorName;
    }

    public String getNextOfKinZipCode() {
        return nextOfKinZipCode;
    }

    public void setNextOfKinZipCode(String nextOfKinZipCode) {
        this.nextOfKinZipCode = nextOfKinZipCode;
    }

    public String getBirthPlaceCode() {
        return birthPlaceCode;
    }

    public void setBirthPlaceCode(String birthPlaceCode) {
        this.birthPlaceCode = birthPlaceCode;
    }

    public String getPresentAddressCode() {
        return presentAddressCode;
    }

    public void setPresentAddressCode(String presentAddressCode) {
        this.presentAddressCode = presentAddressCode;
    }

    public String getRegisteredResidenceProvince() {
        return registeredResidenceProvince;
    }

    public void setRegisteredResidenceProvince(String registeredResidenceProvince) {
        this.registeredResidenceProvince = registeredResidenceProvince;
    }

    public String getRegisteredResidenceCity() {
        return registeredResidenceCity;
    }

    public void setRegisteredResidenceCity(String registeredResidenceCity) {
        this.registeredResidenceCity = registeredResidenceCity;
    }

    public String getRegisteredResidenceCounty() {
        return registeredResidenceCounty;
    }

    public void setRegisteredResidenceCounty(String registeredResidenceCounty) {
        this.registeredResidenceCounty = registeredResidenceCounty;
    }

    public String getRegisteredResidenceOthers() {
        return registeredResidenceOthers;
    }

    public void setRegisteredResidenceOthers(String registeredResidenceOthers) {
        this.registeredResidenceOthers = registeredResidenceOthers;
    }

    public String getRegisteredResidenceCode() {
        return registeredResidenceCode;
    }

    public void setRegisteredResidenceCode(String registeredResidenceCode) {
        this.registeredResidenceCode = registeredResidenceCode;
    }

    public String getRegisteredResidenceZipCode() {
        return registeredResidenceZipCode;
    }

    public void setRegisteredResidenceZipCode(String registeredResidenceZipCode) {
        this.registeredResidenceZipCode = registeredResidenceZipCode;
    }
}