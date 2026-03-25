package org.example.trig

import org.example.trig.baseFunctions.*
import kotlin.math.pow

class TrigSystem(
    private val sin: TrigFunction = Sin,
    private val cos: TrigFunction = Cos,
    private val tg: TrigFunction = Tg(sin, cos),
    private val ctg: TrigFunction = Ctg(sin, cos),
    private val sec: TrigFunction = Sec(cos),
    private val csc: TrigFunction = Csc(sin)
) {

    fun calculate(x: Double, eps: Double = 1e-6): Double {
        require(x <= 0) {
            "TrigSystem defined only for x <= 0, got $x"
        }

        val sinVal = sin.calculate(x, eps)
        val cosVal = cos.calculate(x, eps)
        val tgVal = tg.calculate(x, eps)
        val ctgVal = ctg.calculate(x, eps)
        val secVal = sec.calculate(x, eps)
        val cscVal = csc.calculate(x, eps)

        val part1 = ((cscVal - cscVal) * cosVal) / sinVal
        val part2 = tgVal - (cscVal / cosVal)
        val part3 = (part1 - part2 - secVal).pow(3.0) * tgVal - ctgVal - cosVal
        val part4 = part3.pow(2.0)
        val part5 = (ctgVal - tgVal).pow(3.0).pow(2.0) / sinVal

        return part4 - part5.pow(2.0)
    }
}