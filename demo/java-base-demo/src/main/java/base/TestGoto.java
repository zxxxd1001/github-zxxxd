package base;

public class TestGoto {
    public static void main(String[] args) {
        flag:
        for (int i = 0; i < 5; i++) {
            if (i==2) {
                break flag;
            }
            System.out.println(i);
        }

        System.out.println();
        for (int i = 0; i < 5; i++) {
            if (i==3) {
                break;
            }
            System.out.println(i);
        }
        System.out.println();
        p(2);
    }
    private static void p(int i){
        System.out.println("1");
        if(i==2)return;
        System.out.println("2");
    }
}
