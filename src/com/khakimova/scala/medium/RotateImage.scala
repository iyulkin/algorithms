package com.khakimova.scala.medium

import com.khakimova.scala.medium.RotateImage.rotate
import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.core.Is.is
import org.hamcrest.core.IsEqual.equalTo
import org.junit.Test

object RotateImage {
  def rotate(matrix: Array[Array[Int]]): Array[Array[Int]] = {
    val length = matrix.length;
    var left = 0
    var top = 0
    var right = length - 1
    var bottom = length - 1;

    while (left < right && top < bottom) {
      for (i <- 0 until right - left) {
        val first = matrix(top)(left + i)
        val second = matrix(top + i)(right)
        val third = matrix(bottom)(right - i)
        matrix(top)(left + i) = matrix(bottom - i)(left)
        matrix(top + i)(right) = first
        matrix(bottom)(right - i) = second
        matrix(bottom - i)(left) = third
      }
      left += 1;
      top += 1;
      right -= 1;
      bottom -= 1;
    }
    matrix
  }
}

class RotateImage {
  @Test
  def test = {
    assertThat(Array[Array[Int]](Array(7, 4, 1), Array(8, 5, 2), Array(9, 6, 3)),
      equalTo(rotate(Array[Array[Int]](Array(1, 2, 3), Array(4, 5, 6), Array(7, 8, 9)))))
  }
}
