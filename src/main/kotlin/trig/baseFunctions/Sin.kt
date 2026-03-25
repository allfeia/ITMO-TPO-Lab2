package org.example.trig.baseFunctions

import kotlin.math.abs

object Sin: ReducibleTrigFunction() {
    override fun calculateReduced(x: Double, eps: Double): Double {
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