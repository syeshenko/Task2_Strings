package kz.epam.task2.strings.entity.impl;

import kz.epam.task2.strings.entity.SentenceElement;

/**
 * Created by Stas Yechshenko on 17/11/15.
 */
public class Symbol implements SentenceElement {

    private char symbol;

    public Symbol(char symbol) {
        this.symbol = symbol;
    }

    public char getSymbol() {
        return symbol;
    }

    @Override
    public String getValue() {
        return String.valueOf(symbol);
    }

    @Override
    public char charByIndex(int index) {
        return symbol;
    }

    @Override
    public int length() {
        return 1;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Symbol{");
        sb.append("symbol=").append(String.valueOf(symbol));
        sb.append('}');
        return sb.toString();
    }
}
