package pt.bnurbit.puzzle.adventofcode.y2015;

import pt.bnurbit.puzzle.adventofcode.utils.Utils;

import java.util.Arrays;

public class Ex2 {

    public static void main(String[] args) {

        String testData = Utils.getResourceFileAsString("2015/ex2");
        assert testData != null;

        String [] dimensions = testData.split("\r\n");

        int totalPaper = 0;
        int totalRibbon = 0;
        for(String s : dimensions){

            String[] lwh = s.split("x");
            int l = Integer.parseInt(lwh[0]);
            int w = Integer.parseInt(lwh[1]);
            int h = Integer.parseInt(lwh[2]);

            int [] sides = new int[]{l,w,h};
            Arrays.sort(sides);

            int lw = l*w;
            int wh = w*h;
            int hl = h*l;

            totalPaper += 2*lw + 2*wh + 2*hl + sides[0]*sides[1];
            totalRibbon += 2*sides[0]+2*sides[1] + lw*h;
        }
        System.out.println("Total paper: " + totalPaper);
        System.out.println("Total ribbon: " + totalRibbon);
    }
}
