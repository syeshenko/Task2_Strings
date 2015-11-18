package kz.epam.task2.strings.core;

import kz.epam.task2.strings.entity.SentenceElement;
import kz.epam.task2.strings.entity.impl.*;
import org.apache.log4j.Logger;

/**
 * Created by Stas Yechshenko on 17/11/15.
 */

public class Parser {

    private static final Logger logger = Logger.getLogger(Parser.class);

    public Text parser(String source) {
        logger.debug("== Start parsing text ==");
        logger.debug("Source text => " + source);
        Text text = new Text();
        if (source != null && source.length() > 0) {

            //remove all multi space and tabulation
            source = source.replaceAll("\\t|[\\s]{2,}", " ");

            //text parsing
            char[] chars = source.toCharArray();
            Sentence sentence = new Sentence();
            Word word = new Word();
            for (int i = 0; i < chars.length; i++) {
                if (Character.isDigit(chars[i]) || Character.isLetter(chars[i])) {
                    word.addLetter(new Letter(chars[i]));
                } else {
                    if (word.length() != 0) {
                        sentence.addElement(word);
                        word = new Word();
                    }
                    sentence.addElement(new Symbol(chars[i]));

                }
                if (String.valueOf(chars[i]).matches("[.?!]")) {
                    text.addSentence(sentence);
                    sentence = new Sentence();
                } else if (i == chars.length - 1) {
                    sentence.addElement(word);
                    text.addSentence(sentence);
                }
            }
        } else {
            logger.error("Input text must not be null.");
        }
        logger.debug("== Finish parse ==");
        return text;
    }
/* Задание:
    Из текста удалить все слова заданной длины, начинающиеся на согласную букву.
 */
        // task performance
    public Text removeWordByLenAndChar(Text text, char letter, int length) {
        Text result = new Text();
        for (Sentence sentence : text.getSentences()) {
            Sentence s = new Sentence();
            for (SentenceElement element : sentence.getElements()) {
                if (element instanceof Word) {
                    if (element.length() > 0) {
                        if (element.charByIndex(0) != letter) {
                            s.addElement(element);
                        } else if (element.length() > length || element.length() < length) {
                            s.addElement(element);
                        }
                    }
                } else {
                    s.addElement(element);
                }
            }
            result.addSentence(s);
        }
        return result;
    }


}
