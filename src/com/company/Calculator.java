package com.company;


import org.apache.commons.lang3.math.NumberUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

/**
 * Created by karol on 03.08.16.
 */
public class Calculator {

    public Calculator(){}

    private int result = 0;

    public int add(String numbers) throws NegativeNumbersException {
        if(numbers.equals("")){return result;}

        String[] stringArray = numbers.split(",|\n");

        if(NumberUtils.isNumber(stringArray[0])){
            result = sum(convertToNumberArray(stringArray));
        }else{

            StringBuilder delimiter=extractDelimiters(stringArray);
            String[] stringArrayWithNewDelim = stringArray[1].split(delimiter.toString());
            List<Integer> numbersArray = convertToNumberArray(stringArrayWithNewDelim);
            checkForNegativeNumbers(numbersArray);
            return sum(numbersArray);
        }


    return result;
    }

    private StringBuilder extractDelimiters(String[] stringArray) {
        StringBuilder delimiter = new StringBuilder();
        List<String> list = new ArrayList<String>(){};

        if(stringArray[0].length()!=3){

            String[] mulitpleDelims = stringArray[0].split(Pattern.quote("["));

            for(int i =1; i<mulitpleDelims.length;i++){
                list.add(mulitpleDelims[i].substring(0,mulitpleDelims[i].length()-1));
            }

            for (String s:list) {
                delimiter.append(s+"|");
            }
            delimiter.deleteCharAt(delimiter.length()-1);
        } else {
            delimiter.append(stringArray[0].substring(2));
        }
        return delimiter;
    }

    private List<Integer> convertToNumberArray(String[] stringArray) throws NegativeNumbersException {

        List<Integer> numbersArray = new ArrayList<Integer>(){};
        for (String s : stringArray) {
            numbersArray.add(Integer.parseInt(s));
        }
        checkForNegativeNumbers(numbersArray);
        return numbersArray;
    }

    private void checkForNegativeNumbers(List<Integer> numbersArray) throws NegativeNumbersException {
        StringBuilder numbers = new StringBuilder();
        for(int number : numbersArray){
            if(number <0){
                numbers.append(" " + number);
            }

        }
        if(!numbers.toString().equals("")){
            throw new NegativeNumbersException("Negatives not allowed:" + numbers);
        }
    }


    private int sum(List<Integer> stringArray){
        for(int s:stringArray){
            if(Integer.parseInt(String.valueOf(s))<1000){
                result+=Integer.parseInt(String.valueOf(s));
            }

        }
        return result;
    }

}
