package org.example.trig.baseFunctions.trig

import org.example.trig.baseFunctions.Sec
import kotlin.math.PI
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFailsWith
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvFileSource

class SecTest {

    private val eps = 1e-6

    @Test
    fun shouldCalculateBasicValues() {
        assertEquals(1.0, Sec().calculate(-2 * PI, eps), eps)
        assertEquals(-1.0, Sec().calculate(-PI, eps), eps)
        assertEquals(1.0, Sec().calculate(0.0, eps), eps)
        assertEquals(-1.0, Sec().calculate(PI, eps), eps)
        assertEquals(1.0, Sec().calculate(2 * PI, eps), eps)
    }

    @Test
    fun shouldThrowAtPiHalf() {
        assertFailsWith<ArithmeticException> {
            Sec().calculate(PI / 2, eps)
        }
    }

    @ParameterizedTest(name = "sec({0})")
    @CsvFileSource(resources = ["/sec.csv"], numLinesToSkip = 1)
    fun testSec(x: Double, result: Double) {
        assertEquals(result, Sec().calculate(x, eps), eps)
    }
}