package Euler;

/**
 * Created by Abayomi on 10/08/2016.
 */
public class Prob023 {
    private static final int LIMIT = 28123;
    private static boolean[] isAbundant = new boolean[LIMIT + 1];

    public static void main(String[] args) {
        int sum = 0;
        for (int i = 0; i < isAbundant.length; i++)
            isAbundant[i] = isAbundantNumber(i);
        for (int i = 0; i <= LIMIT; i++) {
            if (!is2AbundantNumber(i))
                sum += i;
        }

        System.out.println(sum);
    }

    static boolean is2AbundantNumber(int n){
        for (int j = 1; j <= Math.ceil(n/2); j++) {
            if(isAbundant[j] && isAbundant[n-j])
                return true;
            else
                continue;
        }
        return false;
    }
    static boolean isAbundantNumber(int n){
        if (n < 0)
            return false;
        int sum = 0;
        for (int i = 1; i <= n/2; i++){
            if(n%i == 0)
                sum += i;
            else
                continue;
        }
        boolean isAbund = (sum > n) ? true : false;
        return isAbund;
    }
}
