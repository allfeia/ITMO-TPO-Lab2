package org.example.trig.baseFunctions

object Csc {
    fun calculate(x: Double): Double {
        val sin = Sin.calculate(x)
        return if (sin == 0.0) Double.NaN else 1 / sin
    }
}