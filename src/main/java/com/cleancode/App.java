package com.cleancode;

import java.io.IOException;
import java.lang.System.Logger;
import java.util.List;

/**
 * Hello world!
 *
 */
public class App
{
    public static void main( String[] args )
    {

        Reader reader = new Reader("./entry (1).txt");
        try{
            String content = reader.getFileContent();
            File file = new File(content, reader.getNbrLine());
            Parser parser = new Parser(file);
            List<Entry> entries = parser.parse();
            for (Entry entry : entries){
                StringBuilder stringBuilder = new StringBuilder();
                for (Item item : entry.getItems()){
                    stringBuilder.append(parser.translate(item));
                }
                Code code = new Code(stringBuilder.toString());
                System.out.println(code);
            }


        }catch(IOException e){
            e.printStackTrace();
        }
    }
}
