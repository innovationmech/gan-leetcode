package com.ganleetcode.solution.leetcode506;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * todo
 *
 * @author <a href="dreamerlyj@gmail.com">liyanjie</a>
 * @since
 */
public class Solution
{
    public String[] findRelativeRanks(int[] score) {
        int len = score.length;
        PriorityQueue<Rank> scoreQueue = new PriorityQueue<>((r1, r2) -> r2.score - r1.score);
        PriorityQueue<Rank> indexQueue = new PriorityQueue<>((r1, r2) -> r1.index - r2.index);
        String[] res = new String[score.length];
        for (int i = 0; i < len; i++) {
            scoreQueue.add(new Rank(i, score[i]));
        }
        for (int i = 0; i < len; i++) {
            Rank rank = scoreQueue.poll();
            rank.order = medal(i + 1);
            indexQueue.add(rank);
        }
        for (int i = 0; i < len; i++) {
            res[i] = indexQueue.poll().order;
        }
        return res;
    }

    private String medal(int i) {
        switch (i) {
            case 1:
                return "Gold Medal";
            case 2:
                return "Silver Medal";
            case 3:
                return "Bronze Medal";
            default:
                return i + "";
        }
    }

    class Rank {
        int index;
        int score;
        String order;
        public Rank(int index, int score) {
            this.index = index;
            this.score = score;
        }
    }

    public static void main(String[] args)
    {
        int[] score = new int[]{5, 4, 3, 2, 1};
        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.findRelativeRanks(score)));
    }
}
