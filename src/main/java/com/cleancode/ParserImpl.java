package com.cleancode;

import java.util.*;

public interface ParserImpl {
    List<Entry> parse();
    Integer translate(Item item);
}
