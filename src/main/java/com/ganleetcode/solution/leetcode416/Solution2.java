package com.ganleetcode.solution.leetcode416;

import java.util.Arrays;

public class Solution2
{
    public boolean canPartition(int[] nums) {
        int sum = Arrays.stream(nums).sum();
        if (sum % 2 != 0) {
            return false;
        }
        if (nums.length == 0) {
            return false;
        }
        boolean[] mem = new boolean[sum / 2 + 1];
        for (int i = 0; i <= sum / 2; i++) {
            mem[i] = (i == nums[0]);
        }
        for (int i = 1; i < nums.length; i++) {
            for (int j = sum / 2; j >= nums[i]; j--) {
                mem[j] = mem[j] || mem[j - nums[i]];
            }
        }
        return mem[sum / 2];
    }
}
