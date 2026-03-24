package org.example

import org.example.trig.CsvWriter
import org.example.trig.TrigSystem

fun main() {
    CsvWriter.write(
        filename = "trig.csv",
        start = -5.0,
        end = 0.0,
        step = 0.1,
        func = { x -> TrigSystem.calculate(x) }
    )

}