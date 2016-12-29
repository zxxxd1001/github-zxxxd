package bean.entity;

/**
 * Created by 张雪冬 on 2016/12/29.
 */
public class Computer {
    private  String cpu;
    private  String hdd;
    private  String mainBord;

    @Override
    public String toString() {
        return "cpu='" + cpu + ", hdd='" + hdd + ", mainBord='" + mainBord ;
    }

    public String getCpu() {
        return cpu;
    }

    public void setCpu(String cpu) {
        this.cpu = cpu;
    }

    public String getHdd() {
        return hdd;
    }

    public void setHdd(String hdd) {
        this.hdd = hdd;
    }

    public String getMainBord() {
        return mainBord;
    }

    public void setMainBord(String mainBord) {
        this.mainBord = mainBord;
    }
}
