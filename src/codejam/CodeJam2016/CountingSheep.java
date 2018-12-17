package codejam.CodeJam2016;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by Abayomi on 21/08/2016.
 */
public class CountingSheep {
    public static void main(String[] args) {
        solve();
    }

    static void solve(){
        Path fileOutput = Paths.get("/Users/Abayomi/Documents/TeamApt/repos/Algorithms/src/codejam/CodeJam2016/output.txt");
        List<String> lines = null;
        List<String> outputLines = new ArrayList<>();
        try {
            lines = Files.readAllLines(FileSystems.getDefault().getPath("/Users/Abayomi/Documents/TeamApt/repos/Algorithms/src/codejam/CodeJam2016/input.txt"), StandardCharsets.UTF_8);
        } catch (IOException e) {
            e.printStackTrace();
        }

        for (int i = 1; i <= Integer.parseInt(lines.get(0)); i++) {
           // System.out.println("Case #"+i+": " + countingNo(Integer.parseInt(lines.get(i))));
             outputLines.add("Case #"+i+": " + countingNo(Integer.parseInt(lines.get(i))));
        }

        try {
            Files.write(fileOutput, outputLines, StandardCharsets.UTF_8, StandardOpenOption.CREATE, StandardOpenOption.APPEND);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String countingNo(int val) {
        if(val == 0)
            return "INSOMNIA";
        Set<Integer> set = new HashSet<>();
        for (int item : changeInttoArr(val))
            set.add(item);
        for (int i = 2; ; i++) {
            for (int item : changeInttoArr(val*i)) {
                set.add(item);
            }
            if (set.toArray().length == 10){
                return ""+(val * i);
            }
        }
    }
    private static int[] changeInttoArr(int val) {
        int ind, count = 0;
        int [] arrVal = new int[new Integer(val).toString().length()];
        do {
            ind = val % 10;
            val /= 10;
            arrVal[count] = ind;
            count++;
        } while (val > 0);
        return arrVal;
    }
}
