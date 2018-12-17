package Euler;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by HP on 9/4/2016.
 */
public class Prob38 {
    public static void main(String[] args) {
        Set<Integer> set = new HashSet<>();
        Integer max = 0;
        for (int i = 9999; i > 0; i--) {
            int cancatInt1 = intValConcat(i*1, i*2, i*3, i*4 ,i*5);
            if(isPandigitalAnd1To9Digits(cancatInt1))
                set.add(cancatInt1);
            int cancatInt2 = intValConcat(i*1, i*2, i*3, i*4);
            if(isPandigitalAnd1To9Digits(cancatInt2))
                set.add(cancatInt2);
            int cancatInt3 = intValConcat(i*1, i*2, i*3);
            if(isPandigitalAnd1To9Digits(cancatInt3))
                set.add(cancatInt3);
            int cancatInt4 = intValConcat(i*1, i*2);
            if(isPandigitalAnd1To9Digits(cancatInt4))
                set.add(cancatInt4);
        }
        for (Object setItem : set.toArray()) {
            max = ((Integer) setItem > max) ? (Integer) setItem : max;
            //System.out.print( setItem+", " );
        }
        System.out.println("\n"+max);
    }

    static boolean isPandigitalAnd1To9Digits(int n){
        int[] arr = splitNo(n);
        if (arr.length < 9)
            return false;
        Arrays.sort(arr);
        for (int i = 0; i < arr.length-1; i++)
            if (arr[i] >= arr[i+1] || arr[i] == 0 || arr[i+1] == 0)
                return false;
        return true;
    }
    static int intValConcat(int... nums){
        String str = "";
        for (int num : nums) {
            str += String.valueOf(num);
        }
        if(str.length() > 9)
            return 0;
        return Integer.parseInt(str);
    }
    static int[] splitNo(int no){
        int len = String.valueOf(no).length();
        int [] retArr = new int[len];
        for (int i = 0; i < retArr.length; i++) {
            retArr[i] = Integer.parseInt(String.valueOf(no).charAt(i)+"");
        }
        return retArr;
    }
}
