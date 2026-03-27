package org.example.log

import kotlin.math.pow

class LogSystem {
    companion object {
        fun calculate(x: Double, eps: Double = 1e-6): Double {
            require(x > 0) {
                "LogSystem defined only for x > 0, got $x"
            }

            val ln = Ln.calculate(x, eps)
            val log2 = Log.calculate(x, 2.0, eps)
            val log5 = Log.calculate(x, 5.0, eps)
            val log10 = Log.calculate(x, 10.0, eps)

            return (((log10.pow(3.0) * log5) / ln).pow(3.0)) / log10 + ln + log10
        }
    }
}