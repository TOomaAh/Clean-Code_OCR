package com.cleancode.Writer;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.cleancode.App;
import com.cleancode.Const;

public class Writer implements WriterImpl {

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
        if (this.file.createNewFile()){
            Logger.getLogger(App.class.getName()).log(Level.INFO, String.format("File %s created", getFilename()));
        }
    }

    public String getFilename(){
        return filename;
    }

    @Override
    public void writeContent(String content){
        FileWriter fileWriter = null;
        try{
            createFile();
            fileWriter = new FileWriter(file, true);
            fileWriter.write(content);
        }catch(IOException e){
            Logger.getLogger(App.class.getName()).log(Level.SEVERE,"Cannot create file");
            System.exit(-1);
        }finally{
            if (fileWriter != null){
                try {
                    fileWriter.close();
                } catch (IOException e) {
                    Logger.getLogger(App.class.getName()).log(Level.SEVERE,"Cannot close file");
                    System.exit(-1);
                }
            }
        }

    }
}
