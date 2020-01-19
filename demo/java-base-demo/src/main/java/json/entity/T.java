package json.entity;

public class T {
    private String t;
    private Integer b;

    public String getT() {
        return t;
    }

    public void setT(String t) {
        this.t = t;
    }

    public Integer getB() {
        return b;
    }

    public void setB(Integer b) {
        this.b = b;
    }

    @Override
    public String toString() {
        return "T{" +
                "t='" + t + '\'' +
                ", b=" + b +
                '}';
    }
}
