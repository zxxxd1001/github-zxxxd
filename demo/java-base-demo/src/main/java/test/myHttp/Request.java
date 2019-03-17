package test.myHttp;

import test.myHttp.utils.MessageUtil;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

public class Request {

    private InputStream input; // Socket --> InputStream
    private Socket socket; // client --> socket
    private BufferedReader buffer; // InputStream --> BufferedReader
    private String schema; // the schema of the request GET or POST
    private String requestFileName; // exact file name
    private String requestData; // file name + <key=value>...
    private String values_Str; // a string the user input in the form
    private int paramLength; // using in the POST: the length of parameters
    private Map<String, String> socketValues;// values_str --> MAP
    private PrintStream print;

    protected MessageUtil messageUtil = new MessageUtil();

    //省略了全部的setter() getter()

    private void doSchema(String firstLineInData) throws IOException {
        socketValues = new HashMap<String, String>();
        if (this.schema.equals("GET")) {
            // GET请求 --> 包含文件名和参数键值对
            // 实现了对FileName、SocketValues的赋值
            this.setRequestData(messageUtil.getRequestData(firstLineInData));
            if (this.requestData.contains("?")) {
                this.setRequestFileName(messageUtil.getFileName(this.getRequestData()));
                this.setSocketValues(messageUtil.getValues(this.getRequestData()));
            } else {
                // GET请求 -->只包含文件名
                // 实现了对FileName的赋值
                this.setRequestFileName(requestData);
            }
        } else {
            // POST请求 第一行只包含文件名
            // 实现了对FileName、SocketValues的赋值
            this.setRequestFileName(messageUtil.getRequestData(firstLineInData));
            this.getUserInfo(buffer);
        }
    }

    private void getUserInfo(BufferedReader br) throws IOException {
        while (this.buffer.ready()) {
            String remained = buffer.readLine();
            if (remained.contains("Content-Length")) {
                String[] temp = remained.split(" ");
                this.setParamLength(Integer.parseInt(temp[1]));
                break;
            }
        }
        buffer.readLine();
        String userInfo = "";
        for (int i = 0; i < this.getParamLength(); i++) {
            userInfo += (char) buffer.read();
        }
        this.setValues_Str(userInfo);
        this.setSocketValues(messageUtil.getValues(this.getValues_Str()));
    }

    public Request(Socket clientSocket) throws IOException {
        this.setSocket(clientSocket);
        this.setPrint(new PrintStream(clientSocket.getOutputStream()));
        this.setInput(clientSocket.getInputStream());
        this.setBuffer(new BufferedReader(new InputStreamReader(clientSocket.getInputStream())));

        // get something from the first line
        String firstLineInData = buffer.readLine();

        this.setSchema(messageUtil.getSchema(firstLineInData)); // 获得请求方式Schema

        doSchema(firstLineInData); // 对Schema进行判断

    }

    public InputStream getInput() {
        return input;
    }

    public void setInput(InputStream input) {
        this.input = input;
    }

    public Socket getSocket() {
        return socket;
    }

    public void setSocket(Socket socket) {
        this.socket = socket;
    }

    public BufferedReader getBuffer() {
        return buffer;
    }

    public void setBuffer(BufferedReader buffer) {
        this.buffer = buffer;
    }

    public String getSchema() {
        return schema;
    }

    public void setSchema(String schema) {
        this.schema = schema;
    }

    public String getRequestFileName() {
        return requestFileName;
    }

    public void setRequestFileName(String requestFileName) {
        this.requestFileName = requestFileName;
    }

    public String getRequestData() {
        return requestData;
    }

    public void setRequestData(String requestData) {
        this.requestData = requestData;
    }

    public String getValues_Str() {
        return values_Str;
    }

    public void setValues_Str(String values_Str) {
        this.values_Str = values_Str;
    }

    public int getParamLength() {
        return paramLength;
    }

    public void setParamLength(int paramLength) {
        this.paramLength = paramLength;
    }

    public Map<String, String> getSocketValues() {
        return socketValues;
    }

    public void setSocketValues(Map<String, String> socketValues) {
        this.socketValues = socketValues;
    }

    public PrintStream getPrint() {
        return print;
    }

    public void setPrint(PrintStream print) {
        this.print = print;
    }
}
