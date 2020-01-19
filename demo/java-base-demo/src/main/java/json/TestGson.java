package json;

import com.google.gson.Gson;

public class TestGson {
    public static void main(String[] args) {
        Gson gson = new Gson();
        System.out.println(gson.toJson(1));            // ==> 1
        System.out.println(gson.toJson("abcd"));       // ==> "abcd"
        System.out.println(gson.toJson(new Long(10))); // ==> 10
        System.out.println(gson.toJson(new int[]{1}));       // ==> [1]

// Deserialization
        int int1 = gson.fromJson("{1}", int.class);
        Integer Integer1 = gson.fromJson("1", Integer.class);
        Long Long1 = gson.fromJson("1", Long.class);
        Boolean Boolean1 = gson.fromJson("false", Boolean.class);
        String String1 = gson.fromJson("\"abc\"", String.class);
        String[] StringArr1 = gson.fromJson("[abc]", String[].class);
    }
}
