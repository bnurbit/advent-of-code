package pt.bnurbit.puzzle.adventofcode.y2015;

import pt.bnurbit.puzzle.adventofcode.utils.Utils;

import java.util.ArrayList;
import java.util.List;

public class Ex3 {

    private static final boolean HAS_ROBOT = true;

    public static void main(String[] args) {

        String testData = Utils.getResourceFileAsString("2015/ex3");
        assert testData != null;

        char [] data = testData.toCharArray();

        int xSanta = 0;
        int ySanta = 0;
        int xRobot = 0;
        int yRobot = 0;

        List<String> positions = new ArrayList<>();
        positions.add(toPosition(xSanta,ySanta));

        int counter = 0;
        for(char c : data){
            counter++;
            boolean isSanta = HAS_ROBOT && counter % 2 != 0;

            switch (c){
                case '>':
                    if(isSanta){
                        xSanta++;
                    }else {
                        xRobot++;
                    }
                    break;
                case '<':
                    if(isSanta){
                        xSanta--;
                    }else {
                        xRobot--;
                    }
                    break;
                case '^':
                    if(isSanta){
                        ySanta++;
                    }else {
                        yRobot++;
                    }
                    break;
                case 'v':
                    if(isSanta){
                        ySanta--;
                    }else {
                        yRobot--;
                    }
                    break;
                default:
                    break;
            }

            String position = toPosition( isSanta ? xSanta : xRobot, isSanta ? ySanta : yRobot);
            if(!positions.contains(position)){
                positions.add(position);
            }
        }
        System.out.println("Total houses: " + positions.size());
    }

    private static String toPosition(int x, int y){
        return x + "-" + y;
    }
}
