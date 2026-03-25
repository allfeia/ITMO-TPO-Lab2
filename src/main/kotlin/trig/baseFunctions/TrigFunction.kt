package org.example.trig.baseFunctions

interface TrigFunction {
    fun calculate(x: Double, eps: Double = 1e-6): Double
}