package org.example.trig

import java.io.File

class Stub(fileName: String) {

    private val table: Map<Double, Double>

    init {
        table = File(fileName)
            .readLines()
            .drop(1)
            .associate { line ->
                val parts = line.split(",")
                val x = parts[0].toDouble()
                val y = parts[1].toDouble()
                x to y
            }
    }

    fun calculate(x: Double): Double {
        return table[x] ?: Double.NaN
    }
}