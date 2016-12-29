package bean.entity;

/**
 * Created by 张雪冬 on 2016/12/29.
 */
public class Phone {
    private String cpu;
    private String ram;

    public Phone(String cpu, String ram) {
        this.cpu = cpu;
        this.ram = ram;
    }

    public Phone() {
    }

    @Override
    public String toString() {
        return "cpu='" + cpu + ", ram='" + ram ;
    }

}
