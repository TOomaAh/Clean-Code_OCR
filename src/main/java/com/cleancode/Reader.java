package com.cleancode;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Reader  {

    private String filename;
    private File file;


    public Reader(String filename){
        this.filename = filename;
        this.file = new File(filename);
    }


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

        return stringBuilder.toString();
    }

    public Integer getNbrLine() throws IOException{
        InputStream inputStream = new FileInputStream(file);
        Integer count = 0;
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
