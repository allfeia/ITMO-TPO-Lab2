package org.example.trig.baseFunctions.trig

import org.example.trig.baseFunctions.Tg
import kotlin.math.PI
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFailsWith
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvFileSource

class TgTest {

    private val eps = 1e-6

    @Test
    fun shouldCalculateBasicValues() {
        assertEquals(0.0, Tg().calculate(0.0, eps), eps)
        assertEquals(0.0, Tg().calculate(-PI, eps), eps)
        assertEquals(0.0, Tg().calculate(PI, eps), eps)
    }

    @Test
    fun shouldThrowAtPiHalf() {
        assertFailsWith<ArithmeticException> {
            Tg().calculate(PI / 2, eps)
        }
    }

    @ParameterizedTest(name = "tg({0})")
    @CsvFileSource(resources = ["/tg.csv"], numLinesToSkip = 1)
    fun testTan(x: Double, result: Double) {
        assertEquals(result, Tg().calculate(x, eps), eps)
    }
}