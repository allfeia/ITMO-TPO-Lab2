package org.example.trig.baseFunctions
import kotlin.math.abs;

class Tg(
    private val sin: TrigFunction = Sin,
    private val cos: TrigFunction = Cos
): TrigFunction {
    override fun calculate(x: Double, eps: Double): Double {
        val cosValue = cos.calculate(x)
        return if (abs(cosValue) < eps)
            throw ArithmeticException("Tg undefined at x=$x")
        else sin.calculate(x, eps) / cosValue
    }
}