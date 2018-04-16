package test.jdkHttp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URI;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.sun.net.httpserver.HttpExchange;

public class HttpRequest{
    private HttpExchange httpExchange;
    private Map<String, String> paramMap = new HashMap<>();
    private Map<String, List<String>> headMap = new HashMap<>();
    private String requestBody = "";

    public HttpRequest(HttpExchange httpExchange) {
        this.httpExchange = httpExchange;
    }

    public String getParamter(String param) {
        return paramMap.get(param);
    }

    public String getMethod() {
        return httpExchange.getRequestMethod().trim().toUpperCase();
    }

    public URI getReuestURI() {
        return httpExchange.getRequestURI();
    }

    public void initRequestParam() {
        String query = getReuestURI().getQuery();
        if (query!=null) {
            String [] arrayStr = query.split("&");
            for(String str : arrayStr){
                paramMap.put(str.split("=")[0], str.split("=")[1]);
            }
        }

    }

    public void initRequestHeader() {
        for(String s : httpExchange.getRequestHeaders().keySet()){
            headMap.put(s, httpExchange.getRequestHeaders().get(s));
        }
    }

    public void initRequestBody() {
        InputStream in = httpExchange.getRequestBody(); // 获得输入流
        BufferedReader reader = new BufferedReader(new InputStreamReader(in));
        String temp = null;
        try {
            while ((temp = reader.readLine()) != null) {
                requestBody += temp;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getRequestBody() {
        return requestBody;
    }

    public static void main(String[] args) {

        String query = "aaa=aaa&bbb=bbb";
        String [] a = query.split("&");
        for(String s : a){
            System.out.print(s.split("=")[0]+"=");
            System.out.println(s.split("=")[1]);

        }



    }
}
