package com.ganleetcode.solution.leetcode748;

import java.util.HashMap;
import java.util.Map;

/**
 * todo
 *
 * @author <a href="dreamerlyj@gmail.com">liyanjie</a>
 * @since
 */
public class Solution
{
    public String shortestCompletingWord(String licensePlate, String[] words) {
        String res = null;
        licensePlate = licensePlate.toLowerCase();
        Map<Character, Integer> map = new HashMap<>();
        for (Character c : licensePlate.toCharArray()) {
            if (c >= 'a' && c < 'z') {
                if (map.containsKey(c)) {
                    map.put(c, map.get(c) + 1);
                } else {
                    map.put(c, 1);
                }
            }
        }
        for (String word : words) {
            Map<Character, Integer> tempMap = new HashMap<>();
            for (Character c : word.toCharArray()) {
                if (tempMap.containsKey(c)) {
                    tempMap.put(c, map.get(c) + 1);
                } else {
                    tempMap.put(c, 1);
                }
            }
            for (Character cc : map.keySet()) {
                if (!tempMap.containsKey(cc) || tempMap.get(cc) <= map.get(cc)) {
                    break;
                }
            }

        }
        return res;
    }

}
