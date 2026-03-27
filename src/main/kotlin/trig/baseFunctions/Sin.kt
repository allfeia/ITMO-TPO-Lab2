package org.example.trig.baseFunctions

import kotlin.math.abs

object Sin: TrigFunction {
    override fun calculate(x: Double, eps: Double): Double {
        val reduced = x % (2 * Math.PI)
        var term = reduced
        var sum = 0.0
        var n = 1

        while (abs(term) > eps) {
            sum += term
            n += 2
            term *= -reduced * reduced / (n * (n - 1))
        }

        return sum
    }
}