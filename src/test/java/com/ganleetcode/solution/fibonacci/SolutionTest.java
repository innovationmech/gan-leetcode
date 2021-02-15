package com.ganleetcode.solution.fibonacci;

import org.junit.Test;

public class SolutionTest
{
    @Test
    public void test01() {
        Solution solution = new Solution();
        System.out.println(solution.fib(100));
    }

    @Test
    public void test02() {
        Solution2 solution2 = new Solution2();
        System.out.println(solution2.fib(2));
    }
}
