package Leetcode;

import java.util.Map;
import java.util.HashMap;

public class Rando {

    private Map<String, Integer> map;
    private int curr_amt = 100;

    public Rando() {
        // If you need initialization code, you can write it here!
        // Do not remove.
        map = new HashMap<>();
        map.put("red", 3);
        map.put("blue", 0);
        map.put("yellow", 0);
        map.put("green", 0);
    }

    public static void main(String[] args) {
        int bid = 0;
        if (false){
            bid = 0;
        } else if (true) {
            bid = 10;
        } else if (true) {
            bid = 5;
        }

        System.out.println(bid);
    }

    private String getMin(Map<String, Integer> map) {
        String minKey = null;
        int minValue = Integer.MAX_VALUE;
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            int value = entry.getValue();
            if(value < minValue) {
                minValue = value;
                minKey = entry.getKey();
            }
        }
        return minKey;
    }

    private String getMax(Map<String, Integer> map) {
        String maxKey = null;
        int maxValue = Integer.MIN_VALUE;
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            int value = entry.getValue();
            if(value > maxValue) {
                maxValue = value;
                maxKey = entry.getKey();
            }
        }
        return maxKey;
    }

    /**
     * Set a bid on the current painting for auction. If you do not wish to bid,
     * set 0.
     */
    public int setBid() {
        // Todo: Write your code here!
        int bid = 0;
        if (getMin(this.map) == "red"){
            bid = 0;
        } else if (getMax(this.map) == "red"
                && 50 <= this.curr_amt+10) {
            this.curr_amt -= 30 + 10;
            bid = 30 + 10;
        } else if (30 <= this.curr_amt+5) {
            this.curr_amt -= 30 + 5;
            bid = 30 + 5;
        }

        return bid;
    }

    /**
     * Set the starting bid of the painting currently for auction. This number
     * must be greater than 0.
     */
    public int setInitialBid() {
        // Todo: Write your code here!
        this.curr_amt -= 23;
        return 23;
    }

    /**
     * This method will be called at the start of every round. Here, you should
     * check how much money you have and what the upcoming painting category is.
     */
    public void round_start() {
        // Todo: Write your code here!
        String category = "RED".toLowerCase();
        map.put(category, map.get(category) + 1);
        this.curr_amt = 60;
    }
}

