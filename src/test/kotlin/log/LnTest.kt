import org.example.log.Ln
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvFileSource
import org.junit.jupiter.params.provider.ValueSource
import org.junit.jupiter.api.Assertions.assertThrows
import kotlin.test.assertEquals

@DisplayName("тест НАТУРАЛЬНОГО логарифма (не гейского)")
class LnTest {
    private val eps = 1e-4

    @ParameterizedTest(name = "ln({0}) = {1}")
    @CsvFileSource(
        resources = ["/ln.csv"],
        numLinesToSkip = 1,
        delimiter = ';'
    )
    fun testTable(x: Double, expected: Double) {
        assertEquals(expected, Ln.calculate(x, eps), eps)
    }

    @ParameterizedTest
    @ValueSource(doubles = [-1488.0, -10.0, -1.0, -0.01])
    fun testInvalid(x: Double) {
        assertThrows(IllegalArgumentException::class.java) {
            Ln.calculate(x, 1e-6)
        }
    }
}