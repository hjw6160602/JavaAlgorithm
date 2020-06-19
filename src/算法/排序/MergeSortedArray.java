/**
 * 88-MergeSortedArray
 * https://leetcode.com/problems/merge-sorted-array/
 * Created by SaiDiCaprio on 2020/6/8.
 * Copyright © 2020 SaiDiCaprio. All rights reserved.
 */

package 算法.排序;

public class MergeSortedArray {
    class Solution {
        public void merge(int[] nums1, int m, int[] nums2, int n) {
            int k = m - 1;
            int j = n - 1;
            int index = nums1.length - 1;
            while (j >= 0) {
                if (k >= 0 && nums2[j] > nums1[k]) {
                    nums1[index--] = nums2[j--];
                } else {
                    nums1[index--] = nums1[k--];
                }
            }
        }
    }
}
