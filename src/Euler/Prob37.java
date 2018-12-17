package Euler;

/**
 * Created by HP on 9/4/2016.
 */
public class Prob37 {
    public static void main(String[] args) {
        int sum = 0;
        for (int i = 10, count = 0; count < 11; i++) {
            int len = String.valueOf(i).length(), tens = 10;
            boolean exitFlag = false;
            if (!isPrime(i))
                continue;
            for (int j = 0; j < len-1; j++) {
                if(!(isPrime(i/tens) && isPrime(i % tens))){
                    exitFlag = true;
                    break;
                }
                tens *= 10;
            }
            if(exitFlag)
                continue;
            sum += i;
            count++;
        }
        System.out.println(sum);
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

}
