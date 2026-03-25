package org.example.trig.baseFunctions
import kotlin.math.abs;

class Csc(
    private val sin: TrigFunction = Sin
): TrigFunction {
     override fun calculate(x: Double, eps: Double): Double {
        val sinValue = sin.calculate(x, eps)
        return if (abs(sinValue) < eps)
            throw ArithmeticException("Csc undefined at x=$x")
         else 1 / sinValue
    }
}