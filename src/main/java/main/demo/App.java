package main.demo;

import core.Language;

import java.io.File;
import java.io.FileReader;
import java.util.Properties;

public class App {

    public static final String DEFAULT_LANGUAGE_PLUGIN_FILE_PATH = "English/build/libs/EnglishLanguage-1.0-SNAPSHOT.jar";
    public static final String JAPANESE_LANGUAGE_PLUGIN_FILE_PATH = "Japanese/build/libs/JapaneseLanguage-1.0-SNAPSHOT.jar";
    public static void main(String[] args) {
        try {
            Properties properties = new Properties();
            String path = new File("src/main/resources/application.properties").getAbsolutePath();
            properties.load(new FileReader(path));
            properties.forEach((key, value) -> {
                if (key.toString().startsWith("app.modules.")) {
                    PluginManager.loadPlugin(value.toString());
                    PluginManager.get(Language.class).sayHello("Some people " + key);
                }
            });

            PluginManager.loadPlugin(DEFAULT_LANGUAGE_PLUGIN_FILE_PATH);
            sayHello("Nguyen Le My Chau");

            PluginManager.loadPlugin(JAPANESE_LANGUAGE_PLUGIN_FILE_PATH);
            sayHello("Nguyen Le My Chow");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    private static void sayHello(String name) {
        System.out.println(PluginManager.get(Language.class).sayHello(name));
    }

}
