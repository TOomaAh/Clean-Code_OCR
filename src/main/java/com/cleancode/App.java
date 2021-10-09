package com.cleancode;

import java.io.IOException;
import java.lang.System.Logger;
import java.security.Timestamp;
import java.util.ArrayList;
import java.util.List;

/**
 * Hello world!
 *
 */
public class App
{
    public static void main( String[] args )
    {
        Writer writer = new Writer();
        Reader reader = new Reader("./entry (1).txt");
        try{
            String content = reader.getFileContent();
            File file = new File(content, reader.getNbrLine());
            Parser parser = new Parser(file);
            List<Entry> entries = parser.parse();
            for (Entry entry : entries){
                List<Integer> codes = new ArrayList<>();
                for (Item item : entry.getItems()){
                    codes.add(parser.translate(item));
                }
                Code code = new Code(codes);
                writer.writeContent(code.toString());
            }
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}
