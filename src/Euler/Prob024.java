package Euler;

import java.util.Arrays;

/**
 * Created by Abayomi on 11/08/2016.
 */
public class Prob024 {

   // The method goes back to Narayana Pandita in 14th century India.
    private static final int LIMIT = 1000000;
    public static void main(String[] args) {
        int [] prob24Arr = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};

        for (int i = 1; i < LIMIT; i++) {
            prob24Arr = solve(prob24Arr);
        }
        System.out.println(printArr(prob24Arr));
    }
    static int [] solve( int [] t_case){
        // find largest non increasing x
        int nonIncSuffix = findMaxIndex(t_case);
        int rightGr8aIndex = findRightGr8aIndex(t_case, nonIncSuffix);

        if(nonIncSuffix == -1 || rightGr8aIndex == -1)
            return t_case;

        // Swap index element.
        int temp = t_case[rightGr8aIndex];
        t_case[rightGr8aIndex] = t_case[nonIncSuffix];
        t_case[nonIncSuffix] = temp;

        // sorting array
        Arrays.sort(t_case, nonIncSuffix+1, t_case.length);

        return t_case;
    }

    static int findMaxIndex(int [] test){
        for (int index = test.length-2; index >= 0; index--)
        //for (int i = 0; i < test.length-1; i++)
            if(test[index] < test[index+1])
                return index;
        return -1;
    }
    static int findRightGr8aIndex(int [] test, int index){
        for (int i = test.length-1; i >= 0 ; i--)
        //for (int i = 1; i < test.length-1; i++)
            if(i > index && test[index] < test[i])
                return i;
        return -1;
    }
    static String printArr(int [] arr){
        String retVal = "";
        for (int i = 0; i < arr.length; i++)
            retVal += arr[i];
        return retVal;
    }
}
