package Euler;

/**
 * Created by Abayomi on 12/08/2016.
 */
public class Prob28 {

    private static final int HEIGHT = 1001;
    private static final int MID_HEIGHT = (int) Math.floor(HEIGHT/2.0);
    private static final int WIDTH = 1001;
    private static final int MID_WIDTH = (int) Math.floor(WIDTH/2.0);

    public static void main(String[] args) {
        int [][] ans = fillSpiralArray();
        int diag1 = 0, diag2 = 0;
        for (int i = 0, len = ans.length-1; i <= len; i++) {
            diag1 += ans[i][i];
            diag2 += ans[i][len-i];
        }
        System.out.println(diag1 + diag2 + (HEIGHT*WIDTH) - 1);
        //print(ans);
    }

    static int[][] fillSpiralArray(){
        int[][] array2d = new int[HEIGHT][WIDTH];
        int counter = 1;
        array2d[MID_HEIGHT][MID_WIDTH] = 1;
        int i, j, incount = 1, i_holder = MID_HEIGHT, j_holder = MID_WIDTH;

        for (int k = 1; k < HEIGHT; k++) {
            int inc = 1;

            if (k % 2 == 0) {
                for (int l = 0; l < k; l++) {
                    i = i_holder; j = j_holder;
                    array2d[i][j - inc] = ++incount;
                    i_holder = i; j_holder = j - inc;
                }
                for (int l = 0; l < k; l++) {
                    i = i_holder; j = j_holder;
                    array2d[i - inc][j] = ++incount;
                    i_holder = i - inc; j_holder = j;
                }
            }
            else {
                for (int l = 0; l < k; l++) {
                    i = i_holder; j = j_holder;
                    array2d[i][j + inc] = ++incount;
                    i_holder = i; j_holder = j + inc;
                }
                for (int l = 0; l < k; l++) {
                    i = i_holder; j = j_holder;
                    array2d[i + inc][j] = ++incount;
                    i_holder = i + inc; j_holder = j;
                }
            }

            counter++;
        }


        return array2d;
    }

    static int solve(){

        return 0;
    }

    static void print(int [][] arr){
        for(int i = 0; i < arr.length; i++)
        {
            for(int j = 0; j < arr[i].length; j++)
            {
                System.out.print(arr[i][j]);
                if(j < arr[i].length - 1) System.out.print("   ");
            }
            System.out.println();
        }
    }
}
