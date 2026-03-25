package org.example.trig.baseFunctions

import kotlin.math.abs

object Cos: ReducibleTrigFunction() {
    override fun calculateReduced(x: Double, eps: Double): Double {
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