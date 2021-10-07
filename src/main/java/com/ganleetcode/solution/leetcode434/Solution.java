package com.ganleetcode.solution.leetcode434;

/**
 * todo
 *
 * @author <a href="dreamerlyj@gmail.com">liyanjie</a>
 * @since
 */
public class Solution
{
    public int countSegments(String s) {
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            if ((i == 0 || s.charAt(i - 1) == ' ') && s.charAt(i) != ' ') {
                res++;
            }
        }
        return res;
    }
}
