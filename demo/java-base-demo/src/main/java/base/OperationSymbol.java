package base;

public class OperationSymbol {
    public static void main(String[] args) {
        int i=128,y=129;
        System.out.println(i&y);
        System.out.println(i|y);
        System.out.println(2|4);//0000 0010 0000 0100
        System.out.println(true&true);
        System.out.println(false&false);
        System.out.println(true&false);
        System.out.println(true|false);
        System.out.println(false|false);
        System.out.println(10&13);
        System.out.println(~10);
        System.out.println(10^13);
        int n=i >> 1;
        System.out.println(i>>2);
        byte c=1;
        System.out.println(Integer.toBinaryString(c));
        System.out.println(c<<2);
        System.out.println(c>>>2);
        System.out.println(Integer.toBinaryString(c>>>2));
        System.out.println(c>>2);
        System.out.println(Integer.toBinaryString(c>>2));
        test();
    }

    /**
     * 一个运算符的例子
     * | 当两边操作数的位有一边为1时，结果为1，否则为0。如1100|1010=1110
     * & 当两边操作数的位都一边为1时，结果为1，否则为0。如1100|1010=1000
     * 注意：0位移后还是0
     * 标记日期的代码 使用代码标记日期，正反换算可以快速得到标记日期
     *
     * 比数组存储数字要好很多
     */
    private static void test(){
        System.out.println("-------------test start---------------");
        int i =0;
        i=i|(1<<2);
        /**
         * 1. 1<<2  位移后的码 0000 0100
         * 2. | 操作 此时i=0  0000 0000  所得到的结果 0000 0100
         * 3. i的值为 4 0000 0100
         */
        System.out.println("2："+i);

        /**
         * 1. 1<<4  位移后的码 0001 0000
         * 2. | 操作 此时i=4  0000 0100  所得到的结果 0001 0100
         * 3. i的值为 20 0001 0100
         */
        i=i|(1<<4);
        System.out.println("4："+i);
        i=i|(1<<29);
        System.out.println();
        // j模拟每月的31天，不考虑最小月天数。 位移时是根据当前日期位移的
        for (int j = 1; j < 32; j++) {
            /**
             * i&(1<<j) 00010 0100 与每个值比对
             * 当有重复的位码时，显示当前的j值
             */
            System.out.println("j："+j+"  "+(i&(1<<j)));
        }
        System.out.println("-------------test end---------------");
    }
}
