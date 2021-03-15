package com.ganleetcode.solution.offer10;

/**
 * 剑指 Offer 10- II. 青蛙跳台阶问题
 */
public class Solution
{
    // 动态规划 f(n) = f(n - 1) + f(n - 2)
    public int numWays(int n) {
        int a = 0, b = 1, sum = 0;
        for (int i = 0; i < n; i++) {
            sum = (a + b) % 1_000_000_007;
            a = b;
            b = sum;
        }
        return b;
    }
}
