package com.khakimova.scala.medium

import com.khakimova.scala.medium.LongestSubstringWithoutRepeatingCharacters.lengthOfLongestSubstring
import org.junit.Assert.assertEquals
import org.junit.Test

import scala.collection.mutable.HashMap

object LongestSubstringWithoutRepeatingCharacters {
  def lengthOfLongestSubstring(s: String): Int = {
        var resultLength = 0
        var leftPointer = 0
        var rightPointer = 0
        val charactersMap = new HashMap[Char, Int]()

        while (rightPointer < s.length) {
          val characterAtRightPointer = s.charAt(rightPointer)
          charactersMap.get(characterAtRightPointer) match {
            case Some(index) => leftPointer = index + 1
            case _ =>
          }
          charactersMap.put(characterAtRightPointer, rightPointer)
          rightPointer - leftPointer + 1 match {
            case currentLength if currentLength > resultLength => resultLength = currentLength
            case _ =>
          }
          rightPointer = rightPointer + 1
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