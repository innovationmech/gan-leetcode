package com.ganleetcode.solution.leetcode371;

/**
 * todo
 *
 * @author <a href="dreamerlyj@gmail.com">liyanjie</a>
 * @since
 */
public class Solution
{
    public int getSum(int a, int b) {
        while (b != 0) {
            int carry = (a & b) << 1; // 进位和
            a = (a ^ b); // 无进位和
            b = carry;
        }
        return a;
    }
}
