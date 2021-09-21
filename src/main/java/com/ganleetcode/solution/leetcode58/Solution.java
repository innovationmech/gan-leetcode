package com.ganleetcode.solution.leetcode58;

/**
 * todo
 *
 * @author <a href="dreamerlyj@gmail.com">liyanjie</a>
 * @since
 */
public class Solution
{
    public int lengthOfLastWord(String s) {
        int index = s.length() - 1;
        while (s.charAt(index) == ' ') {
            index--;
        }
        int res = 0;
        while (index >= 0 && s.charAt(index) != ' ') {
            res++;
            index--;
        }
        return res;
    }
}
