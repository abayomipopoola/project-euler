package Leetcode;

import java.util.HashMap;
import java.util.Map;

public class Prob3 {
    public static void main(String[] args) {
        System.out.println(new Prob3().lengthOfLongestSubstring("aab"));
    }
    //longest substring without repeating characters
    public int lengthOfLongestSubstring(String s) {
        if (s.equals(""))
            return 0;
        char c; int count = 1;
        Map<Character, Integer> map = new HashMap<>();
        int max = 1;
        for (int i = 0; i < s.length(); i++) {
            c = s.charAt(i);
            for (int j = i+1; j < s.length(); j++) {
                char _c = s.charAt(j);
                if (c != _c && !map.containsKey(_c)){
                    map.put(_c, 1);
                    count += 1;
                    max = (max > count) ? max : count;
                }else {
                    count = 1;
                    map = new HashMap<>();
                    break;
                }
            }
        }
        return max;
    }
}
