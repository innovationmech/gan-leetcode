package com.ganleetcode.solution.leetcode215;

import java.util.ArrayList;
import java.util.List;

public class Solution
{
    public int findKthLargest(int[] nums, int k) {
        List<Integer> bigger = new ArrayList<>();
        List<Integer> smaller = new ArrayList<>();
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] >= nums[0]) {
                bigger.add(nums[i]);
            } else if (nums[i] < nums[0]) {
                smaller.add(nums[i]);
            }
        }
        if (bigger.size() == k - 1) {
            return nums[0];
        } else if (bigger.size() >= k) {
            return findKthLargest(bigger.stream().mapToInt(Integer::valueOf).toArray(), k);
        } else {
            return findKthLargest(smaller.stream().mapToInt(Integer::valueOf).toArray(), k - bigger.size() - 1);
        }

    }

    public static void main(String[] args)
    {
        int[] nums = {1,1,1,1,1,3};
        Solution solution = new Solution();
        System.out.println(solution.findKthLargest(nums, 1));
    }
}
