package JavaHW5;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Ex350 {
    class Solution {
        public int[] intersect(int[] nums1, int[] nums2) {
            if (nums1.length > nums2.length) {
                return intersect(nums2, nums1);
            }
            HashMap<Integer, Integer> map = new HashMap<>();
            for (int num : nums1) {
                if (map.containsKey(num))
                    map.put(num, map.get(num) + 1);
                else
                    map.put(num, 1);
            }

            List<Integer> intersect = new ArrayList<>();

            for (int num : nums2) {
                if (map.containsKey(num) && map.get(num) > 0) {
                    intersect.add(num);
                    int count = map.get(num);
                    count--;
                    map.put(num, count);
                }
            }

            int[] ans = new int[intersect.size()];
            for (int i = 0; i < ans.length; i++) {
                ans[i] = intersect.get(i);
            }
            return ans;
        }
    }
}

//https://leetcode.com/problems/intersection-of-two-arrays-ii/
