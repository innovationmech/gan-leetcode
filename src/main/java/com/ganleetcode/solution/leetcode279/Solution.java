package com.ganleetcode.solution.leetcode279;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import javafx.util.Pair;

public class Solution
{
    public int numSquares(int n) {
        Deque<Pair<Integer, Integer>> deque = new ArrayDeque<>();
        int[] mem = new int[n + 1];
        Arrays.fill(mem, -1);
        deque.add(new Pair(n, 0));
        while (!deque.isEmpty()) {
            Pair<Integer, Integer> pair = deque.pollFirst();
            int num = pair.getKey();
            int res = pair.getValue();

            for (int i = 1;;i++) {
                int a = num - i * i;
                if (a < 0) {
                    break;
                }
                if (a == 0) {
                    return res + 1;
                }
                if (mem[a] == -1) {
                    mem[a] = res + 1;
                    deque.add(new Pair<>(a, res + 1));
                }
            }
        }
        return 0;
    }

    public static void main(String[] args)
    {
        Solution solution = new Solution();
        System.out.println(solution.numSquares(12));
    }
}
