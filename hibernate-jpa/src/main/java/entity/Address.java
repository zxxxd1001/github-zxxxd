package entity;

import javax.persistence.Embeddable;

/**
 * Embeddable 非entity类可以嵌入到一个entity类中当属性使用
 *   引用本类的地方必须使用@Embedded
 */
@Embeddable
public class Address {
    private String postCode;
    private String address;

    public String getPostCode() {
        return postCode;
    }

    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
