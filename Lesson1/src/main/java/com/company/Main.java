/**
 * Created by Kostya Goloveshko on 25.09.2015.
 */

package com.company;

import java.io.*;
import java.net.URISyntaxException;
import java.util.ArrayList;

public class Main {

    public static ArrayList<String> mergeTwoSortedLists(ArrayList<String> firstList, ArrayList<String> secondList){
        ArrayList<String> resultList = new ArrayList<String>(firstList.size()+secondList.size());

        int indexOfFirstList = 0;
        int indexOfSecondList = 0;

        Integer nextValue;

        while ((indexOfFirstList < firstList.size()) || (indexOfSecondList < secondList.size())) {
            if (indexOfFirstList == firstList.size()) {
                nextValue = Integer.parseInt(secondList.get(indexOfSecondList++));
            } else if (indexOfSecondList == secondList.size()) {
                nextValue = Integer.parseInt(firstList.get(indexOfFirstList++));
            } else if (Integer.parseInt(firstList.get(indexOfFirstList)) <= Integer.parseInt(secondList.get(indexOfSecondList))) {
                nextValue = Integer.parseInt(firstList.get(indexOfFirstList++));
            } else {
                nextValue = Integer.parseInt(secondList.get(indexOfSecondList++));
            }
            resultList.add(nextValue.toString());
        }
        return resultList;
    }


    public static void main(String[] args) throws IOException,URISyntaxException {
        ArrayList<String> firstList = FileArrayProvider.readLines("./FirstInputList.dat");
        ArrayList<String> secondList = FileArrayProvider.readLines("./SecondInputList.dat");
        ArrayList<String> resultList = mergeTwoSortedLists(firstList, secondList);

        FileArrayProvider.putLines("./Output/ResultList", resultList);
    }
}
