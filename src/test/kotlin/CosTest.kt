package org.example.trig.baseFunctions

import kotlin.math.PI
import kotlin.test.Test
import kotlin.test.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvFileSource

class CosTest {

    private val eps = 1e-6

    @Test
    fun shouldCalculateForZero() {
        assertEquals(1.0, Cos().calculate(0.0, eps), eps)
    }

    @Test
    fun shouldCalculateForPiHalf() {
        assertEquals(0.0, Cos().calculate(PI / 2, eps), eps)
        assertEquals(0.0, Cos().calculate(-PI / 2, eps), eps)
        assertEquals(0.0, Cos().calculate(3 * PI / 2, eps), eps)
        assertEquals(0.0, Cos().calculate(-3 * PI / 2, eps), eps)
    }

    @Test
    fun shouldCalculateForPi() {
        assertEquals(-1.0, Cos().calculate(PI, eps), eps)
        assertEquals(-1.0, Cos().calculate(-PI, eps), eps)
    }

    @ParameterizedTest(name = "cos({0})")
    @CsvFileSource(resources = ["/cos.csv"], numLinesToSkip = 1)
    fun testCos(x: Double, result: Double) {
        assertEquals(result, Cos().calculate(x, eps), eps)
    }
}