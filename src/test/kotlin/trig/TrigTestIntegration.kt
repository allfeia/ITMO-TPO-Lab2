package trig

import org.example.trig.TrigSystem
import org.example.trig.baseFunctions.*
import org.mockito.Mockito.mock
import org.mockito.kotlin.whenever
import org.mockito.kotlin.any
import kotlin.math.pow
import kotlin.math.sin
import kotlin.math.cos
import kotlin.math.tan
import kotlin.test.Test
import kotlin.test.assertEquals

class TrigTestIntegration {

    @Test
    fun `all mocked`() {
        val sin = mock<TrigFunction>()
        val cos = mock<TrigFunction>()
        val tg = mock<TrigFunction>()
        val sec = mock<TrigFunction>()

        whenever(sin.calculate(-1.0, 1e-6)).thenReturn(1.0)
        whenever(cos.calculate(-1.0, 1e-6)).thenReturn(2.0)
        whenever(tg.calculate(-1.0, 1e-6)).thenReturn(0.5)
        whenever(sec.calculate(-1.0, 1e-6)).thenReturn(0.25)

        val system = TrigSystem(sin, cos, tg, sec)

        val result = system.calculate(-1.0)

        val expected = ((0.25 * 0.25 + 1.0).pow(2)) - 0.5 - (2.0).pow(3)

        assertEquals(expected, result, 1e-6)
    }

    @Test
    fun `real sin`() {
        val sin = Sin
        val cos = mock<TrigFunction>()
        val tg = mock<TrigFunction>()
        val sec = mock<TrigFunction>()

        whenever(cos.calculate(any(), any())).thenReturn(1.0)
        whenever(tg.calculate(any(), any())).thenReturn(1.0)
        whenever(sec.calculate(any(), any())).thenReturn(1.0)

        val system = TrigSystem(sin, cos, tg, sec)

        val x = -1.0
        val result = system.calculate(x)

        val sinVal = sin(x)
        val expected = ((1.0.pow(2) + sinVal).pow(2)) - 1.0 - 1.0.pow(3)

        assertEquals(expected, result, 1e-6)
    }

    @Test
    fun `real tg`() {
        val sin = mock<TrigFunction>()
        val cos = mock<TrigFunction>()
        val tg = Tg()
        val sec = mock<TrigFunction>()

        whenever(cos.calculate(any(), any())).thenReturn(1.0)
        whenever(sin.calculate(any(), any())).thenReturn(1.0)
        whenever(sec.calculate(any(), any())).thenReturn(1.0)

        val system = TrigSystem(sin, cos, tg, sec)

        val x = -1.0
        val result = system.calculate(x)

        val tgVal = tan(x)
        val expected = ((1.0.pow(2) + 1.0).pow(2)) - tgVal - 1.0.pow(3)

        assertEquals(expected, result, 1e-6)
    }

    @Test
    fun `(sec(x)^2)+sin(x))^2)`() {
        val sin = Sin
        val cos = mock<TrigFunction>()
        val tg = mock<TrigFunction>()
        val sec = Sec()

        whenever(cos.calculate(any(), any())).thenReturn(1.0)
        whenever(tg.calculate(any(), any())).thenReturn(1.0)

        val system = TrigSystem(sin, cos, tg, sec)

        val x = -1.0
        val result = system.calculate(x)

        val sinVal = sin(x)
        val secVal = 1/cos(x)
        val expected = ((secVal.pow(2) + sinVal).pow(2)) - 1.0 - 1.0.pow(3)

        assertEquals(expected, result, 1e-3)
    }
}