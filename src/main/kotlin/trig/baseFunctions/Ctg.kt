package org.example.trig.baseFunctions

object Ctg {
    fun calculate(x: Double): Double {
        val sin = Sin.calculate(x)
        return if (sin == 0.0) Double.NaN else Cos.calculate(x) / sin
    }
}