package plugin;

import core.Language;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class JapaneseLanguage implements Language {

    private static final Map<String, String> words = new HashMap<>();

    @Override
    public String sayHello(String name) {
        return "Konichiwa " + name;
    }

    @Override
    public void loadFromJson() throws IOException, ParseException {
        String path = "Japanese/src/main/resources/ja-vi.json";
        FileInputStream is = new FileInputStream(path);

        Object obj = new JSONParser().parse(new InputStreamReader(is, StandardCharsets.UTF_8));

        if (obj instanceof JSONArray ja) {
            for (Object item : ja) {
                if (item instanceof JSONObject jo) {
                    String target = (String) jo.get("target");
                    String definition = (String) jo.get("definition");
                    words.put(target, definition);
                }
            }
        }
    }


    @Override
    public String lookup(String word) {
        return words.get(word);
    }

    @Override
    public String name() {
        return "Japanese";
    }
}
