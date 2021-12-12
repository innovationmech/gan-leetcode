package com.ganleetcode.solution.leetcode146;

import java.util.LinkedList;
import java.util.List;
import org.junit.Test;

/**
 * todo
 *
 * @author <a href="dreamerlyj@gmail.com">liyanjie</a>
 * @since
 */
public class ListTest
{
    @Test
    public void test01() {
        List<Integer> list = new LinkedList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.remove(2);
        System.out.println(list);
    }
}
