package org.example.trig.baseFunctions

import kotlin.math.PI

class Cos(
    private val sin: TrigFunction = Sin
): TrigFunction {
    override fun calculate(x: Double, eps: Double): Double {
        return sin.calculate(PI/2 - x, eps)
    }
}