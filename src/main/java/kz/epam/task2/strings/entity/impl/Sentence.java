package kz.epam.task2.strings.entity.impl;

import kz.epam.task2.strings.entity.SentenceElement;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Stas Yechshenko on 17/11/15.
 */
public class Sentence {

    private List<SentenceElement> elements;

    public Sentence() {
        elements = new ArrayList<>();
    }

    public List<SentenceElement> getElements() {
        return elements;
    }

    public int getWordCount() {
        int result = 0;
        for (SentenceElement element : elements) {
            if (element instanceof Word) {
                result++;
            }
        }
        return result;
    }

    public int getSymbolCount() {
        int result = 0;
        for (SentenceElement element : elements) {
            if (element instanceof Symbol) {
                result++;
            }
        }
        return result;
    }

    public void addElement(SentenceElement element) {
        elements.add(element);
    }

    public String getValue() {
        final StringBuilder sb = new StringBuilder();
        for (SentenceElement element : elements) {
            sb.append(element.getValue());
        }
        return sb.toString();
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        for (SentenceElement element : elements) {
            sb.append(element.toString());
        }
        return sb.toString();
    }

}
