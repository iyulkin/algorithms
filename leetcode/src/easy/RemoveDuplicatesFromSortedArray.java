package easy;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Given an integer array nums sorted in non-decreasing order, remove the duplicates in-place such that each unique element appears only once. The relative order of the elements should be kept the same.
 * <p>
 * Since it is impossible to change the length of the array in some languages, you must instead have the result be placed in the first part of the array nums. More formally, if there are k elements after removing the duplicates, then the first k elements of nums should hold the final result. It does not matter what you leave beyond the first k elements.
 * <p>
 * Return k after placing the final result in the first k slots of nums.
 * <p>
 * Do not allocate extra space for another array. You must do this by modifying the input array in-place with O(1) extra memory
 */
public class RemoveDuplicatesFromSortedArray {

    @Test
    public void test() {
        int[] nums = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        int[] numsExpected = new int[]{0, 1, 2, 3, 4};
        int k = removeDuplicates(nums);
        assertEquals(5, k);
        for(int i = 0; i < k; i++) {
            assertEquals(numsExpected[i], nums[i]);
        }
    }

    private int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int k = 1;

        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] != nums[i + 1]) {
                nums[k] = nums[i + 1];
                k++;
            }
        }
        return k;
    }
}
