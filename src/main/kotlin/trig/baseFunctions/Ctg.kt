package org.example.trig.baseFunctions
import kotlin.math.abs;

class Ctg(
    private val sin: TrigFunction = Sin,
    private val cos: TrigFunction = Cos,
): TrigFunction {
    override fun calculate(x: Double, eps: Double): Double {
        val sinValue = sin.calculate(x, eps)
        return if (abs(sinValue) < eps)
            throw ArithmeticException("Ctg undefined at x=$x")
        else cos.calculate(x, eps) / sinValue
    }
}