package Euler;

/**
 * Created by HP on 9/4/2016.
 */
public class Prob36 {
    public static void main(String[] args) {
        int total = 0;
        for (int i = 0; i < 1000000; i++) {
            StringBuilder numb = new StringBuilder(i+"");
            StringBuilder numb2 = new StringBuilder(Integer.toBinaryString(i));
            if(numb.toString().equals(numb.reverse().toString()) && numb2.toString().equals(numb2.reverse().toString()))
                total += Integer.parseInt(i+"");
        }
        System.out.println(total);
    }

}
