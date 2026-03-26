package org.example.trig.baseFunctions

abstract class ReducibleTrigFunction: TrigFunction {
    private fun reduce(x: Double): Double {
        var reduced = x % (2 * Math.PI)
        if (reduced > Math.PI) reduced -= 2 * Math.PI
        if (reduced < -Math.PI) reduced += 2 * Math.PI
        return reduced
    }
    abstract fun calculateReduced(x: Double, eps: Double): Double

    override fun calculate(x: Double, eps: Double): Double {
        return calculateReduced(reduce(x), eps)
    }

}