package com.ganleetcode.solution.leetcode639;

/**
 * todo
 *
 * @author <a href="dreamerlyj@gmail.com">liyanjie</a>
 * @since
 */
public class Solution
{
    public int numDecodings(String s) {
        long[] dp = new long[s.length() + 1];
        dp[0] = 1;
        dp[1] = s.charAt(0) == '*' ? 9 : 1;
        if (s.charAt(0) == '0') {
            dp[1] = 0;
        } else if (s.charAt(0) == '*') {
            dp[1] = 9;
        } else {
            dp[1] = 1;
        }
        int divisor = 1_000_000_007;
        for (int i = 2; i < s.length() + 1; i++) {
            // 字符串倒数第二位不为'*'
            if (s.charAt(i - 2) != '*') {
                // 倒数第二位有有三种特殊情况: '0', '1', '2' 需要单独考虑
                if (s.charAt(i - 2) == '0') {
                    if (s.charAt(i - 1) == '0') {
                        return 0;
                    } else if (s.charAt(i - 1) != '*') {
                        dp[i] = dp[i - 1] % divisor;
                    } else {
                        dp[i] = (dp[i - 1] * 9) % divisor;
                    }
                }
                if (s.charAt(i - 2) == '1') {
                    // 要注意最后一位为 '0' 的情况
                    if (s.charAt(i - 1) == '0') {
                        dp[i] = dp[i - 2] % divisor;
                    } else if (s.charAt(i - 1) != '*') {
                        dp[i] = (dp[i - 1] + dp[i - 2]) % divisor;
                    } else {
                        dp[i] = (dp[i - 1] * 9 + dp[i - 2] * 9) % divisor;
                    }
                }
                if (s.charAt(i - 2) == '2') {
                    if (s.charAt(i - 1) == '0') {
                        dp[i] = dp[i - 2] % divisor;
                    } else if (s.charAt(i - 1) != '*' && castCharToInt(s.charAt(i - 1)) > 6) {
                        dp[i] = dp[i - 1] % divisor;
                    } else if (s.charAt(i - 1) != '*' && castCharToInt(s.charAt(i - 1)) <= 6) {
                        dp[i] = (dp[i - 1] + dp[i - 2]) % divisor;
                    } else {
                        dp[i] = (dp[i - 1] * 9 + dp[i - 2] * 6) % divisor;
                    }
                }
                if (castCharToInt(s.charAt(i - 2)) > 2) {
                    if (s.charAt(i - 1) == '0') {
                        return 0;
                    } else if (s.charAt(i - 1) != '*') {
                        dp[i] = dp[i - 1] % divisor;
                    } else {
                        dp[i] = (dp[i - 1] * 9) % divisor;
                    }
                }
            }
            // 字符串倒数第二位为'*'
            if (s.charAt(i - 2) == '*') {
                if (s.charAt(i - 1) == '0') {
                    dp[i] = dp[i - 2] * 2;
                } else if (s.charAt(i - 1) != '*' && castCharToInt(s.charAt(i - 1)) <= 6) {
                    dp[i] = (dp[i - 1] + dp[i - 2] * 2) % divisor;
                } else if (s.charAt(i - 1) != '*' && castCharToInt(s.charAt(i - 1)) > 6) {
                    dp[i] = (dp[i - 1] + dp[i - 2]) % divisor;
                } else {
                    dp[i] = (dp[i - 1] * 9 + dp[i - 2] * 15) % divisor;
                }
            }
        }
        return (int) (dp[s.length()] % divisor);
    }

    private int castCharToInt(Character c) {
        return Integer.parseInt(c + "");
    }

    public static void main(String[] args)
    {
        Solution solution = new Solution();
        System.out.println(solution.numDecodings("19302****878*****473872083")); // expect 9
    }

}
