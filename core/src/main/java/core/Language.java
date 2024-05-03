package core;

import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.IOException;

public interface Language extends Plugin{
    String sayHello(String name);

    void loadFromJson() throws IOException, ParseException;

    String lookup(String word);

}
