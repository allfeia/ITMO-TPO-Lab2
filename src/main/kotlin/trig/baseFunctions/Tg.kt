package org.example.trig.baseFunctions

object Tg {
    fun calculate(x: Double): Double {
        val cos = Cos.calculate(x)
        return if (cos == 0.0) Double.NaN else Sin.calculate(x) / cos
    }
}