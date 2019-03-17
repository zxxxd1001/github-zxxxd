package test.myHttp.utils;

import java.util.HashMap;
import java.util.Map;

public class MessageUtil {
    // schema : GET or POST
    public String getSchema(String requestMsg) {
        if (requestMsg!=null&&requestMsg.contains(" ")) {
            return requestMsg.split(" ")[0];
        }
        return "";
    }

    // get the resquestData = (filename + map<S,S>)
    public String getRequestData(String firstLineInData) {
        if (firstLineInData!=null&&firstLineInData.contains(" ")) {
            return firstLineInData.split(" ")[1].substring(1);
        }
        return "";
    }

    // get the filename from the requestData
    public String getFileName(String requestData) {
        String[] result = new String[10];
        result = requestData.split("[?]");
        return result[0];
    }

    // save the info into the map<S,S>
    public Map<String, String> getValues(String requestData) {
        Map<String, String> values = new HashMap<String, String>();
        String[] result = new String[10];
        String regex = "[&=]";

        if (requestData.contains("?")) {
            result = requestData.split("[?]");
            String data_List = result[1];
            result = data_List.split(regex);
            for (int i = 0; i < result.length - 1; i += 2) {
                values.put(result[i], result[i + 1]);
            }
            return values;
        } else {
            result = requestData.split(regex);
            for (int i = 0; i < result.length - 1; i += 2) {
                values.put(result[i], result[i + 1]);
            }
            return values;
        }
    }

}
