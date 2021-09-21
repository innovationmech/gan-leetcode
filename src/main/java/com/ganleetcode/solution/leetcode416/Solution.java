package com.ganleetcode.solution.leetcode416;

import java.util.Arrays;

public class Solution
{
    // -1 未计算 0 不可以填充 1 可以填充
    int[][] mem;

    public boolean canPartition(int[] nums) {
        int sum = Arrays.stream(nums).sum();
        if (sum % 2 != 0) {
            return false;
        }
        int n = nums.length;
        mem = new int[n][sum / 2 + 1];
        for (int i = 0; i < mem.length; i++) {
            Arrays.fill(mem[i], -1);
        }
        return tryPartition(nums, n - 1, sum / 2);

    }

    // 使用nums[0, index]的数,只和为sum
    private boolean tryPartition(int[] nums, int index, int sum) {
        if (sum == 0) {
            return true;
        }
        if (index < 0 || sum < 0) {
            return false;
        }
        if (mem[index][sum] != -1) {
            return mem[index][sum] == 1;
        }
        mem[index][sum] = (tryPartition(nums, index - 1, sum) || tryPartition(nums, index - 1, sum - nums[index])) ? 1 : 0;
        return mem[index][sum] == 1;
    }

    public static void main(String[] args)
    {
        Solution solution = new Solution();
        int[] nums = {1, 2, 3, 4, 5, 6, 7};
        System.out.println(solution.canPartition(nums));
    }
}
