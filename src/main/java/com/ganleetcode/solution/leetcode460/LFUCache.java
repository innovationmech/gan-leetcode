package com.ganleetcode.solution.leetcode460;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * todo
 *
 * @author <a href="dreamerlyj@gmail.com">liyanjie</a>
 * @since
 */
public class LFUCache
{

    int minFreq, capacity;
    Map<Integer, Node> key_table;
    Map<Integer, LinkedList<Node>> freq_table;


    public LFUCache(int capacity)
    {
        this.minFreq = Integer.MAX_VALUE;
        this.capacity = capacity;
        key_table = new HashMap<>();
        freq_table = new HashMap<>();
    }

    public int get(int key)
    {
        if (capacity == 0) {
            return -1;
        }
        if (!key_table.containsKey(key)) {
            return -1;
        }
        Node node = key_table.get(key);
        if (node.freq == minFreq && freq_table.get(node.freq).size() == 1) {
            minFreq++;
        }
        freq_table.get(node.freq).remove(node);
        if (freq_table.get(++node.freq) != null) {
            freq_table.get(node.freq).add(node);
        } else {
            LinkedList<Node> newList = new LinkedList<>();
            newList.add(node);
            freq_table.put(node.freq, newList);
        }
        return node.val;
    }

    public void put(int key, int value)
    {
        if (capacity == 0) {
            return;
        }
        if (!key_table.containsKey(key)) {
            Node newNode = new Node(key, value, 1);
            if (key_table.size() == capacity) {
                final Node first = freq_table.get(minFreq).pollFirst();
                key_table.remove(first.key);
            }
            key_table.put(key, newNode);
            LinkedList<Node> l = freq_table.get(1);
            if (l == null) {
                LinkedList<Node> newLinked = new LinkedList<>();
                newLinked.add(newNode);
                freq_table.put(1, newLinked);
            } else {
                l.add(newNode);
            }
            minFreq = 1;
        } else {
            Node node = key_table.get(key);
            if (node.freq == minFreq && freq_table.get(node.freq).size() == 1) {
                minFreq++;
            }
            freq_table.get(node.freq).remove(node);
            node.val = value;
            if (freq_table.get(++node.freq) != null) {
                freq_table.get(node.freq).add(node);
            } else {
                LinkedList<Node> linkedList = new LinkedList<>();
                linkedList.add(node);
                freq_table.put(node.freq, linkedList);
            }
        }
    }

    class Node {
        int key, val, freq;

        Node(int key, int val, int freq)
        {
            this.key = key;
            this.val = val;
            this.freq = freq;
        }
    }


}

