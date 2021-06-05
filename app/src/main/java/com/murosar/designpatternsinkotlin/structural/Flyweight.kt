package com.murosar.designpatternsinkotlin.structural

class Gazillion(maxPerRow: Int) {
    private val row: Int = num / maxPerRow
    private val col: Int = num % maxPerRow

    init {
        num++
    }

    fun report() {
        print(" $row$col")
    }

    companion object {
        private var num = 0
    }
}

class FlyweightClient {

    fun doSomething() {
        val matrix = Array(ROWS) { arrayOfNulls<Gazillion>(COLS) }

        for (row in 0 until ROWS) {
            for (col in 0 until COLS) {
                matrix[row][col] = Gazillion(COLS)
            }
        }
        for (row in 0 until ROWS) {
            for (col in 0 until COLS) {
                matrix[row][col]?.report()
            }
            println()
        }
    }

    companion object {
        const val ROWS = 6
        const val COLS = 10
    }

    // Print:
    // 00 01 02 03 04 05 06 07 08 09
    // 10 11 12 13 14 15 16 17 18 19
    // 20 21 22 23 24 25 26 27 28 29
    // 30 31 32 33 34 35 36 37 38 39
    // 40 41 42 43 44 45 46 47 48 49
    // 50 51 52 53 54 55 56 57 58 59
}
