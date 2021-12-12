package com.ganleetcode.solution.leetcode1005;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * todo
 *
 * @author <a href="dreamerlyj@gmail.com">liyanjie</a>
 * @since
 */
public class Solution
{
    public int largestSumAfterKNegations(int[] nums, int k) {
        Arrays.sort(nums);
        for (int i = 0; i < k; i++) {
            nums[0] = -nums[0];
            Arrays.sort(nums);
        }
        return Arrays.stream(nums).boxed().reduce(0, Integer::sum);
    }

    public static void main(String[] args)
    {
        int[] nums = new int[]{3, -1, 0, 2};
        Solution solution = new Solution();
        System.out.println(solution.largestSumAfterKNegations(nums, 3));
    }
}
