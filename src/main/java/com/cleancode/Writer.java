package com.cleancode;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;

public class Writer {

    private String filename;
    private File file;

    public Writer(String filename){
        this.filename = filename;
        this.file = new File(filename);
    }

    public Writer(){
        this.filename = String.format(Const.OUTPUT_FILE, System.currentTimeMillis());
        this.file = new File(filename);
    }


    private void createFile() throws IOException{
        this.file.createNewFile();
    }


    public void writeContent(String content){
        FileWriter fileWriter = null;
        try{
            createFile();
            fileWriter = new FileWriter(file, true);
            fileWriter.write(content);
        }catch(IOException e){
            System.err.println("Cannot create file");
        }finally{
            if (fileWriter != null){
                try {
                    fileWriter.close();
                } catch (IOException e) {
                    System.err.println("Cannot close file");
                    e.printStackTrace();
                }
            }
        }

    }
}
