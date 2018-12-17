package Euler;

/**
 * Created by HP on 9/4/2016.
 */
public class Prob40 {
    public static void main(String[] args) {
        StringBuilder veryLongString = new StringBuilder();
        for (int i = 1; i <= 999999; i++)
            veryLongString.append(i);
        //d1 × d10 × d100 × d1000 × d10000 × d100000 × d1000000
        //veryLongString.charAt(Math.pow(10, i) - 1) - '0' => returns the integer value fot the string char.
        int ans = Integer.parseInt(veryLongString.substring(0, 1)) * Integer.parseInt(veryLongString.substring(9, 10)) *
                  Integer.parseInt(veryLongString.substring(99, 100)) * Integer.parseInt(veryLongString.substring(999, 1000)) *
                  Integer.parseInt(veryLongString.substring(9999, 10000)) * Integer.parseInt(veryLongString.substring(99999, 100000)) * Integer.parseInt(veryLongString.substring(999999, 1000000));
        System.out.println(ans);
    }
}
