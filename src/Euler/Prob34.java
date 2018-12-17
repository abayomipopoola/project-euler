package Euler;

/**
 * Created by HP on 9/4/2016.
 */
public class Prob34 {
    public static void main(String[] args) {
        int sumTot = 0;
        for (int i = 10; i <= 999999; i++) {
            int sum = 0;
            int [] arr = splitNo(i);
            for (int j = 0; j < arr.length; j++) {
                sum += factorial(arr[j]);
            }
            if (sum == i) {
                print(arr);
                sumTot += sum;
            }
        }
        System.out.println(sumTot);
    }

    static int[] splitNo(int no){
        int len = String.valueOf(no).length();
        int [] retArr = new int[len];
        for (int i = 0; i < retArr.length; i++) {
            retArr[i] = Integer.parseInt(String.valueOf(no).charAt(i)+"");
        }
        return retArr;
    }

    static int factorial(int n){
        if (n == 0)
            return 1;
        else
            return n * factorial(n-1);
    }
    static void print(int [] arr){
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+" , ");
        }
        System.out.println("_____________");
    }
}
