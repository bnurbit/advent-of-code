package pt.bnurbit.puzzle.adventofcode.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.stream.Collectors;

public final class Utils {

    private Utils() {}

    /**
     * Reads given resource file as a string.
     *
     * @param fileName path to the resource file
     * @return the file's contents
     */
    public static String getTestDataAsString(String fileName) {
        var classLoader = Utils.class.getClassLoader();
        try (InputStream is = classLoader.getResourceAsStream(fileName)) {
            if (is == null) {
                return null;
            }
            try (var isr = new InputStreamReader(is);
                var reader = new BufferedReader(isr)) {
                return reader.lines().collect(Collectors.joining(System.lineSeparator()));
            }
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * Reads given resource file as a char array.
     *
     * @param fileName path to the resource file
     * @return the file's contents
     */
    public static char[] getTestDataAsCharArray(String fileName){
        var testData = getTestDataAsString(fileName);
        assert testData != null;
        return testData.toCharArray();
    }

    /**
     * Reads given resource file as a string array.
     *
     * @param fileName path to the resource file
     * @return the file's contents
     */
    public static String[] getTestDataAsRows(String fileName){
        var testData = getTestDataAsString(fileName);
        assert testData != null;
        return testData.split(System.lineSeparator());
    }
}
