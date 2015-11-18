package kz.epam.task2.strings.entity.impl;


import kz.epam.task2.strings.entity.SentenceElement;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Stas Yechshenko on 17/11/15.
 */
public class Word implements SentenceElement {

    private List<Letter> letters = new ArrayList<>();

    public Word() {
    }

    public Word(String word) {
        if (word != null) {
            for (int i = 0; i < word.length(); i++) {
                letters.add(new Letter(word.charAt(i)));
            }
        }
    }

    public void addLetter(Letter l) {
        letters.add(l);
    }

    @Override
    public String getValue() {
        String result = "";
        for (Letter letter : letters) {
            result += letter;
        }
        return result;
    }

    @Override
    public char charByIndex(int index) {
        return letters.size() > 0 ? letters.get(index).getLetter() : null;
    }

    @Override
    public int length() {
        return letters.size();
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Word{");
        sb.append("letters=");
        for (Letter lett : letters) {
            sb.append(lett.toString());
        }
        sb.append('}');
        return sb.toString();
    }
}
