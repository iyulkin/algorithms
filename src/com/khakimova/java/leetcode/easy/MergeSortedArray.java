package com.khakimova.java.leetcode.easy;

/**
 * You are given two integer arrays nums1 and nums2, sorted in non-decreasing order, and two integers m and n, representing the number of elements in nums1 and nums2 respectively.
 *
 * Merge nums1 and nums2 into a single array sorted in non-decreasing order.
 *
 * The final sorted array should not be returned by the function, but instead be stored inside the array nums1.
 * To accommodate this, nums1 has a length of m + n, where the first m elements denote the elements that should be merged, and the last n elements are set to 0 and should be ignored. nums2 has a length of n.
 */
public class MergeSortedArray {

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if(n == 0) {
            return;
        }
        if(m == 0) {
            for(int i = 0; i < n; i++) {
                nums1[i] = nums2[i];
            }
        }
        int i = m - 1;
        int j = n - 1;
        int l = m + n - 1;
        while(j >= 0) {
            if(i < 0 || nums2[j] >= nums1[i]) {
                nums1[l] = nums2[j];
                j--;
            } else {
                int t = nums1[l];
                nums1[l] = nums1[i];
                nums1[i] = t;
                i--;
            }
            l--;
        }
    }
}
