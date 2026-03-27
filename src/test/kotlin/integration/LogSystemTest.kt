package integration

import org.junit.jupiter.api.Test
import org.mockito.kotlin.*
import kotlin.test.assertEquals
import kotlin.math.pow

import org.example.log.*

class LogSystemTest {
    @Test
    fun `all mocked`() {
        val ln = mock<NatLog>()
        val log = mock<NLog>()
        val x = 3.0

        whenever(ln.calculate(eq(3.0), any())).thenReturn(1.0)
        whenever(log.calculate(eq(3.0), eq(5.0), any())).thenReturn(2.0)
        whenever(log.calculate(eq(3.0), eq(10.0), any())).thenReturn(3.0)

        val expected = (((3.0.pow(3.0) * 2.0) / 1.0).pow(3.0)) / 3.0 + 1.0 + 3.0

        assertEquals(expected, LogSystem(ln, log).calculate(x), 1e-3)
    }

    @Test
    fun `ln no mock`() {
        val ln = Ln
        val log = mock<NLog>()
        val x = 0.2
        val lnx = Ln.calculate(0.2, 1e-3)

        whenever(log.calculate(eq(0.2), eq(5.0), any())).thenReturn(2.0)
        whenever(log.calculate(eq(0.2), eq(10.0), any())).thenReturn(3.0)

        val expected = (((3.0.pow(3.0) * 2.0) / lnx).pow(3.0)) / 3.0 + lnx + 3.0

        assertEquals(expected, LogSystem(ln, log).calculate(x), 1e-1)
    }
}