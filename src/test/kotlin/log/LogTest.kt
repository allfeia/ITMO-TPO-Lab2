import org.example.log.Log
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvFileSource
import org.junit.jupiter.params.provider.ValueSource
import org.junit.jupiter.api.Assertions.assertThrows
import org.junit.jupiter.api.assertAll
import kotlin.test.assertEquals

@DisplayName("тест разных логарифмов")
class LogTest {
    private val eps = 1e-4

    @ParameterizedTest(name = "log{1}({0}) = {2}")
    @CsvFileSource(
        resources = ["/log.csv"],
        numLinesToSkip = 1,
        delimiter = ';'
    )
    fun testTable(x: Double, base: Double, expected: Double) {
        assertEquals(expected, Log.calculate(x, base, eps), eps)
    }

    @ParameterizedTest
    @ValueSource(doubles = [-1488.0, -10.0, -1.0, -0.01])
    fun testInvalid(x: Double) {
        assertAll(
            {assertThrows(IllegalArgumentException::class.java) {
                Log.calculate(x, 2.0, 1e-6)
            }}, // аргумент вне ОДЗ
            {assertThrows(IllegalArgumentException::class.java) {
                Log.calculate(-x, 1.0, 1e-6)
            }}, // основание вне ОДЗ
            {assertThrows(IllegalArgumentException::class.java) {
                Log.calculate(-x, x, 1e-6)
            }} // основание вне ОДЗ
        )
    }
}