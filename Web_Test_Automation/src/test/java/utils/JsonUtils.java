package utils;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class JsonUtils {


    public static JsonNode parseJSON(String filePath) {
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode jsonNode = null;
        try {
            jsonNode = objectMapper.readTree(new File(filePath));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return jsonNode;
    }
}
