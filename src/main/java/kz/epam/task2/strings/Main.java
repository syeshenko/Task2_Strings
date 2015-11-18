package kz.epam.task2.strings;

import kz.epam.task2.strings.core.Parser;
import kz.epam.task2.strings.entity.impl.Text;
import org.apache.log4j.Logger;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Scanner;

/**
 * Created by Stas Yechshenko on 17/11/15.
 */
public class Main {

    private static final Logger logger = Logger.getLogger(Main.class);
    private static String fileName = "text.txt";

    public static void main(String[] args) {

        //loading text file
        String textFromFile = loadFile(fileName);

        //making parse
        Parser parser = new Parser();
        Text text = parser.parser(textFromFile);


        //remove words by given letter and length
        Text cleanedText = parser.removeWordByLenAndChar(text, 'н', 2);
        logger.debug("<<<< Text cleaning >>>>");
        logger.debug(cleanedText.print());
        logger.debug("<<<< Finish cleaning >>>>");
    }

    // file reading method
    private static String loadFile(String fileName) {
        logger.info("Try load file from resource => " + fileName);
        StringBuilder result = new StringBuilder("");
        ClassLoader classLoader = Main.class.getClassLoader();
        final URL resource = classLoader.getResource(fileName);
        if (resource != null) {
            File file = new File(resource.getFile());
            try (Scanner scanner = new Scanner(file)) {
                while (scanner.hasNextLine()) {
                    String line = scanner.nextLine();
                    result.append(line).append("\n");
                }

                scanner.close();

            } catch (IOException e) {
                logger.error("Error load file", e);
            }
        } else {
            logger.debug("Specified file not found");
        }

        return result.toString();

    }
}


