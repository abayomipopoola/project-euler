package Euler;

/**
 * Created by Abayomi on 9/4/2016.
 */
public class Prob41 {
    public static StringBuilder permutation;
    public static void main(String[] args) {
        int [] allPandigit = {987654321, 87654321, 7654321, 654321, 54321, 4321, 321, 21, 1};
        boolean brk = false;
        for (int i = 0; i < allPandigit.length; i++) {
            permutation = new StringBuilder();
            if (brk)
                break;
            permutation(allPandigit[i]+"");
            String [] permutationList = permutation.toString().split(" ");
            for (int j = 0; j < permutationList.length; j++) {
                if (isPrime(Integer.parseInt(permutationList[j]))){
                    System.out.println(permutationList[j]);
                    brk = true;
                    break;
                }
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
}
