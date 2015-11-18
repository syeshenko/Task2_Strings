package kz.epam.task2.strings.entity.impl;

import kz.epam.task2.strings.entity.SentenceElement;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Stas Yechshenko on 17/11/15.
 */
public class Text {

    private List<Sentence> sentences;

    public Text() {
        sentences = new ArrayList<>();
    }

    public List<Sentence> getSentences() {
        return sentences;
    }

    public void addSentence(Sentence sentence) {
        sentences.add(sentence);
    }

    public String print() {
        StringBuilder sb = new StringBuilder();
        for (Sentence sentence : this.getSentences()) {
            for (SentenceElement element : sentence.getElements()) {
                sb.append(element.getValue());
            }
        }
        return sb.toString();
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        for (Sentence sentence : sentences) {
            sb.append(sentence.toString());
        }
        return sb.toString();
    }


}
