package Euler;

/**
 * Created by HP on 9/4/2016.
 */
public class Prob33 {
    public static void main(String[] args) {
       long num = 1, den = 1;
        for (int i = 10; i <= 99; i++){
            for (int j = 10; j <= 99; j++){
                int a = i / 10, b = i % 10, c = j / 10, d = j % 10;
                if (i <= j)
                    break;
                if ((a == c) && (a != 0)){
                    if ((i*d) == (j*b)){
                        den *= i; num *= j;
                    }
                }
                if ((a == d) && (a != 0)){
                    if ((i*c) == (j*b)){
                        den *= i; num *= j;
                    }
                }
                if ((b == c) && (b != 0)){
                    if ((i*d) == (j*a)){
                        den *= i; num *= j;
                    }
                }
                if ((b == d) && (b != 0)){
                    if ((i*c) == (j*a)){
                        den *= i; num *= j;
                    }
                }
            }
        }
        System.out.println(num+" / "+den);
        System.out.println(num/gcm(num, den)+" / "+den/gcm(num, den));
    }

    static long gcm (long a, long b){
        return b == 0 ? a : gcm(b, a % b);
    }
}
