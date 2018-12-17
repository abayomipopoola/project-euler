package Euler;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by HP on 9/4/2016.
 */
public class Prob39 {
    private static final int MAXVAL = 1000;
    private static Map<Integer, Integer> map = new HashMap<>();
    public static void main(String[] args) {
        int max = 0, value = 0;
        for (int i = 1; i <= MAXVAL; i++)
            addToMap(i);
        for (Integer mapKey : map.keySet()) {
            if (map.get(mapKey) > max){
                max = map.get(mapKey);
                value = mapKey;
            }
        }
        System.out.print( max+": "+ value);
    }
    static void addToMap(int val){
        int count = 0;
        for (int i = 1; i < val; i++) {
            for (int j = 1; j < val; j++) {
                int k = val - i - j;  // We don't need to use another loop since we can find the last unknown.
                    if ( i * i + j * j == k * k)
                        count++;
            }
        }
        if (count > 0) {
            map.put(val, count/2);
        }
    }
}
