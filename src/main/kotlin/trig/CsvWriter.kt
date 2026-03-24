package org.example.trig

import java.io.File

object CsvWriter {
    fun write(
        filename: String,
        start: Double,
        end: Double,
        step: Double,
        func: (Double) -> Double
    ) {
        File(filename).bufferedWriter().use { writer ->
            writer.write("x,result\n")
            var x = start
            while (x <= end) {
                writer.write("$x,${func(x)}\n")
                x += step
            }
        }
    }
}