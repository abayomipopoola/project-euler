package Euler;

import java.math.BigInteger;

/**
 * Created by Abayomi on 12/08/2016.
 */
public class Prob025 {

    private static final int DIGITS = 1000;
    public static void main(String[] args) {
        System.out.println(solve());
    }
    public static String solve() {
        BigInteger lowerthres = BigInteger.TEN.pow(DIGITS - 1);
        BigInteger upperthres = BigInteger.TEN.pow(DIGITS);
        BigInteger prev = BigInteger.ONE;
        BigInteger cur = BigInteger.ZERO;
        int i = 0;
        while (true) {
            // At this point, prev = fibonacci(i - 1) and cur = fibonacci(i)
            if (cur.compareTo(lowerthres) >= 0)
                return Integer.toString(i);
            else if (cur.compareTo(upperthres) >= 0)
                throw new RuntimeException("Not found");

            BigInteger temp = cur.add(prev);
            prev = cur;
            cur = temp;
            i++;
        }
    }
}
