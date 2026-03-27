package org.example.trig

import org.example.trig.baseFunctions.*
import kotlin.math.pow

class TrigSystem(
    private val sin: TrigFunction = Sin,
    private val cos: TrigFunction = Cos(sin),
    private val tg: TrigFunction = Tg(sin, cos),
    private val sec: TrigFunction = Sec(cos),
) {

    fun calculate(x: Double, eps: Double = 1e-6): Double {
        require(x <= 0) {
            "TrigSystem defined only for x <= 0, got $x"
        }

        val sinVal = sin.calculate(x, eps)
        val cosVal = cos.calculate(x, eps)
        val tgVal = tg.calculate(x, eps)
        val secVal = sec.calculate(x, eps)

        return ((secVal.pow(2) + sinVal).pow(2)) - tgVal - cosVal.pow(3)
    }
}