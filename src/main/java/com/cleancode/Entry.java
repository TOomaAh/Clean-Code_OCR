package com.cleancode;

import java.util.List;

public class Entry {
    private List<Item> items;

    public Entry(List<Item> items){
        this.items = items;
    }


    public List<Item> getItems(){
        return items;
    }
}
