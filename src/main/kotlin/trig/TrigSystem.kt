package org.example.trig

import org.example.trig.baseFunctions.*
import kotlin.math.pow

object TrigSystem {

    fun calculate(x: Double): Double {
        require(x <= 0)

        val sin = Sin.calculate(x)
        val cos = Cos.calculate(x)
        val tan = Tg.calculate(x)
        val cot = Ctg.calculate(x)
        val sec = Sec.calculate(x)
        val csc = Csc.calculate(x)

        val part1 = ((csc - csc) * cos) / sin
        val part2 = tan - (csc / cos)
        val part3 = (part1 - part2 - sec).pow(3.0) * tan - cot - cos
        val part4 = part3.pow(2.0)
        val part5 = (cot - tan).pow(3.0).pow(2.0) / sin

        return part4 - part5.pow(2.0)
    }
}