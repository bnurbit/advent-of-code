package pt.bnurbit.puzzle.adventofcode.y2015;

import pt.bnurbit.puzzle.adventofcode.utils.Utils;

import java.util.ArrayList;
import java.util.List;

public class Ex5 {

    private static int niceStrings1 = 0;
    private static int niceStrings2 = 0;

    public static void main(String[] args) {

        String testData = Utils.getResourceFileAsString("2015/ex5");
        assert testData != null;

        String [] strings = testData.split("\r\n");

        for(String s : strings){
            countNiceStringsPart1(s);
            countNiceStringsPart2(s);
        }
        System.out.println("Nice strings 1: "+ niceStrings1);
        System.out.println("Nice strings 2: "+ niceStrings2);
    }

    static void countNiceStringsPart1(String s){

        int nVowels = 0;
        boolean hasVowels = false;
        boolean letterTwice = false;

        char previousChar = '\t';
        for(char c : s.toCharArray()){
            if(c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u'){
                nVowels++;
            }

            if(c == previousChar){
                letterTwice = true;
            }
            previousChar = c;
        }
        if(nVowels > 2){
            hasVowels = true;
        }
        boolean containString = s.contains("ab") || s.contains("cd") || s.contains("pq") || s.contains("xy");

        if(hasVowels && letterTwice && !containString){
            niceStrings1++;
        }
    }

    static void countNiceStringsPart2(String s){

        char [] chars = s.toCharArray();

        boolean pairRepeated = false;
        boolean letterRepeated = false;
        List<String> pairs = new ArrayList<>();
        String previousPair = "";
        for(int i = 0; i < chars.length; i++){

            if(i >= 2 && !letterRepeated){
                letterRepeated = chars[i-2] == chars[i];
            }

            if(i >= 1){
                String pair = "" + chars[i-1] + chars[i];
                if(!pair.equals(previousPair)){
                    if(pairs.contains(pair)){
                        pairRepeated = true;
                    }
                    pairs.add(pair);
                }
                previousPair = pair;
            }
        }

        if(letterRepeated && pairRepeated ){
            niceStrings2++;
        }
    }
}
