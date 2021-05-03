package pt.bnurbit.puzzle.adventofcode.y2015;

import pt.bnurbit.puzzle.adventofcode.utils.Utils;

public class Ex1 {

    public static void main(String[] args) {

        String testData = Utils.getResourceFileAsString("2015/ex1");
        assert testData != null;

        char[] data = testData.toCharArray();

        boolean firstBasement = false;
        int counter =0;
        int level = 0;
        for(char c : data){
            counter++;

            if(c == '('){
                level++;
            }else if(c== ')'){
                level --;
            }

            //basement
            if(level < 0 && !firstBasement){
                firstBasement = true;
                System.out.println("Basement at position: " + counter);
            }
        }
        System.out.println(level);
    }
}
