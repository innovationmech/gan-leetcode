package com.ganleetcode.solution.leetcode220;

import java.util.SortedMap;
import java.util.TreeMap;

public class SortedMapDemo
{
    public static void main(String[] args)
    {
        SortedMap<Integer, Integer> sortedMap = new TreeMap<>();
        if (sortedMap.headMap(1).isEmpty()) {
            System.out.println(true);
        }
    }
}
