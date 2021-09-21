package com.ganleetcode.solution.leetcode455;

import java.util.Arrays;

public class Solution
{
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int res = 0;
        int gi = g.length - 1;
        int si = s.length - 1;
        while (gi >= 0 && si >= 0) {
            if (g[gi] <= s[si]) {
                res++;
                gi--;
                si--;
            } else  {
                gi--;
            }
        }
        return res;
    }

    public static void main(String[] args)
    {
        Solution solution = new Solution();
        int[] g = {1, 2};
        int[] s = {1, 2, 3};
        System.out.println(solution.findContentChildren(g, s));
    }

}
