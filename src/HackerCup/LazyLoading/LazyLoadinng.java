package HackerCup.LazyLoading;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Admin on 1/7/2017.
 */
public class LazyLoadinng {
    public static void main(String[] args) {
        solve();
    }

    static void solve(){
        Path fileOutput = Paths.get("/Users/Admin/Documents/Code/Algorithms/src/HackerCup/LazyLoading/output.txt");
        List<String> lines = null;
        List<String> outputLines = new ArrayList<>();
        try {
            lines = Files.readAllLines(FileSystems.getDefault().getPath("/Users/Admin/Documents/Code/Algorithms/src/HackerCup/LazyLoading/lazy_loading.txt"), StandardCharsets.UTF_8);
        } catch (IOException e) {
            e.printStackTrace();
        }
        int ii = 1;
        for (int i = 1; i <= Integer.parseInt(lines.get(0)); i++) {
            int  totCount = Integer.parseInt(lines.get(ii));
            ii++;
            int[] array = new int[totCount];
            for (int j = 0; j < totCount; j++) {
                array[j] = Integer.parseInt(lines.get(ii));
                ii++;
            }
            System.out.println("Case #"+i+": " + getLazyCount(array));
            outputLines.add("Case #"+i+": " +  getLazyCount(array));
        }

        try {
            Files.write(fileOutput, outputLines, StandardCharsets.UTF_8, StandardOpenOption.CREATE, StandardOpenOption.APPEND);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static int getLazyCount(int[] array) {
        int ans = 0;
        Arrays.sort(array);

        while(true){
            double item = array[array.length-1];
            int[] arrayMinus = new int[array.length-1];
            System.arraycopy( array, 0, arrayMinus, 0, array.length - 1 );
            array = arrayMinus;
            if(item < 50){
                double times  = Math.ceil(50 / item) - 1;
                if(times > array.length) { break; }
                int[] newarray = new int[array.length-(int)times];
                System.arraycopy( array, (int)times, newarray, 0, array.length-(int)times );
                array = newarray;
            }
            ans++;
            if(array.length == 0) { break; }
        }

        return ans;
    }
}

