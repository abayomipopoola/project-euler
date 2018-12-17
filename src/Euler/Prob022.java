package Euler;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by Abayomi on 10/08/2016.
 */
public class Prob022 {
    public static void main(String[] args) {

        List<String> lines = null;
        try {
            lines = Files.readAllLines(FileSystems.getDefault().getPath("/Users/Abayomi/Documents/TeamApt/repos/Algorithms/src/Euler/input.txt"), StandardCharsets.UTF_8);
        } catch (IOException e) {
            e.printStackTrace();
        }
        //for (String line : lines) System.out.println(line);
        List<String> lineAsArr = new ArrayList<>(Arrays.asList(lines.get(0).split(",")));
        System.out.println(lineAsArr.size());
        //sort the list
        Collections.sort(lineAsArr);
        System.out.println(solve(lineAsArr));
    }

    static int solve(List<String> list){
        int sum = 0;
        for (int i = 0, len = list.size(); i < len; i++)
            sum += calculateWordSum(list.get(i)) * (i+1);
        return sum;
    }
    static int calculateWordSum(String evalStr){
        char [] str = evalStr.toCharArray();
        int sum = 0;
        for (int i = 1, len = str.length-1; i < len; i++)
            sum += (int)str[i] % 32;          // Convert char to int value, no matter the case.
        return sum;
    }
}
