package org.example.trig.baseFunctions

import kotlin.math.abs

object Sin {
    fun calculate(x: Double, eps: Double = 1e-6): Double {
        var term = x
        var sum = 0.0
        var n = 1

        while (abs(term) > eps) {
            sum += term
            n += 2
            term *= -x * x / (n * (n - 1))
        }

        return sum
    }
}