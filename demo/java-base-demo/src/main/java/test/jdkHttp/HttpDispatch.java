package test.jdkHttp;

public abstract class HttpDispatch{
    public final static String GET = "GET";
    public final static String POST = "POST";

    public final void service(HttpRequest request, HttpResponse response) {
        request.initRequestHeader();
        request.initRequestParam();
        if(request.getMethod().equals(HttpDispatch.POST)){
            request.initRequestBody();
            doPost(request,response);
        }else{
            doGet(request,response);
        }
    }

    public abstract void doGet(HttpRequest request, HttpResponse response);

    public abstract void doPost(HttpRequest request, HttpResponse response);
}
