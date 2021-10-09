package com.cleancode.Parser;

import java.util.*;

import com.cleancode.Models.Entry;
import com.cleancode.Models.Item;

public interface ParserImpl {
    List<Entry> parse();
    Integer translate(Item item);
}
