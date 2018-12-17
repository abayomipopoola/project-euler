package Euler;

/**
 * Created by Abayomi on 15/08/2016.
 */
public class Prob31 {

    private static final int TOTAL = 200;
    private static int[] COINS = {1, 2, 5, 10, 20, 50, 100, 200};

    public static void main(String[] args) {

        int[][] no_ways = new int[COINS.length + 1][TOTAL + 1];
        no_ways[0][0]  = 1;

        // using DP.
        // no_ways[i — 1][j] + no_ways[i][j — v[i — 1]]	if(coin[i]<=j)
        // no_ways[i — 1][j];	if(coin[i]>j)

        for (int i = 1; i <= COINS.length; i++) {
            for (int j = 0; j <= TOTAL; j++) {
                no_ways[i][j] = (COINS[i-1] <= j) ? no_ways[i-1][j] + no_ways[i][j - COINS[i - 1]] : no_ways[i-1][j];
            }
        }
        //print(no_ways);
        System.out.println(no_ways[COINS.length][TOTAL]);
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