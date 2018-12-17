package Euler;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Abayomi on 16/08/2016.
 */
public class Prob32 {

    public static void main(String[] args) {
        int [] a = permutation2((changeInttoArr(123456789))), b =permutation3((changeInttoArr(123456789)));
        int [] c = {1,2,3,4,5,6,7,8,9}, d = permutation4((changeInttoArr(123456789)));
        // for 2digits and 3 digits
        int firstsum = solve(a, b);
        int secondsum = solve2(c, d);
        System.out.println(firstsum+secondsum);
    }
    // Max multiplicand and multiplier 99*101
    private static int[] changeInttoArr(int val) {
        int ind, count = 0;
        int [] arrVal = new int[9];
        do {
            ind = val % 10;
            val /= 10;
            arrVal[count] = ind;
            count++;
        } while (val > 0);
        return arrVal;
    }

    private static int solve(int [] arr1, int [] arr2){
        int sum = 0;
        Set<Integer> set2 = new HashSet<>();
        for (int i = 0; i < arr1.length; i++) {
            for (int j = 0; j < arr2.length; j++) {
                int prod = arr1[i]*arr2[j];
                int a, b, c, d, e, f, g, h, k;
                Set<Integer> set = new HashSet<>();
                a = arr1[i] % 10; b = arr1[i]/10;
                c = arr2[j] % 10; d = arr2[j]/10; d = d % 10; e = arr2[j]/100;
                f = prod % 10; g = prod/10; g = g % 10; h = prod/100; h = h % 10; k = prod/1000;
                set.add(a); set.add(b); set.add(c); set.add(d); set.add(e); set.add(f); set.add(g); set.add(h); set.add(k);

                if(set.size() == 9 && !set.contains(0) && prod < 10000){
                    set2.add(prod);
                    sum += prod;
                    System.out.printf("%d, %d, %d, %d, %d, %d, %d, %d, %d, \n", a,b,c,d,e,f,g,h,k);
                }
            }
        }

        return sumSet(set2);
    }
    private static int solve2(int [] arr1, int [] arr2){
        int sum = 0;
        Set<Integer> set2 = new HashSet<>();
        for (int i = 0; i < arr1.length; i++) {
            for (int j = 0; j < arr2.length; j++) {
                int prod = arr1[i]*arr2[j];
                int a, b, c, d, e, f, g, h, k;
                Set<Integer> set = new HashSet<>();
                a = arr1[i];
                b = arr2[j] % 10; c = arr2[j]/10; c = c % 10; d = arr2[j]/100; d = d % 10; e = arr2[j]/1000;
                f = prod % 10; g = prod/10; g = g % 10; h = prod/100; h = h % 10; k = prod/1000;
                set.add(a); set.add(b); set.add(c); set.add(d); set.add(e); set.add(f); set.add(g); set.add(h); set.add(k);

                if(set.size() == 9 && !set.contains(0) && prod < 10000){
                    set2.add(prod);
                    sum += prod;
                    System.out.printf("%d, %d, %d, %d, %d, %d, %d, %d, %d, \n", a,b,c,d,e,f,g,h,k);
                }
            }
        }

        return sumSet(set2);
    }
    static int [] permutation4(int [] arr) {
        int i, j, k, l;
        int len = arr.length, count = 0;
        int [] retArr = new int[6552];
        for (i = 0; i < len; i++) {
            for (j = 0; j < len; j++) {
                for (k = 0; k < len; k++) {
                    for (l = 0; l < len; l++) {
                        if (!(i == j && i == k && i == l)) {
                            retArr[count] = (1000 * arr[i]) + (100 * arr[j]) + (10*arr[k]) + arr[l];
                            count++;
                        }
                    }
                }

            }
        }
        return retArr;
    }
    static int [] permutation3(int [] arr) {
        int i, j, k;
        int len = arr.length, count = 0;
        int [] retArr = new int[720];
        for (i = 0; i < len; i++) {
            for (j = 0; j < len; j++) {
                for (k = 0; k < len; k++)
                    if (!(i == j && i == k)) {
                        retArr[count] = (100 * arr[i]) + (10 * arr[j]) + arr[k];
                        count++;
                    }
            }
        }
        return retArr;
    }
    static int [] permutation2(int [] arr) {
        int i, j, len = arr.length, count = 0;
        int [] retArr = new int[72];
        for (i = 0; i < len; i++) {
            for (j = 0; j < len; j++)
                if (!(i == j)) {
                    retArr[count] = (10 * arr[i]) + arr[j];
                    count++;
                }
        }
        return retArr;
    }
    static int sumSet(Set<Integer> set){
        int sum = 0;
        for (Object setItem : set.toArray()) {
            sum += (Integer) setItem;
        }
        return sum;
    }

}
