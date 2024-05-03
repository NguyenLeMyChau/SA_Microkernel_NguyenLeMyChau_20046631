package main.controllers;
import core.Language;
import main.demo.App;
import main.demo.PluginManager;
import main.models.LanguageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

import org.json.simple.parser.ParseException;

@Controller
@RequestMapping("/language")
public class LanguageController {

    @GetMapping("/")
    public String showDictionary() {
        return "dictionary";
    }

    @PostMapping("/word")
    @ResponseBody
    public String selectLanguage(@RequestBody LanguageRequest request) throws IOException, ParseException {
        String pluginPath;

        // Xác định plugin nào sẽ được sử dụng
        if ("Japanese".equalsIgnoreCase(request.getLanguage())) {
            pluginPath = App.JAPANESE_LANGUAGE_PLUGIN_FILE_PATH;
        } else {
            pluginPath = App.DEFAULT_LANGUAGE_PLUGIN_FILE_PATH;
        }


        // Tải plugin và thực hiện hành động
        PluginManager.loadPlugin(pluginPath);

        PluginManager.get(Language.class).loadFromJson();

        return PluginManager.get(Language.class).lookup(request.getWord());
        
    }


}

