package com.cleancode.Models;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.cleancode.Const;
import com.cleancode.Reader.Reader;

public class File{

    private String content;
    private Integer nbrLine;

    public File(String content, Integer nbrLine){
        this.content = content;
        this.nbrLine = nbrLine;
    }

    public File(Reader reader) throws IOException{
        this.content = reader.getFileContent();
        this.nbrLine = reader.getNbrLine();
    }

    public char[] getEntry(Integer index){
        if (index > getNbrEntry()){
            return new char[0];
        }
        return Arrays.copyOfRange(content.replace("\n", "").toCharArray(), index * Const.MAX_COLS * Const.ROWS, (index + 1) * Const.MAX_COLS * Const.ROWS );
    }


    public Integer getNbrEntry(){
        return this.nbrLine / Const.ROWS;
    }

}