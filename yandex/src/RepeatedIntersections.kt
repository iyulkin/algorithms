import org.junit.jupiter.api.Assertions.assertEquals

fun main() {
    // Даны два массива: [1, 2, 0, 2, 3, 2, 2] и [5, 1, 2, 7, 3, 2]
    // Надо вернуть [1, 2, 2, 3] (порядок не важен)

    assertEquals(listOf(1, 2, 2, 3).sorted(),
            repeatedIntersections(intArrayOf(1, 2, 0, 2, 3, 2, 2), intArrayOf(5, 1, 2, 7, 3, 2)).sorted())
}

fun repeatedIntersections(first: IntArray, second: IntArray): List<Int> {
    val firstMap = first.groupBy { it }
    val secondMap = second.groupBy { it }

    val result = mutableListOf<Int>()
    firstMap.entries.forEach { entry ->
        val secondEntry = secondMap.get(entry.key)
        if (secondEntry != null) {
            result.addAll(if (secondEntry.size > entry.value.size) entry.value else secondEntry)
        }
    }
    return result
}
