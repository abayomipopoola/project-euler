package Leetcode;

public class Prob1 {
    public static void main (String[] args) {
        // your code goes here
        int[] arr = {3,2,4};
//        System.out.println(Arrays.toString(twoSum(arr, 6)));
        System.out.println(reverseWords("the sky is blue"));
    }
    public static int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++){
            for (int j = 0; j < nums.length; j++){
                if(i == j)
                    continue;
                if(nums[i] + nums[j] == target)
                    return new int[] {i, j};
            }
        }
        return new int[] {0, 0};
    }
    public static String reverseWords(String s) {
        StringBuilder reversed = new StringBuilder();
        int j = s.length();
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == ' ') {
                j = i;
            } else if (i == 0 || s.charAt(i - 1) == ' ') {
                if (reversed.length() != 0) {
                    reversed.append(' ');
                }
                reversed.append(s.substring(i, j));
                System.out.println(reversed);
            }
        }
        return reversed.toString();
    }
}
