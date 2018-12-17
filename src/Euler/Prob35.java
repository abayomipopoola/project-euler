package Euler;

/**
 * Created by HP on 9/4/2016.
 */
public class Prob35 {
    public static void main(String[] args) {
        int totalCircularPrime = 0;
        for (int i = 0; i < 1000000; i++) {
            if(isCircularPrime(i))
                totalCircularPrime ++;
        }
        System.out.println(totalCircularPrime);
    }

    static boolean isCircularPrime(int no){
        String str = String.valueOf(no);
        for (int i = 0; i < str.length(); i++) {
            if(!isPrime(Integer.parseInt(str.substring(i) + str.substring(0, i))))
                return false;
        }
        return true;
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
