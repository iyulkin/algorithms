package com.khakimova.hard;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Given two sorted arrays nums1 and nums2 of size m and n respectively, return the median of the two sorted arrays.
 * <p>
 * The overall run time complexity should be O(log (m+n)).
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: nums1 = [1,3], nums2 = [2]
 * Output: 2.00000
 * Explanation: merged array = [1,2,3] and median is 2.
 * Example 2:
 * <p>
 * Input: nums1 = [1,2], nums2 = [3,4]
 * Output: 2.50000
 * Explanation: merged array = [1,2,3,4] and median is (2 + 3) / 2 = 2.5.
 */
public class MedianOfTwoSortedArrays {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        List<Integer> numbers = IntStream.concat(Arrays.stream(nums1), Arrays.stream(nums2))
                .sorted().boxed().collect(Collectors.toList());
        int size = numbers.size();

        if (size == 1) {
            return numbers.get(0);
        }
        int medianIndex = size / 2;

        if (size % 2 == 0) {
            return (double) (numbers.get(medianIndex - 1) + numbers.get(medianIndex)) / 2;
        } else {
            return (double) numbers.get(medianIndex);
        }
    }

    public double findMedianSortedArrays2(int[] nums1, int[] nums2) {
        int size = nums1.length + nums2.length;
        int medianIndex = size / 2;
        int[] medianNumbers = new int[]{0, 0};
        int i1 = 0;
        int i2 = 0;
        int i = 0;

        while (i <= medianIndex) {
            if (i1 < nums1.length && (i2 >= nums2.length || nums1[i1] < nums2[i2])) {
                if (medianIndex - i < 2 - size % 2) {
                    if(size % 2 == 1) {
                        return nums1[i1];
                    }
                    medianNumbers[1 - medianIndex + i] = nums1[i1];
                }
                i1++;
            } else {
                if (medianIndex - i < 2 - size % 2) {
                    if(size % 2 == 1) {
                        return nums2[i2];
                    }
                    medianNumbers[1 - medianIndex + i] = nums2[i2];
                }
                i2++;
            }
            i++;
        }

        return (double) (medianNumbers[0] + medianNumbers[1]) / 2;
    }

    @Test
    public void test() {
        assertEquals(2.0, findMedianSortedArrays2(new int[]{1, 3}, new int[]{2}), 0);
        assertEquals(2.5, findMedianSortedArrays2(new int[]{1, 2}, new int[]{3, 4}), 0);
    }
}
