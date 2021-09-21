package com.ganleetcode.solution.priorityqueue;

import java.util.PriorityQueue;
import java.util.Random;

public class Demo1
{
    public static void main(String[] args)
    {
        Random random = new Random(10L);
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        for (int i = 0; i < 10; i++) {
            pq.add(random.nextInt(100));
        }
        while (!pq.isEmpty()) {
            System.out.println(pq.poll());
        }
    }
}
