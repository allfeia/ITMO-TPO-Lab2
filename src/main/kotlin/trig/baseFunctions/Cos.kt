package org.example.trig.baseFunctions

import kotlin.math.abs

object Cos {
    fun calculate(x: Double, eps: Double = 1e-6): Double {
        var term = 1.0
        var sum = 0.0
        var n = 0

        while (abs(term) > eps) {
            sum += term
            n += 2
            term *= -x * x / (n * (n - 1))
        }
        return sum
    }
}