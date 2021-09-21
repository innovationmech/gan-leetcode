package com.ganleetcode.solution.leetcode347;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Solution
{
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (!map.containsKey(nums[i])) {
                map.put(nums[i], 1);
            } else {
                map.put(nums[i], map.get(nums[i]) + 1);
            }
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.comparingInt(map::get));
        for (Integer key : map.keySet()) {
            if (pq.size() < k) {
                pq.add(key);
            } else {
                if (map.get(key) > map.get(pq.peek())) {
                    pq.poll();
                    pq.add(key);
                }
            }
        }
        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            if (!pq.isEmpty()) {
                res[i] = pq.poll();
            }
        }
        return res;
    }

    public static void main(String[] args)
    {
        Solution solution = new Solution();
        int[] nums = {1, 1, 1, 2, 2, 3, 3, 3, 3, 3};
        int[] res = solution.topKFrequent(nums, 2);
        for (int i = 0; i < res.length; i++) {
            System.out.println(res[i]);
        }
    }
}
