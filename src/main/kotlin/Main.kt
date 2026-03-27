package org.example

import org.example.trig.baseFunctions.Sec

fun main() {
//    CsvWriter.write(
//        filename = "sin.csv",
//        start = -5.0,
//        end = 0.0,
//        step = 0.1,
//        eps = 1e-6,
//        func = { x, eps -> Sin.calculate(x, eps) }
//    )
//
//    val sinStub = Stub("sin.csv")
//    val result = sinStub.calculate(-0.10000000000000103)
    println(Sec().calculate(1.91, 1e-6))

}