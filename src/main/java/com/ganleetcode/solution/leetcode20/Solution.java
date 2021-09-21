package com.ganleetcode.solution.leetcode20;

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution
{
    public boolean isValid(String s) {
        if (s.length() % 2 != 0) {
            return false;
        }
        Deque<Character> deque = new ArrayDeque<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(' || s.charAt(i) == '[' || s.charAt(i) == '{') {
                deque.push(s.charAt(i));
            } else if (!deque.isEmpty()) {
                if (deque.peek() == '(' && s.charAt(i) == ')') {
                    deque.pop();
                } else if (deque.peek() == '[' && s.charAt(i) == ']') {
                    deque.pop();
                } else if (deque.peek() == '{' && s.charAt(i) == '}') {
                    deque.pop();
                } else {
                    return false;
                }
            } else {
                return false;
            }
        }
        return deque.isEmpty();
    }
}
