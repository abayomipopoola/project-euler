package Euler;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Abayomi on 14/08/2016.
 */
public class Prob29 {
    public static void main(String[] args) {

        Set<Double> set = new HashSet<>();

        for (int a = 2; a <= 100; a++)
            for (int b = 2; b <= 100; b++)
                set.add(Math.pow(a, b));
        System.out.println(set.size());
    }
}
