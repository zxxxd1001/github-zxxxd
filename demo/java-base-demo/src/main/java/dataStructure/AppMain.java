package dataStructure;

public class AppMain {
    public static void main(String[] args) {
        MyMap m=new MyMap();
        int y=0;
        for(int i=0;i<100;i++){
            if (y>8) {
                y=0;
            }
            m.put(new P(i+"",y++),i);
        }
        m.remove(new P("8",8));
        System.out.println(m.size());
        System.out.println(Integer.toHexString(m.hashCode()));
        System.out.println(m);
    }
}
