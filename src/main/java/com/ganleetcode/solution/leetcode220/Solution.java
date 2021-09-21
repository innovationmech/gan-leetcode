package com.ganleetcode.solution.leetcode220;

import java.util.TreeSet;

public class Solution
{
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        TreeSet<Long> set = new TreeSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (!set.tailSet((long) nums[i] - t).isEmpty() && set.tailSet((long) nums[i] - t).first() <= (long) nums[i] + t) {
                return true;
            }
            set.add((long) nums[i]);
            if (set.size() == k + 1) {
                set.remove((long) nums[i - k]);
            }
        }
        return false;
    }

    public static void main(String[] args)
    {
        Solution solution = new Solution();
        int[] nums = {-2147483647, 2147483647};
        System.out.println(solution.containsNearbyAlmostDuplicate(nums, 1, 2147483647));
    }
}
