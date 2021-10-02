package com.cleancode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Parser implements ParserImpl {

    private File file;

    public Parser(File file){
        this.file = file;
    }

    @Override
    public List<Entry> parse() {
        List<Item> items = new ArrayList<>();
        List<Entry> entries = new ArrayList<>();

        List<Character> number = new ArrayList<>();
        for (int l = 0; l < file.getNbrCode(); l ++){
            for (int k = 0 ; k < 9 ; k ++){
                for (int i = 0; i < Const.ROWS ; i ++){
                    for (int j = k * Const.COLS ; j < k * Const.COLS + 3; j ++){
                        char[] allCode = file.getCode(l);
                        char letter = allCode[((i * Const.MAX_COLS) + j)];
                        number.add(letter);
                    }
                }
                items.add(new Item(number));
                number = new ArrayList<>();
            }
            entries.add(new Entry(items));
            items = new ArrayList<>();

        }

        return entries;

    }

    @Override
    public Integer translate(Item item) {
        for (int i = 0; i < Const.NUMBERS.length; i ++){
            List<Integer> positions = item.getCharPosition();
            List<Integer> number = Arrays.asList(Const.NUMBERS[i]);
            if (positions.equals(number)){
                return i + 1;
            }
        }
        return -1;
    }
}
