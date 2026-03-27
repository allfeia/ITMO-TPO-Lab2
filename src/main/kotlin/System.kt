package org.example

import org.example.log.Ln
import org.example.log.Log
import org.example.log.LogSystem
import org.example.trig.TrigSystem

class System(
    private val logSys: LogSystem = LogSystem(Ln, Log(Ln)),
    private val trigSys: TrigSystem = TrigSystem()
) {
    fun calculate(x: Double, eps: Double = 1e-6): Double {
        return if (x > 0) logSys.calculate(x, eps) else trigSys.calculate(x, eps)
    }
}