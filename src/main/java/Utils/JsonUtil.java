package Utils;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.jayway.jsonpath.JsonPath;

import java.util.ArrayList;
import java.util.Map;

public class JsonUtil {
    public static JsonObject generateJsonFromHashMap(Map<String, Object> data) {
        JsonObject jsonObject = new JsonObject();
        for (Map.Entry<String, Object> field : data.entrySet()) {
            jsonObject.addProperty(field.getKey(), field.getValue().toString());
        }
        return jsonObject;
    }

    public static ArrayList<Object> parse(String haystack, String jsonPath) {
        return JsonPath.read(haystack,jsonPath);
    }

    public static JsonObject generateJsonFromString(String jsonString ) {
        return new JsonParser().parse(jsonString).getAsJsonObject();
    }

    public static JsonObject editJson(JsonObject input, String key, String value) {
        JsonElement je = new Gson().fromJson(input.toString(), JsonElement.class);
        JsonObject jo = je.getAsJsonObject();
        jo.addProperty(key,value);
        return jo;
    }

    public static String objectToJsonString(Object o) {
        Gson gson = new Gson();
        return gson.toJson(o);
    }
}
