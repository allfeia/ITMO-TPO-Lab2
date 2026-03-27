import org.example.System
import org.example.log.LogSystem
import org.example.log.Ln
import org.example.log.Log
import org.example.trig.TrigSystem
import org.mockito.kotlin.mock
import org.mockito.kotlin.whenever
import org.mockito.kotlin.any
import kotlin.math.*
import kotlin.test.Test
import kotlin.test.assertEquals

class SystemIntegrationTest {

    @Test
    fun `real logs with mocked trig`() {
        val trigMock = mock<TrigSystem>()
        whenever(trigMock.calculate(any(), any())).thenReturn(999.0)

        val logSystem = LogSystem(Ln, Log(Ln))
        val system = System(logSystem, trigMock)

        val x = 2.0
        val result = system.calculate(x)

        val lnVal = ln(x)
        val log10Val = log10(x)
        val log5Val = ln(x) / ln(5.0)

        val expected = (((log10Val.pow(3.0) * log5Val) / lnVal).pow(3.0)) / log10Val + lnVal + log10Val

        assertEquals(expected, result, 1e-3)
    }

    @Test
    fun `real trig with mocked log`() {
        val trigSystem = TrigSystem()
        val logMock = mock<LogSystem>()
        whenever(logMock.calculate(any(), any())).thenReturn(123.0)

        val system = System(logMock, trigSystem)

        val x = -1.0
        val result = system.calculate(x)

        val sinVal = sin(x)
        val cosVal = cos(x)
        val tgVal = tan(x)
        val secVal = 1 / cosVal

        val expected = ((secVal.pow(2) + sinVal).pow(2)) - tgVal - cosVal.pow(3)

        assertEquals(expected, result, 1e-3)
    }
}