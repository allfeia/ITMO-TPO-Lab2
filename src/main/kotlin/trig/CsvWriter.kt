package org.example.trig

import java.io.File

object CsvWriter {
    fun write(
        filename: String,
        start: Double,
        end: Double,
        step: Double,
        eps: Double = 1e-6,
        func: (Double, Double) -> Double
    ) {
        File(filename).bufferedWriter().use { writer ->
            writer.write("x,result\n")
            var x = start
            while (x <= end + step/2) {
                try {
                    val result = func(x, eps)
                    writer.write("$x,$result\n")
                } catch (e: ArithmeticException) {
                    writer.write("$x,NaN\n")
                }
                x += step
            }
        }
    }
}