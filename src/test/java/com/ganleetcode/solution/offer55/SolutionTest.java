package com.ganleetcode.solution.offer55;

import com.ganleetcode.solution.common.TreeNode;
import org.junit.Test;

public class SolutionTest
{
    @Test
    public void solution_1() {
        Solution solution  = new Solution();
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.right = new TreeNode(3);
        System.out.println(solution.isBalanced(root));
    }
}
