package com.cleancode.Parser;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.cleancode.App;
import com.cleancode.Const;
import com.cleancode.Models.Entry;
import com.cleancode.Models.File;
import com.cleancode.Models.Item;

public class Parser implements ParserImpl {

    private File file;

    public Parser(File file){
        this.file = file;
    }

    private Integer getIndex2DArrayTo1DArray(Integer i, Integer j){
        return (i * Const.MAX_COLS) + j;
    }

    private Integer getNextItemPosition(Integer start){
        return start * Const.COLS + Const.COLS;
    }

    private Integer getStartItemPosition(Integer nbrEntry){
        return nbrEntry * Const.COLS;
    }

    @Override
    public List<Entry> parse() {
        List<Item> items = new ArrayList<>();
        List<Entry> entries = new ArrayList<>();

        List<Character> number = new ArrayList<>();
        Integer nbrEntry = file.getNbrEntry();
        if (nbrEntry > Const.MAX_ENTRIES){
            Logger.getLogger(App.class.getName()).log(Level.SEVERE,"Too many codes (max: 100)");
            System.exit(-1);
        }

        for (int l = 0; l < nbrEntry; l ++){
            for (int k = 0 ; k < Const.MAX_NUMBER_PER_ENTRY ; k ++){
                int nextItem = getNextItemPosition(k);
                int startItem = getStartItemPosition(k);
                for (int i = 0; i < Const.ROWS ; i ++){
                    for (int j = startItem ; j < nextItem; j ++){
                        char[] allCode = file.getEntry(l);
                        char letter = allCode[getIndex2DArrayTo1DArray(i, j)];
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
