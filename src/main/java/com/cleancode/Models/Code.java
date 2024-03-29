package com.cleancode.Models;

import java.util.List;

import com.cleancode.Const;

public class Code {

    private List<Integer> code;

    public Code(List<Integer> code){
        this.code = code;
    }

    public Boolean isCorrect(){
        return this.checksum();
    }

    private Boolean checksum(){
        int checksum = 0;
        int size = code.size() -1;
        for (int i = size; i >= 0 ; i --){
            checksum += code.get(i) * (code.size() - i);
        }
        return checksum % 11 == 0;
    }


    private Boolean hasUnreadableValue(String value){
        return value.contains(Const.ILL_VALUE);
    }

    public String format(){
        StringBuilder stringBuilder = new StringBuilder();
        for (Integer integer : code) {
            if (integer.equals(Const.INT_ERROR))
                stringBuilder.append(Const.ILL_VALUE);
            else
                stringBuilder.append(integer);
        }

        if (hasUnreadableValue(stringBuilder.toString())){
            stringBuilder.append(String.format("\t%s", Const.ILLISIBLE));
        }else{
            if (!isCorrect()){
                stringBuilder.append(String.format("\t%s", Const.ERROR));
            }
        }
        stringBuilder.append("\n");

        return stringBuilder.toString();
    }


    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (Integer integer : code) {
            stringBuilder.append(integer);
        }

        return stringBuilder.toString();
    }
}
