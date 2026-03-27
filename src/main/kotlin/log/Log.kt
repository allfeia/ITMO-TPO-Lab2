package org.example.log

class Log {
    companion object: NLog {
        override fun calculate(x: Double, base: Double, eps: Double): Double {
            require(base != 1.0) { "так нельзя" }
            return Ln.calculate(x, eps) / Ln.calculate(base, eps)
        }
    }
}