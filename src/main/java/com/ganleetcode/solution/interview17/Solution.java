package com.ganleetcode.solution.interview17;

import java.util.PriorityQueue;

public class Solution
{
    public int[] smallestK(int[] arr, int k) {
        int[] res = new int[k];
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        for (int num : arr) {
            if (pq.size() == k) {
                if (!pq.isEmpty() && num < pq.peek()) {
                    pq.poll();
                    pq.add(num);
                }
            } else {
                pq.add(num);
            }
        }
        for (int i = 0; i < k; i++) {
            if (!pq.isEmpty()) {
                res[i] = pq.poll();
            }
        }
        return res;
    }
}
