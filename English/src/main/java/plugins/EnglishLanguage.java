package plugins;

import core.Language;

public class EnglishLanguage implements Language {
    @Override
    public String sayHello(String name) {
        return "Hello, " + name;
    }

    @Override
    public String name() {
        return "English";
    }
}
