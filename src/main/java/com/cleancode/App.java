package com.cleancode;

import java.io.IOException;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 * Hello world!
 *
 */
public class App
{

    private static void checkHasArgs(String[] args){
        if (args.length < 1){
            LOGGER.log(Level.SEVERE, "Please specify file");
            System.exit(-1);
        }
    }

    private static final Logger LOGGER = Logger.getLogger( App.class.getName() );
    public static void main( String[] args )
    {

        checkHasArgs(args);
        try{
            OCR ocr = new OCR(args[0]);
            ocr.run();
        }catch(IOException e){
            Logger.getLogger(App.class.getName()).log(Level.SEVERE,"Cannot open your file");
            System.exit(-1);
        }
    }
}
