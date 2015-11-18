package kz.epam.task2.strings.entity.impl;

/**
 * Created by Stas Yechshenko on 17/11/15.
 */
public class Letter {

    private char letter;

    public Letter(char c) {
        this.letter = c;
    }

    public char getLetter() {
        return letter;
    }

    @Override
    public String toString() {
        return String.valueOf(letter);
    }
}
