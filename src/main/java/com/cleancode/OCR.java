package com.cleancode;

import com.cleancode.Models.Code;
import com.cleancode.Models.Entry;
import com.cleancode.Models.File;
import com.cleancode.Models.Item;
import com.cleancode.Parser.Parser;
import com.cleancode.Reader.Reader;
import com.cleancode.Writer.Writer;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class OCR {

    private Reader reader;
    private Parser parser;
    private Writer writer;

    public OCR(String filename) throws IOException{
        this.reader = new Reader(filename);
        this.parser = new Parser(new File(reader));
        this.writer = new Writer();
    }


    public OCR(Reader reader, Parser parser, Writer writer){
        this.reader = reader;
        this.parser = parser;
        this.writer = writer;
    }

    public void run(){
        List<Code> codes = getAllCode();
        writeResult(codes);
    }

    public List<Code> getAllCode(){
        List<Code> allCodes = new ArrayList<>();
        List<Entry> entries = parser.parse();
        for (Entry entry : entries){
            List<Integer> codes = new ArrayList<>();
            for (Item item : entry.getItems()){
                codes.add(parser.translate(item));
            }
            Code code = new Code(codes);
            allCodes.add(code);
        }
        Logger.getLogger(App.class.getName()).log(Level.INFO, String.format("%d codes found", allCodes.size()));
        return allCodes;
    }


    public void writeResult(List<Code> codes){
        for (Code code : codes) {
            writer.writeContent(code.format());
        }

        Logger.getLogger(App.class.getName()).log(Level.INFO, String.format("Result written in %s", writer.getFilename()));
    }
}
