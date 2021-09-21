package com.ganleetcode.solution.leetcode454;

import java.util.HashMap;
import java.util.Map;

public class Solution
{
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        int res = 0;
        Map<Integer, Integer> firstMap = new HashMap<>();
        for (int i = 0; i < nums1.length; i++) {
            for (int j = 0; j < nums2.length; j++) {
                if (!firstMap.containsKey(nums1[i] + nums2[j])) {
                    firstMap.put(nums1[i] + nums2[j], 1);
                } else {
                    firstMap.put(nums1[i] + nums2[j], firstMap.get(nums1[i] + nums2[j]) + 1);
                }
            }
        }
        Map<Integer, Integer> secondMap = new HashMap<>();
        for (int i = 0; i < nums3.length; i++) {
            for (int j = 0; j < nums4.length; j++) {
                if (!secondMap.containsKey(nums3[i] + nums4[j])) {
                    secondMap.put(nums3[i] + nums4[j], 1);
                } else {
                    secondMap.put(nums3[i] + nums4[j], secondMap.get(nums3[i] + nums4[j]) + 1);
                }
            }
        }
        for (int first : firstMap.keySet()) {
            if (secondMap.containsKey(-first)) {
                res += (firstMap.get(first) * secondMap.get(-first));
            }
        }
        return res;
    }

    public static void main(String[] args)
    {
        int[] nums1 = {-1, -1};
        int[] nums2 = {-1, 1};
        int[] nums3 = {-1, 1};
        int[] nums4 = {1, -1};
        Solution solution = new Solution();
        System.out.println(solution.fourSumCount(nums1, nums2, nums3, nums4));
    }
}
