package com.khakimova.scala.medium

import com.khakimova.scala.medium.LongestSubstringWithoutRepeatingCharacters.lengthOfLongestSubstring
import org.junit.Assert.assertEquals
import org.junit.Test

import scala.collection.mutable

object LongestSubstringWithoutRepeatingCharacters {
  def lengthOfLongestSubstring(s: String): Int = {
    var resultLength = 0
    var leftPointer = 0
    val charactersSet = new mutable.HashSet[Char]()

    (0 until s.length).foreach { rightPointer =>
      val characterAtRightPointer = s.charAt(rightPointer)
      if (!charactersSet.add(characterAtRightPointer)) {
        while (s.charAt(leftPointer) != characterAtRightPointer) {
          charactersSet.remove(s.charAt(leftPointer))
          leftPointer += 1
        }
        leftPointer += 1
      }
      if (charactersSet.size > resultLength) resultLength = charactersSet.size
    }
    resultLength
  }
}

class LongestSubstringWithoutRepeatingCharacters {
  @Test
  def lengthOfLongestSubstringTest = {
    assertEquals(3, lengthOfLongestSubstring("abcabcbb"))
    assertEquals(1, lengthOfLongestSubstring("bbbbbbbb"))
    assertEquals(3, lengthOfLongestSubstring("pwwkew"))
  }
}