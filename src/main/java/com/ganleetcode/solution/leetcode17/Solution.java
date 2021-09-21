package com.ganleetcode.solution.leetcode17;

import java.util.ArrayList;
import java.util.List;

public class Solution
{
    private List<String> res = new ArrayList<>();

    private String[] letterMap = {" ", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    public List<String> letterCombinations(String digits) {
        res.clear();
        if (digits.length() == 0) {
            return res;
        }
        findCombination(digits, 0, "");
        return res;
    }

    private void findCombination(String digits, int index, String s) {
        System.out.println(index + ": " + s);
        if (index == digits.length()) {
            res.add(s);
            return;
        }
        char number = digits.charAt(index);
        String letter = letterMap[number - '0'];
        for (int i = 0; i < letter.length(); i++) {
            findCombination(digits, index + 1, s + letter.charAt(i));
        }
    }

    public static void main(String[] args)
    {
        Solution solution = new Solution();
        List<String> res = solution.letterCombinations("234");
        for (int i = 0; i < res.size(); i++) {
            System.out.println(res.get(i));
        }
    }
}
