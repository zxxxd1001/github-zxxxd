package mode.prototype;

import java.util.Date;

public class Mail implements Cloneable{
    private String name;
    private String emailAddress;
    private String content;
    private Date birthday;

    public Mail(String name, String emailAddress, String content, Date birthday) {
        this.name = name;
        this.emailAddress = emailAddress;
        this.content = content;
        this.birthday = birthday;
    }

    public Date getBirthday() {
        return birthday;
    }

    @Override
    public String toString() {
        return "Mail{" +
                "name='" + name + '\'' +
                ", emailAddress='" + emailAddress + '\'' +
                ", content='" + content + '\'' +
                ", birthday=" + birthday +
                '}';
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        Mail m=(Mail)super.clone();
        m.birthday= (Date)m.birthday.clone();
        return m;
    }
}
