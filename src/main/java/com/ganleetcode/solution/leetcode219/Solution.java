package com.ganleetcode.solution.leetcode219;

import java.util.HashSet;
import java.util.Set;

public class Solution
{
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (set.contains(nums[i])) {
                return true;
            }
            set.add(nums[i]);
            if (set.size() == k + 1) {
                set.remove(nums[i - k]);
            }
        }
        return false;
    }

    public static void main(String[] args)
    {
        Solution solution = new Solution();
        int[] nums = {1, 0, 1, 1};
        System.out.println(solution.containsNearbyDuplicate(nums, 1));
    }
}
