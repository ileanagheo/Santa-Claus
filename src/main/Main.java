package main;

import checker.Checker;
import com.fasterxml.jackson.core.util.DefaultIndenter;
import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import myclasses.*;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Class used to run the code
 */
public final class Main {

    private Main() {
        ///constructor for checkstyle
    }
    /**
     * This method is used to call the checker which calculates the score
     * @param args
     *          the arguments used to call the main method
     */
    public static void main(final String[] args) {

        try {
            for (int i = 1; i <= 25; i++) {
                ObjectMapper objectMapper =  new ObjectMapper();
                Input input = objectMapper.readValue(new File("tests/test" + i + ".json"), Input.class);
                objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
                DefaultPrettyPrinter prettyPrinter = new DefaultPrettyPrinter();
                prettyPrinter.indentArraysWith(DefaultIndenter.SYSTEM_LINEFEED_INSTANCE);

                Implementare imp = new Implementare();
                AnnualChildren aC = imp.incep(input);
                objectMapper.writeValue(new File("output/out_" + i + ".json"), aC);
            }
            Checker.calculateScore();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Checker.calculateScore();
    }
}
