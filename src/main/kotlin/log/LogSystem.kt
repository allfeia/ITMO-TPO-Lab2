package org.example.log

import kotlin.math.pow

class LogSystem(
    private val ln: NatLog = Ln,
    private val log: NLog = Log(ln)
) {
    fun calculate(x: Double, eps: Double = 1e-6): Double {
        require(x > 0) {
            "LogSystem defined only for x > 0, got $x"
        }

        val xln = ln.calculate(x, eps)
        val log5 = log.calculate(x, 5.0, eps)
        val log10 = log.calculate(x, 10.0, eps)

        return (((log10.pow(3.0) * log5) / xln).pow(3.0)) / log10 + xln + log10
    }
}