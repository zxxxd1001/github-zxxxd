package bean.entity;

/**
 * Created by 张雪冬 on 2016/12/29.
 */
public class Person {
    private Computer computer;
    private Phone phone;

    public Computer getComputer() {
        return computer;
    }

    public void setComputer(Computer computer) {
        this.computer = computer;
    }

    public Phone getPhone() {
        return phone;
    }

    public void setPhone(Phone phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "computer=" + computer.toString() +", phone=" + phone.toString();
    }
}
