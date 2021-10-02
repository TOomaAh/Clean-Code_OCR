package com.cleancode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class File{

    private String content;
    private Integer nbrLine;

    public File(String content, Integer nbrLine){
        this.content = content;
        this.nbrLine = nbrLine;
    }

    public char[] getCode(Integer index){
        if (index > getNbrCode()){
            return new char[0];
        }
        return Arrays.copyOfRange(content.replace("\n", "").toCharArray(), index * Const.MAX_COLS * Const.ROWS, (index + 1) * Const.MAX_COLS * Const.ROWS );
    }


    public Integer getNbrCode(){
        return this.nbrLine / Const.ROWS;
    }

}