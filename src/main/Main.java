package main;

import checker.Checker;
import com.fasterxml.jackson.core.util.DefaultIndenter;
import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import common.Constants;
import myclasses.Implementare;
import myclasses.Input;
import myclasses.AnnualChildren;

import java.io.File;
import java.io.IOException;

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
            for (int i = 1; i <= Constants.TESTS_NUMBER; i++) {
                    ObjectMapper objectMapper = new ObjectMapper();
                    Input input = objectMapper.readValue(new File(Constants.TEST_PATH + i
                            + Constants.FILE_EXTENSION), Input.class);
                    objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
                    DefaultPrettyPrinter prettyPrinter = new DefaultPrettyPrinter();
                    prettyPrinter.indentArraysWith(DefaultIndenter.SYSTEM_LINEFEED_INSTANCE);

                    Implementare imp = new Implementare();
                    AnnualChildren aC = imp.start(input);
                    objectMapper.writeValue(new File(Constants.OUTPUT_PATH + i
                            + Constants.FILE_EXTENSION), aC);
            }
            Checker.calculateScore();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
