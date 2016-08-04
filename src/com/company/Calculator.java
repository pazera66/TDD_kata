package com.company;


import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

/**
 * Created by karol on 03.08.16.
 */
public class Calculator {

    public Calculator(){};

    public int add(String numbers){
        if(numbers.equals("")){return 0;}

        int result = 0;

        String[] stringArray = numbers.split(",|\n");

        try{
            Integer.parseInt(stringArray[0]);
        } catch (Exception e){

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
            String test2 = delimiter.toString();


            //TODO poprawić Pattern quote;
            String[] stringArrayWithNewDelim = stringArray[1].split(Pattern.quote(test2));
            //String[] stringArrayWithNewDelim = stringArray[1].split(test2);
//            String[] testArray = stringArray[1].split(test2);

                StringBuilder message = new StringBuilder().append("");

                for (int i = 0; i < stringArrayWithNewDelim.length; i++) {
                    if (Integer.parseInt(stringArrayWithNewDelim[i]) < 0) {
                        message.append(" " + stringArrayWithNewDelim[i]);
                    }
                    if(Integer.parseInt(stringArrayWithNewDelim[i])<1000){
                        result += Integer.parseInt(stringArrayWithNewDelim[i]);
                    }

                }
                String test = message.toString();

                if(!test.equals("")) {
                    throw new IllegalArgumentException("Negatives not allowed:" + test);
                }


            return result;
        }

        for(int i = 0; i<stringArray.length;i++){
            if(Integer.parseInt(stringArray[i])<1000){
                result+=Integer.parseInt(stringArray[i]);
            }

        }

    return result;
    }


}
