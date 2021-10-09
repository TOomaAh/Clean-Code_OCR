package com.cleancode.Reader;

import com.cleancode.App;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Reader implements ReaderImpl {

    private File file;


    public Reader(String filename){
        this.file = new File(filename);
    }


    @Override
    public String getFileContent() throws IOException{
        InputStream inputStream = new FileInputStream(file);
        StringBuilder stringBuilder = new StringBuilder();
        try (BufferedReader bReader = new BufferedReader(new InputStreamReader(inputStream))){
            String line;
            while ((line = bReader.readLine()) != null){
                if (line.length() != 0){
                    stringBuilder.append(line).append("\n");
                }
            }
        }finally {
            inputStream.close();
        }
        Logger.getLogger(App.class.getName()).log(Level.INFO, "File opened");
        return stringBuilder.toString();
    }

    @Override
    public Integer getNbrLine() throws IOException{
        InputStream inputStream = new FileInputStream(file);
        int count = 0;
        try (BufferedReader bReader = new BufferedReader(new InputStreamReader(inputStream))){
            String line;
            while ((line = bReader.readLine()) != null){
                if (line.length() != 0){
                    count += 1;
                }
            }
        }finally {
            inputStream.close();
        }

        return count;
    }
}
