package pt.bnurbit.puzzle.adventofcode.y2015;

import pt.bnurbit.puzzle.adventofcode.utils.Utils;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

public class Ex4 { // TODO

    public static void main(String[] args) throws NoSuchAlgorithmException {

        String testData = Utils.getResourceFileAsString("2015/ex4");
        assert testData != null;

        String test = "abcdef609043";
        byte[] bytesOfMessage = test.getBytes(StandardCharsets.UTF_8);

        MessageDigest md = MessageDigest.getInstance("MD5");
        byte[] digest = md.digest(bytesOfMessage);

        System.out.println("MD5 hash: "+ Arrays.toString(digest));
    }
}
