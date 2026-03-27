package org.example.log

import kotlin.math.abs

class Ln {
    companion object: NatLog {
        private const val LN2 = 0.6931471805599453

        override fun calculate(x: Double, eps: Double): Double {
            require(x > 0) { "эй ле лнчик то только для x > 0" }

            val t = (x - 1) / (x + 1)
            var term = t
            var sum = 0.0
            var n = 1

            while (abs(term) > eps * eps) {
                sum += term
                term *= n * t * t / (n + 2)
                n += 2
            }

            return 2 * sum
        }
    }
}