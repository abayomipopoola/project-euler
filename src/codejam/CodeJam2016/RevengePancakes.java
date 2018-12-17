package codejam.CodeJam2016;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Abayomi on 21/08/2016.
 */
public class RevengePancakes {
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
          //  outputLines.add("Case #"+i+": " + countingNo(Integer.parseInt(lines.get(i))));
        }

        try {
            Files.write(fileOutput, outputLines, StandardCharsets.UTF_8, StandardOpenOption.CREATE, StandardOpenOption.APPEND);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
