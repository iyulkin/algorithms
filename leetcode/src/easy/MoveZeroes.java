package easy;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

/**
 * Given an integer array nums, move all 0's to the end of it while maintaining the relative order of the non-zero elements.
 * <p>
 * Note that you must do this in-place without making a copy of the array.
 */
public class MoveZeroes {
    public int[] moveZeroes(int[] nums) {
        int zeroes = 0; // counter for zeroes found
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                zeroes++; // increase zeroes counter
            } else {
                if (zeroes > 0) {
                    nums[i - zeroes] = nums[i]; // move to the left to amount of zeroes found
                    nums[i] = 0; // place zero instead
                }
            }
        }
        return nums;
    }

    @Test
    public void moveZeroesTest() {
        assertArrayEquals(new int[]{1, 3, 12, 0, 0}, moveZeroes(new int[]{0, 1, 0, 3, 12}));
        assertArrayEquals(new int[]{0}, moveZeroes(new int[]{0}));
        assertArrayEquals(new int[]{1}, moveZeroes(new int[]{1}));
    }
}
