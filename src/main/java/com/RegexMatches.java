package com;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Jalen.Deng
 * @description
 * @date
 **/

public class RegexMatches {

    public static void main(String args[]) {
       String list="a ; b ; c ;";
        String[] split = list.split(";");
        List<String> newList = new ArrayList<String>();
        for(int i=0;i<split.length;i++){
            newList.add(split[i].trim());
        }
        System.out.println(newList.get(0).equals("a"));

    }

}
