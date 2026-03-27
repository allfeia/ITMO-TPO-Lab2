package org.example.log

class Log(
    private val ln: NatLog = Ln
): NLog {
    override fun calculate(x: Double, base: Double, eps: Double): Double {
        require(base != 1.0) { "так нельзя" }
        return ln.calculate(x, eps) / ln.calculate(base, eps)
    }
}