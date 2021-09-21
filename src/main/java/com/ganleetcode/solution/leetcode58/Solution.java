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
        final String[] strings = s.split(" ");
        return strings[strings.length - 1].length();
    }
}
