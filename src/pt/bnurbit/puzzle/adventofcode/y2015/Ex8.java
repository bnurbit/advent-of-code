package pt.bnurbit.puzzle.adventofcode.y2015;

import pt.bnurbit.puzzle.adventofcode.utils.Utils;

public class Ex8 {

    public static void main(String[] args) {
        String[] data = Utils.getTestDataAsRows("2015/ex8");
        part1(data);
        part2(data);
    }

    /**
     * Counting storage space.
     * Counting the number of characters of code for string literals minus the number of characters in memory for the values of the strings in total for the entire file.
     */
    private static void part1(String[] strings) {

        int nCharsLiterals = 0;
        int nCharsInMemory = 0;

        for (var s : strings) {
            nCharsLiterals += s.length();

            int size = 0;
            for(var c = 1; c < s.length() - 1;){
                char[] bytes = s.toCharArray();

                if(bytes[c] == '\\' && bytes[c+1] == 'x'){
                    c+=4;
                } else if(bytes[c] == '\\' && (bytes[c+1] == '\\' || bytes[c+1] == '\"')){
                    c+=2;
                } else{
                    c++;
                }
                size++;
            }
            nCharsInMemory += size;
        }

        System.out.println("Total: " + (nCharsLiterals - nCharsInMemory));
    }

    /**
     * Counting storage space.
     * Encode each code representation as a new string and find the number of characters of the new encoded representation, including the surrounding double quotes.
     */
    private static void part2(String[] strings) {

        int nCharsLiterals = 0;
        int nCharsInMemory = 0;

        for (var s : strings) {
            nCharsLiterals += s.length();

            int size = 6;
            for(var c = 1; c < s.length() - 1;){
                char[] bytes = s.toCharArray();

                if(bytes[c] == '\\' && bytes[c+1] == 'x'){
                    c+=4;
                    size+=5;
                } else if(bytes[c] == '\\' && (bytes[c+1] == '\\' || bytes[c+1] == '\"')){
                    c+=2;
                    size+=4;
                } else{
                    c++;
                    size++;
                }
            }
            nCharsInMemory += size;
        }

        System.out.println("Total: " + (nCharsInMemory - nCharsLiterals));
    }
}
