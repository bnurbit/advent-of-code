package pt.bnurbit.puzzle.adventofcode.y2015;

import pt.bnurbit.puzzle.adventofcode.utils.Utils;

public class Ex6 {

    private static final boolean[][] lightsMatrix = new boolean[1000][1000];
    private static final int[][] lightsMatrix2 = new int[1000][1000];

    public static void main(String[] args) {

        String testData = Utils.getResourceFileAsString("2015/ex6");
        assert testData != null;

        String[] strings = testData.split("\r\n");

        part1(strings);
        countAndPrintLights(lightsMatrix);

        part2(strings);
        countAndPrintLightsBrightness(lightsMatrix2);
    }

    private enum LightsType {
        TOGGLE,
        TURN_ON,
        TURN_OFF,
        OTHER
    }

    static void part1(String[] strings){

        for (String s : strings) {

            LightsType operation = LightsType.OTHER;

            if (s.startsWith("toggle ")) {
                s = s.replace("toggle ", "");
                operation = LightsType.TOGGLE;
            } else if (s.startsWith("turn off ")) {
                s = s.replace("turn off ", "");
                operation = LightsType.TURN_OFF;
            } else if (s.startsWith("turn on ")) {
                s = s.replace("turn on ", "");
                operation = LightsType.TURN_ON;
            }
            s = s.replace(" through ", ",");
            String[] coordinates = s.split(",");

            int aX = Integer.parseInt(coordinates[0]);
            int aY = Integer.parseInt(coordinates[1]);
            int bX = Integer.parseInt(coordinates[2]);
            int bY = Integer.parseInt(coordinates[3]);


            switch (operation) {
                case TOGGLE:
                    for (int i = aX; i <= bX; i++) {
                        for (int j = aY; j <= bY; j++) {
                            lightsMatrix[i][j] = !lightsMatrix[i][j];
                        }
                    }
                    break;
                case TURN_ON:
                    for (int i = aX; i <= bX; i++) {
                        for (int j = aY; j <= bY; j++) {
                            lightsMatrix[i][j] = true;
                        }
                    }
                    break;
                case TURN_OFF:
                    for (int i = aX; i <= bX; i++) {
                        for (int j = aY; j <= bY; j++) {
                            lightsMatrix[i][j] = false;
                        }
                    }
                    break;
                default:
                    break;
            }
        }
    }

    static void part2(String[] strings){

        for (String s : strings) {

            LightsType operation = LightsType.OTHER;

            if (s.startsWith("toggle ")) {
                s = s.replace("toggle ", "");
                operation = LightsType.TOGGLE;
            } else if (s.startsWith("turn off ")) {
                s = s.replace("turn off ", "");
                operation = LightsType.TURN_OFF;
            } else if (s.startsWith("turn on ")) {
                s = s.replace("turn on ", "");
                operation = LightsType.TURN_ON;
            }
            s = s.replace(" through ", ",");
            String[] coordinates = s.split(",");

            int aX = Integer.parseInt(coordinates[0]);
            int aY = Integer.parseInt(coordinates[1]);
            int bX = Integer.parseInt(coordinates[2]);
            int bY = Integer.parseInt(coordinates[3]);


            switch (operation) {
                case TOGGLE:
                    for (int i = aX; i <= bX; i++) {
                        for (int j = aY; j <= bY; j++) {
                            lightsMatrix2[i][j] += 2;
                        }
                    }
                    break;
                case TURN_ON:
                    for (int i = aX; i <= bX; i++) {
                        for (int j = aY; j <= bY; j++) {
                            lightsMatrix2[i][j] += 1;
                        }
                    }
                    break;
                case TURN_OFF:
                    for (int i = aX; i <= bX; i++) {
                        for (int j = aY; j <= bY; j++) {
                            if(lightsMatrix2[i][j] > 0){
                                lightsMatrix2[i][j] -= 1;
                            }
                        }
                    }
                    break;
                default:
                    break;
            }
        }
    }

    static void countAndPrintLights(boolean[][] lightsMatrix){

        int nLights = 0;
        for (boolean[] matrix : lightsMatrix) {
            for (boolean b : matrix) {
                if (b) {
                    nLights++;
                }
            }
        }

        System.out.println("Lights on: " + nLights);
    }

    static void countAndPrintLightsBrightness(int[][] lightsMatrix){

        int lightBrightness = 0;
        for (int[] matrix : lightsMatrix) {
            for (int b : matrix) {
                lightBrightness += b;
            }
        }

        System.out.println("Total brightness: " + lightBrightness);
    }
}
