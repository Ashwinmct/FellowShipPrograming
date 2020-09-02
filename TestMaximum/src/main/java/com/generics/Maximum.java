package com.generics;

import java.util.AbstractList;
import java.util.ArrayList;

public class Maximum<T extends Comparable> {
    private ArrayList<T> list=null;
    public Maximum(ArrayList<T> list) {
        this.list=list;
    }
    public T findMaxOf(){
        return findMaxOf(this.list);
    }
    public <T extends Comparable> T findMaxOf(ArrayList<T> elementsList){
        T max= elementsList.get(0);
        for(T element:elementsList)
            max=(element.compareTo(max)>0)?element:max;
        printMaximumOf(max);
        return max;
    }

    private <T extends Comparable> void printMaximumOf(T max) {
        System.out.println("Maximum of "+ this.list +" is :"+max);
    }
}

