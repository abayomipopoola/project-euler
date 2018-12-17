package Euler;

/**
 * Created by Abayomi on 12/08/2016.
 */
public class Prob027 {

    public static void main(String[] args) {
        int max = 0, sol = 0, bestA = 0, bestB = 0;
        for (int a = -999; a <= 1000; a++) {
            for (int b = -999; b <= 1000; b++) {
                sol = solve(a, b);
                if(max < sol){
                    max = sol;
                    bestA = a;
                    bestB = b;
                }
            }
        }
        System.out.println(max);
        System.out.println(bestA*bestB);
    }
    // Tests whether the given integer is prime.
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
    // Returns floor(sqrt(x)).
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
    public static int solve(int a, int b){
        int ans = 0, count = 0, max = 0;
        for (int n = 0; ; n++) {
            ans = (n * n) + (a * n) + b;
            if (ans < 0)
                continue;
            if (isPrime(ans))
                max = (max < count) ? count : max;
            if (!isPrime(ans))
                break;
            count++;
        }
        return max;
    }
}
