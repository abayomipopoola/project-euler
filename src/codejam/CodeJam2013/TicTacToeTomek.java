package codejam.CodeJam2013;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Abayomi on 18/03/2016.
 */
public class TicTacToeTomek {
    public static void main(String[] args) {
        solve();
    }

    static void solve(){
        Path fileOutput = Paths.get("/Users/Abayomi/Documents/TeamApt/repos/Algorithms/src/codejam/output.txt");
        List<String> lines = null;
        List<String> outputLines = new ArrayList<>();
        try {
            lines = Files.readAllLines(FileSystems.getDefault().getPath("/Users/Abayomi/Documents/TeamApt/repos/Algorithms/src/codejam/input.txt"), StandardCharsets.UTF_8);
        } catch (IOException e) {
            e.printStackTrace();
        }

        for (int i = 1, j = 1; i < Integer.parseInt(lines.get(0))*5; i+=5) {
            String line1 = lines.get(i), line2 = lines.get(i+1), line3 = lines.get(i+2), line4 = lines.get(i+3);
            char arr2D [][] = {line1.toCharArray(),line2.toCharArray(),line3.toCharArray(),line4.toCharArray()};

            //System.out.println("Case #"+j+": " + gameResult(arr2D));
            outputLines.add("Case #"+j+": " + gameResult(arr2D));
            j++;
        }

        try {
            Files.write(fileOutput, outputLines, StandardCharsets.UTF_8, StandardOpenOption.CREATE, StandardOpenOption.APPEND);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    static String gameResult(char arr2D [][]){
        String res = "undecided";

        for (int i = 0; i < 4; i++) {
            if(elemVal(arr2D [i][0]) + elemVal(arr2D [i][1]) + elemVal(arr2D [i][2]) + elemVal(arr2D [i][3]) == 4
                   || elemVal(arr2D [i][0]) + elemVal(arr2D [i][1]) + elemVal(arr2D [i][2]) + elemVal(arr2D [i][3]) == 103
                   || elemVal(arr2D [0][i]) + elemVal(arr2D [1][i]) + elemVal(arr2D [2][i]) + elemVal(arr2D [3][i]) == 4
                   || elemVal(arr2D [0][i]) + elemVal(arr2D [1][i]) + elemVal(arr2D [2][i]) + elemVal(arr2D [3][i]) == 103
                   || elemVal(arr2D [0][0]) + elemVal(arr2D [1][1]) + elemVal(arr2D [2][2]) + elemVal(arr2D [3][3]) == 4
                   || elemVal(arr2D [0][3]) + elemVal(arr2D [1][2]) + elemVal(arr2D [2][1]) + elemVal(arr2D [3][0]) == 4
                   || elemVal(arr2D [0][0]) + elemVal(arr2D [1][1]) + elemVal(arr2D [2][2]) + elemVal(arr2D [3][3]) == 103
                   || elemVal(arr2D [0][3]) + elemVal(arr2D [1][2]) + elemVal(arr2D [2][1]) + elemVal(arr2D [3][0]) == 103) res = "X won";

            else if(elemVal(arr2D [i][0]) + elemVal(arr2D [i][1]) + elemVal(arr2D [i][2]) + elemVal(arr2D [i][3]) == 20
                    || elemVal(arr2D [i][0]) + elemVal(arr2D [i][1]) + elemVal(arr2D [i][2]) + elemVal(arr2D [i][3]) == 115
                    || elemVal(arr2D [0][i]) + elemVal(arr2D [1][i]) + elemVal(arr2D [2][i]) + elemVal(arr2D [3][i]) == 20
                    || elemVal(arr2D [0][i]) + elemVal(arr2D [1][i]) + elemVal(arr2D [2][i]) + elemVal(arr2D [3][i]) == 115
                    || elemVal(arr2D [0][0]) + elemVal(arr2D [1][1]) + elemVal(arr2D [2][2]) + elemVal(arr2D [3][3]) == 20
                    || elemVal(arr2D [0][3]) + elemVal(arr2D [1][2]) + elemVal(arr2D [2][1]) + elemVal(arr2D [3][0]) == 20
                    || elemVal(arr2D [0][0]) + elemVal(arr2D [1][1]) + elemVal(arr2D [2][2]) + elemVal(arr2D [3][3]) == 115
                    || elemVal(arr2D [0][3]) + elemVal(arr2D [1][2]) + elemVal(arr2D [2][1]) + elemVal(arr2D [3][0]) == 115) res = "O won";

        }
        if(res == "undecided")
            for (int i = 0; i < 4; i++)
                if(arr2D [i][0] == '.' || arr2D [i][1] == '.' || arr2D [i][2] == '.' ||arr2D [i][3] == '.'
                        || arr2D [0][i] == '.' || arr2D [1][i] == '.' || arr2D [1][i] == '.' || arr2D [3][i] == '.') res = "Game has not completed";
        else res = "Draw";
        return res;
    }
    static int elemVal(char c){
        int retVal = 0;
        if (c == 'X') retVal = 1;
        else if (c == 'O') retVal = 5;
        else if (c == 'T') retVal = 100;
        else retVal = 0;
        return retVal;
    }
}
