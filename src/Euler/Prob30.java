package Euler;

/**
 * Created by Abayomi on 14/08/2016.
 */
public class Prob30 {

    // As stated in the problem, 1 = 1^5 is excluded.
    // If a number has at least n >= 7 digits, then even if every digit is 9,
    // n * 9^5 is still less than the number (which is at least 10^n).
    public static void main(String[] args) {
        int sum = 0;
        for (int i = 2; i < 1000000; i++) {
            if (i == digitsToFifth(i))
                sum += i;
        }
        System.out.println(sum);
    }

    private static int digitsToFifth(int val) {
        int ind, sum = 0;
        do {
            ind = val % 10;
            val /= 10;
            sum += (ind * ind * ind * ind * ind);
        } while (val > 0);
        return sum;
    }
}
