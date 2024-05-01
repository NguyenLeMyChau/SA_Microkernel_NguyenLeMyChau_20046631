package plugin;

import core.Language;

public class JapaneseLanguage implements Language {
    @Override
    public String sayHello(String name) {
        return "Konichiwa " + name;
    }

    @Override
    public String name() {
        return "Japanese";
    }
}
