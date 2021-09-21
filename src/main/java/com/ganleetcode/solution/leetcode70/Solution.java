package com.ganleetcode.solution.leetcode70;

public class Solution
{
    private int[] mem;

    public int climbStairs(int n) {
        if (n <= 2) {
            return n;
        }
        mem = new int[n + 1];
        mem[1] = 1;
        mem[2] = 2;
        return calcWays(n);
    }

    private int calcWays(int n) {
        if (mem[n] != 0) {
            return mem[n];
        } else {
            return mem[n] = calcWays(n - 1) + calcWays(n - 2);
        }
    }
}
