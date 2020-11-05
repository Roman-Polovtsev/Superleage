package com.company;
import java.lang.Math;
import java.util.ArrayList;
import java.util.List;

public class Exceptions {

    private int integer1;
    private int integer2;
    private String string ;
    private List<Integer> intList;

    public int getInteger1() {
        return integer1;
    }

    public Exceptions(){
      //do nothing
    }

    public String getString() {
        return string;
    }

    public int getInteger2() {
        return integer2;
    }

    public Long TryNumberFormatException (String a ) throws NumberFormatException{
         return  Long.parseLong(a);
    }

    public void TryOutOfMemoryError (Object obj){
        Integer i = integer1;
        intList = new ArrayList<>();
        for (int z = Integer.MIN_VALUE; z< Integer.MAX_VALUE;z++)
            intList.add(z);
    }

    public void TryStackOverflow (int b){
          TryStackOverflow(String.valueOf(b));
    }

    public void TryStackOverflow (String c){
         TryStackOverflow(Integer.parseInt(c));
    }

    public void TryArithmeticException (int c){
           Math.log10(c/0);
    }

    public void tryArrayIndexOutOfBoundsAndIllegalArgument (int index, String str){
        int innerIndex = -2;
        List <String> innerList = new ArrayList<>();
        innerList.add(innerIndex,str.repeat(innerIndex));
    }

    public void tryNullPointerException (int index){
        int innerIndex = -2;
        intList.add(innerIndex);
    }

}
