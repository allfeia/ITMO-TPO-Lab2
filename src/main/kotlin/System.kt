package org.example

import org.example.log.LogSystem
import org.example.trig.TrigSystem

class System {
    companion object {
        fun calculate(x: Double, eps: Double = 1e-6): Double {
            return if (x > 0) LogSystem.calculate(x, eps) else TrigSystem().calculate(x, eps)
        }
    }
}