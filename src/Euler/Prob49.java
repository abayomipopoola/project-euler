package Euler;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Abayomi on 4/21/17.
 */
public class Prob49 {
    public static StringBuilder permutation;
    public static List<String[]> combinationList ;

    public static void main(String[] args) {
//        for (int i = 1000; i < 9999; i++) {
//            permutation = new StringBuilder();
//            permutation(i+"");
//            String [] permutationList = permutation.toString().split(" ");
//            combinationList = new ArrayList<>();
//            combinations(permutationList, 3, 0, new String[3]);
//            for (int j = 0; j < combinationList.size(); j++) {
//                String[] arr = combinationList.get(j);
//                if(!passCondition(Integer.parseInt(arr[0]), Integer.parseInt(arr[1]), Integer.parseInt(arr[2])))
//                    break;
//                System.out.println(arr[0]+arr[1]+arr[2]);
//            }
//        }
        permutation = new StringBuilder();
        permutation("6789");
        String [] permutationList = permutation.toString().split(" ");
        String[] arr = {"A","B","C","D","E","F"};
        combinationList = new ArrayList<>();
        combinations(arr, 3, 0, new String[3]);
        for (int i = 0; i < combinationList.size(); i++) {
            System.out.println(Arrays.toString(combinationList.get(i)));
        }
    }

    private static boolean passCondition(int i, int i1, int i2) {
        if(!isPrime(i) || !isPrime(i1) || !isPrime(i2))
            return false;
        int [] arr = {i, i1, i2};
        Arrays.sort(arr);
        if(arr[0] - arr[1] == 0 || arr[1] - arr[2] == 0)
            return false;
        if(arr[0] - arr[1] == arr[1] - arr[2])
            return true;
        return false;
    }

    static void combinations(String[] arr, int len, int startPosition, String[] result){
        if (len == 0){
            System.out.print(Arrays.toString(result));
            combinationList.add(result);
            return;
        }
        for (int i = startPosition; i <= arr.length-len; i++){
            result[result.length - len] = arr[i];
            combinations(arr, len-1, i+1, result);
        }
    }
    public static void permutation(String str) {
        permutation("", str);
    }
    private static void permutation(String prefix, String str) {
        int n = str.length();
        if (n == 0) permutation.append(prefix+" ");
        else {
            for (int i = 0; i < n; i++) {
                permutation(prefix + str.charAt(i), str.substring(0, i) + str.substring(i + 1, n));
            }
        }
    }
    public static boolean isPrime(int x) {
        if (x < 0)
            throw new IllegalArgumentException("Negative number");
        if (x == 0 || x == 1)
            return false;
        else if (x == 2)
            return true;
        else {
            if (x % 2 == 0)
                return false;
            for (int i = 3, end = sqrt(x); i <= end; i += 2) {
                if (x % i == 0)
                    return false;
            }
            return true;
        }
    }
    public static int sqrt(int x) {
        if (x < 0)
            throw new IllegalArgumentException("Square root of negative number");
        int y = 0;
        for (int i = 32768; i != 0; i >>>= 1) {
            y |= i;
            if (y > 46340 || y * y > x)
                y ^= i;
        }
        return y;
    }
}
