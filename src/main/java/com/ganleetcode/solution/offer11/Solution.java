package com.ganleetcode.solution.offer11;

/**
 * 剑指 Offer 11. 旋转数组的最小数字
 * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。输入一个递增排序的数组的一个旋转，输出旋转数组的最小元素。
 * 例如，数组[3,4,5,1,2] 为 [1,2,3,4,5] 的一个旋转，该数组的最小值为1。
 *
 * 示例 1：
 * 输入：[7,8,9,1,2,3,4]
 * 输出：1
 *
 * 示例 2：
 * 输入：[2,2,2,0,1]
 * 输出：0
 *
 * [1, 3, 5]
 */
public class Solution
{
    public int minArray(int[] numbers) {
        int left = 0;
        int right = numbers.length - 1;
        if (numbers[left] < numbers[right]) {
            return numbers[left];
        }
        while(left < right) {
            int mid = left + ((right - left) >> 1);
            if (numbers[mid] < numbers[left]){
                right = mid;
            } else if (numbers[mid] > numbers[left]){
                if (numbers[mid] > numbers[right]) {
                    left = mid;
                } else if (numbers[mid] == numbers[right]) {
                    right = mid;
                }
            } else if (numbers[mid] == numbers[left] && right - left > 1){
                if (numbers[mid] > numbers[right]) {
                    left = mid;
                } else if (numbers[mid] < numbers[right]) {
                    right = mid;
                } else {
                    left += 1;
                }
            } else {
                break;
            }
        }
        return Math.min(numbers[left],numbers[right]);
    }

}
