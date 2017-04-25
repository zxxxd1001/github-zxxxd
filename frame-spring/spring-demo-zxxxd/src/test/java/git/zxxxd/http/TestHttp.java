package git.zxxxd.http;

/**
 * Created by zhangxuedong on 2017/4/19.
 */
public class TestHttp {
    public static void main(String[] args) {
        //发送 GET 请求
        String s=HttpRequest.sendGet("http://localhost:8051/heren/api/transfer/get-all-dept-dict",null);
        System.out.println(s);
    }
}
