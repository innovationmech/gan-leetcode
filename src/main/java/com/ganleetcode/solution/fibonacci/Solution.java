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
        int[] mem = new int[n + 1];
        mem[0] = 0;
        mem[1] = 1;
        return (fib(n - 1, mem) + fib(n - 2, mem)) % 1_000_000_007;
    }

    // 记忆化递归法
    private int fib(int n, int[] mem) {
        if (n <= 1) {
            return n;
        }
        if (n == 2) {
            return mem[0] + mem[1];
        }
        if (mem[n - 1] != 0 && mem[n - 2] != 0) {
            return (mem[n - 1] + mem[n - 2]) % 1_000_000_007;
        }
        int res = (fib(n - 1, mem) + fib(n - 2, mem)) % 1_000_000_007;
        mem[n] = res;
        return res;
    }
}
