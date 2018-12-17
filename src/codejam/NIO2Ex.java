package codejam;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;
import java.util.List;

/**
 * Created by Abayomi on 18/03/2016.
 */
public class NIO2Ex {
    public static void main(String[] args) {
        //Path fileInput = Paths.get("/Users/Abayomi/Documents/TeamApt/repos/Algorithms/src/codejam/input.txt");
        Path fileOutput = Paths.get("/Users/Abayomi/Documents/TeamApt/repos/Algorithms/src/codejam/output.txt");

        List<String> lines = null;
        try {
            lines = Files.readAllLines(FileSystems.getDefault().getPath("/Users/Abayomi/Documents/TeamApt/repos/Algorithms/src/codejam/input.txt"), StandardCharsets.UTF_8);
        } catch (IOException e) {
            e.printStackTrace();
        }

        for (String line : lines) System.out.println(line);

        try {
            Files.write(fileOutput, lines, StandardCharsets.UTF_8, StandardOpenOption.CREATE, StandardOpenOption.APPEND);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
