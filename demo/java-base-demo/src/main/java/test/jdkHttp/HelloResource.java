package test.jdkHttp;

public class HelloResource extends HttpDispatch {
    @Override
    public void doGet(HttpRequest request, HttpResponse response) {
        response.write( request.getParamter("name")+",world");
    }

    @Override
    public void doPost(HttpRequest request, HttpResponse response) {

    }
}
