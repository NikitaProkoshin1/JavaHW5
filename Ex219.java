package JavaHW5;

import java.util.HashMap;
import java.util.Map;

public class Ex219 {
    public static void main(String[] args) {
        //int[] nums = new int[]{1, 2, 3, 1};
        //int[] nums = new int[]{1, 0, 1, 1};
        int[] nums = new int[]{1, 2, 3, 1, 2, 3};
        System.out.println(containsNearbyDuplicate(nums, 2));
    }

    public static boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                if (i - map.get(nums[i]) <= k) {
                    return true;
                }
            }
            map.put(nums[i], i);
        }
        return false;
    }
}


/*class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        int len = nums.length;
       
        HashMap<Integer, Integer> m = new HashMap<>();
        Integer n;
        for (int i = 0;i < len; i++){
            n = m.put(nums[i], i);
            if (n != null && i - n <= k) return true;
            
            
        }return false;
    }
}

//https://leetcode.com/problems/contains-duplicate-ii/
