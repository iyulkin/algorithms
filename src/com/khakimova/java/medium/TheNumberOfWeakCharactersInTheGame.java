package com.khakimova.java.medium;

import java.util.Arrays;
import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

/**
 * You are playing a game that contains multiple characters, and each of the characters has two main properties: attack and defense.
 * You are given a 2D integer array properties where properties[i] = [attacki, defensei] represents the properties of the ith character in the game.
 * <p>
 * A character is said to be weak if any other character has both attack and defense levels strictly greater than this character's attack and defense levels.
 * More formally, a character i is said to be weak if there exists another character j where attackj > attacki and defensej > defensei.
 * <p>
 * Return the number of weak characters.
 */
public class TheNumberOfWeakCharactersInTheGame {

    public int numberOfWeakCharacters(int[][] properties) {
        Arrays.sort(properties, (a, b) -> (a[0] == b[0]) ? a[1] - b[1] : b[0] - a[0]);

        int weakCharactersAmount = 0;
        int maxDefence = -1;

        for (int[] property : properties) {
            if (property[1] < maxDefence) {
                weakCharactersAmount++;
            } else {
                maxDefence = property[1];
            }
        }

        return weakCharactersAmount;
    }

    @Test
    public void test() {
        assertThat(numberOfWeakCharacters(new int[][]{{7, 9}, {10, 7}, {6, 9}, {10, 4}, {7, 5}, {7, 10}}), equalTo(2));
        assertThat(numberOfWeakCharacters(new int[][]{{7, 7}, {1, 2}, {9, 7}, {7, 3}, {3, 10}, {9, 8}, {8, 10}, {4, 3}, {1, 5}, {1, 5}}), equalTo(6));
        assertThat(numberOfWeakCharacters(new int[][]{{1, 1}, {2, 1}, {2, 2}, {1, 2}}), equalTo(1));
        assertThat(numberOfWeakCharacters(new int[][]{{5, 5}, {6, 3}, {3, 6}}), equalTo(0));
        assertThat(numberOfWeakCharacters(new int[][]{{1, 5}, {10, 4}, {4, 3}}), equalTo(1));
        assertThat(numberOfWeakCharacters(new int[][]{{2, 2}, {3, 3}}), equalTo(1));
    }
}
