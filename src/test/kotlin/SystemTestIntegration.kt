import org.example.System
import org.example.trig.TrigSystem
import org.mockito.Mockito.mock
import org.mockito.kotlin.whenever
import kotlin.math.pow
import kotlin.test.Test
import kotlin.test.assertEquals
import org.mockito.kotlin.any

class SystemTestIntegration {
    @Test
    fun `test log system with mocked trig`() {
        val trig = mock<TrigSystem>()

        whenever(trig.calculate(any(), any())).thenReturn(999.0)

        val system = System()

        val x = 2.0
        val result = system.calculate(x)

        val ln = kotlin.math.ln(x)
        val log10 = kotlin.math.log10(x)
        val log5 = kotlin.math.log(x, 5.0)
        val log2 = kotlin.math.log(x, 2.0)

        val expected = (((log10.pow(3) * log5) / ln).pow(3)) / log10 + ln + log10

        assertEquals(expected, result, 1e-6)
    }

}