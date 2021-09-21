package com.ganleetcode.solution.leetcode300;

import java.util.Arrays;

public class Solution
{
    public int lengthOfLIS(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int[] mem = new int[nums.length];
        Arrays.fill(mem, 1);
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    mem[i] = Math.max(mem[i], mem[j] + 1);
                }
            }
        }
        int res = 1;
        for (int i = 0; i < mem.length; i++) {
            res = Math.max(res, mem[i]);
        }
        return res;
    }
}
