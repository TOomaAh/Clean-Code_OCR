package com.cleancode;

import java.util.ArrayList;
import java.util.List;

public class Item {
    private List<Character> items;

    public Item(List<Character> items){
        this.items = items;
    }


    public Character getAt(Integer index){
        return this.items.get(index);
    }

    public List<Integer> getCharPosition(){
        List<Integer> positions = new ArrayList<>();
        for (int i = 0; i < items.size(); i ++){
            Character c = items.get(i);
            if (c.equals(Const.PIPE) || c.equals(Const.UNDERSCORE)){
                positions.add(i);
            }
        }
        return positions;
    }

    @Override
    public String toString() {
        return items.toString();
    }
}
