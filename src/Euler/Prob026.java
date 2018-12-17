package Euler;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Abayomi on 11/08/2016.
 */
public class Prob026 {
    private static final int LIMIT = 1000;
    public static void main(String[] args) {
        int max = 0, val = 0;
        for (int i = 1; i <= LIMIT; i++) {
            if(max < getCycleCount(i)) {
                val = i;
                max = getCycleCount(i);
            }
        }
       System.out.println(max);
       System.out.println(val);
    }

    static int getCycleCount(int n){
        Map<Integer, Integer> storeState = new HashMap<>();
        int ret = 0;
        int state = 1;
        state = state * 10 % n;
        while (!storeState.containsKey(state)){
            storeState.put(state, ret);
            state = state * 10 % n;
            ret++;
        }
        return ret;
    }

}
