package org.example.trig.baseFunctions
import kotlin.math.abs;

class Sec(
    private val cos: TrigFunction = Cos(),
): TrigFunction {
    override fun calculate(x: Double, eps: Double): Double {
        val cosValue = cos.calculate(x, eps)
        if (abs(cosValue) < eps) {
            throw ArithmeticException("Sec undefined at x=$x")
        }
        return 1 / cosValue
    }
}