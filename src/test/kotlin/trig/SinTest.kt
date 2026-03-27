package org.example.trig.baseFunctions.trig

import org.example.trig.baseFunctions.Sin
import kotlin.math.PI
import kotlin.test.Test
import kotlin.test.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvFileSource

class SinTest {

    private val eps = 1e-6

    @Test
    fun shouldCalculateForZero() {
        assertEquals(0.0, Sin.calculate(0.0, eps), eps)
    }

    @Test
    fun shouldCalculateForPiHalf() {
        assertEquals(1.0, Sin.calculate(PI / 2, eps), eps)
        assertEquals(-1.0, Sin.calculate(-PI / 2, eps), eps)
        assertEquals(-1.0, Sin.calculate(3 * PI / 2, eps), eps)
        assertEquals(1.0, Sin.calculate(-3 * PI / 2, eps), eps)
    }

    @Test
    fun shouldCalculateForPi() {
        assertEquals(0.0, Sin.calculate(PI, eps), eps)
        assertEquals(0.0, Sin.calculate(-PI, eps), eps)
    }

    @ParameterizedTest(name = "sin({0})")
    @CsvFileSource(resources = ["/sin.csv"], numLinesToSkip = 1)
    fun testSin(x: Double, result: Double) {
        assertEquals(result, Sin.calculate(x, eps), eps)
    }
}