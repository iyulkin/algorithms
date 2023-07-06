package com.khakimova.java.leetcode.easy;

import com.khakimova.java.leetcode.helper.TreeNode;
import java.util.Arrays;

/**
 * Given an integer array nums where the elements are sorted in ascending order, convert it to a
 * height-balanced
 *  binary search tree.
 */
public class ConvertSortedArrayToBinarySearchTree {

    private TreeNode sortedArrayToBST(int[] nums) {
        if(nums == null || nums.length == 0) {
            return null;
        }
        int median = nums.length / 2;
        TreeNode node = new TreeNode(nums[median]);
        if(median > 0) {
            node.left = sortedArrayToBST(Arrays.copyOf(nums, median));
        }
        if(median < nums.length - 1) {
            node.right = sortedArrayToBST(Arrays.copyOfRange(nums, median + 1, nums.length));
        }
        return node;
    }
}
