package com.ganleetcode.solution.leetcode435;

import java.util.Arrays;

public class Solution
{
    public int eraseOverlapIntervals(int[][] intervals) {
        if (intervals.length == 0) {
            return 0;
        }
        Arrays.sort(intervals, (o1, o2) -> {
            if (o1[0] != o2[0]) {
                return o1[0] - o2[0];
            }
            return o1[1] - o2[1];
        });
        int[] mem = new int[intervals.length];
        Arrays.fill(mem, 1);
        for (int i = 1; i < intervals.length; i++) {
            for (int j = 0; j < i; j++) {
                if (intervals[i][0] >= intervals[j][1]) {
                    mem[i] = Math.max(mem[i], mem[j] + 1);
                }
            }
        }
        int res = 0;
        for (int i = 0; i < mem.length; i++) {
            res = Math.max(res, mem[i]);
        }
        return intervals.length - res;
    }

}
