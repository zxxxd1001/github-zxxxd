package datastructure;

/**
 * 演示使用动态规划的思想来优化我们的斐波拉契数列求解问题。
 */
public class Fb {
    /**
     *
     * @param n   计算斐波拉契数列中的某个项
     * @param memory  表示就是我们备忘录
     * @return  返回的计算后某一项结果
     */
    public static int fib(int n, int[] memory ){
        //  用-1 备忘录中没有记录f(n)的值
        // 如果备忘录中记录了该值，直接返回
        if(memory[n]!=-1){
            return memory[n];
        }
        if (n<=2){
            memory[n]=1;
        }else {
            memory[n] = fib(n-1,memory)+fib(n-2,memory);
        }
        return memory[n];
    }

    public static int fibonaci(int n){
        // 数据不合法
        if (n<=0){
            return -1;
        }
        //  创建备忘录
        int [] memeory = new int[n+1];
        // 给备忘录赋值
        for (int i=0;i<=n;i++){
            memeory[i]=-1;
        }
        return  fib(n,memeory);
    }

    public  static  int  fb(int n){
        // 数据合法性的校验
        if (n<=0){
            return -1;
        }
        // 创建我们备忘录
        int [] memory = new int[n+1];

        memory[1] =1;  // f(1)  =1
        memory[2] =1;  // f(2)  =1

        for ( int i=3;i<=n;i++){
            memory[i] =memory[i-1]+memory[i-2];
        }
        return memory[n];
    }

    public static void main(String[] args) {
        int i = fibonaci(7);
        System.out.println(i);

        int y = fb(7);
        System.out.println(y);
    }

    /**
     *
     * @param p  钢条长度和价格对应
     * @param n   钢条的长度
     * @return
     */
    public  static  int  cut( int [] p, int n){
        if (n==0){
            return 0;
        }
        int q = Integer.MIN_VALUE;
        for (int i=1;i<=n;i++){
            q= Math.max(q,p[i-1]+cut(p,n-i));
        }
        return q;
    }

}