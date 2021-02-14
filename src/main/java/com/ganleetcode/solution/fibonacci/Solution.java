package com.ganleetcode.solution.fibonacci;


/**
 * 剑指 Offer 10- I. 斐波那契数列
 */
public class Solution
{
    public int fib(int n) {
        if (n <= 1) {
            return n;
        }
        return (fib(n - 1) + fib(n - 2)) % (1_000_000_007);
    }
}
