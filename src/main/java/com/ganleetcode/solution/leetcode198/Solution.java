package com.ganleetcode.solution.leetcode198;

import java.util.Arrays;

public class Solution
{
    private int[] mem;

    public int rob(int[] nums) {
        mem = new int[nums.length];
        Arrays.fill(mem, -1);
        return tryRob(nums, 0);
    }

    // [index, num.length)最大值
    private int tryRob(int[] nums, int index) {
        if (index >= nums.length) {
            return 0;
        }
        if (mem[index] != -1) {
            return mem[index];
        }
        int res = 0;
        for (int i = index; i < nums.length; i++) {
            res = Math.max(res, nums[i] + tryRob(nums, i + 2));
        }
        mem[index] = res;
        return res;
    }

    public static void main(String[] args)
    {
        Solution solution = new Solution();
        int[] nums = {1, 2, 3, 1};
        System.out.println(solution.rob(nums));
    }
}
