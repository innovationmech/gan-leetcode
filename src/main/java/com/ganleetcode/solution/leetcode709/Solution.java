package com.ganleetcode.solution.leetcode709;

/**
 * todo
 *
 * @author <a href="dreamerlyj@gmail.com">liyanjie</a>
 * @since
 */
public class Solution
{
    public String toLowerCase(String s) {
        StringBuilder res = new StringBuilder();
        for (int c : s.toCharArray()) {
            if (c < 'a') {
                res.append((char) (c + 26));
            } else {
                res.append((char) c);
            }
        }
        return res.toString();
    }

    public static void main(String[] args)
    {
        System.out.println('a' - 'A');
    }
}
