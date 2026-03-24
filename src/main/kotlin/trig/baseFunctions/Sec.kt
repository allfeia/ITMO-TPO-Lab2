package org.example.trig.baseFunctions

object Sec {
    fun calculate(x: Double): Double {
        val cos = Cos.calculate(x)
        return if (cos == 0.0) Double.NaN else 1 / cos
    }
}