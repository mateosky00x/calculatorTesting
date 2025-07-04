import com.epam.tat.module4.Calculator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import java.util.stream.Stream;
import static org.junit.jupiter.api.Assertions.assertEquals;

//Here I'm using Parameterized test and CsvSource

@DisplayName("Calculator addition tests")
public class AdditionTest {

    private Calculator calculator;

    @BeforeEach
    public void setUp() {
        calculator = new Calculator();
    }

    // Parameterized test with MethodSource
    @ParameterizedTest(name = "{0} + {1} = {2}")  // Test name pattern
    @MethodSource("additionTestData")
    public void testAdditionWithParameters(long a, long b, long expected) {
        assertEquals(expected, calculator.sum(a, b),
                () -> String.format("%d + %d should equal %d", a, b, expected));
    }

    // Data provider method
    private static Stream<Arguments> additionTestData() {
        return Stream.of(
                // Format: Arguments.of(a, b, expectedResult)
                Arguments.of(2, 3, 5),       // Addition of positive number
                Arguments.of(0, 5, 5),       // Zero + positive numbers
                Arguments.of(-2, -3, -5),    // Addition of Negative numbers
                Arguments.of(0, 0, 0),       // Zero + zero
                Arguments.of(Long.MAX_VALUE, 1, Long.MIN_VALUE)  // Overflow case
        );
    }

    // Alternative: CSV source (simpler for basic cases)
    @ParameterizedTest
    @CsvSource({
            "2, 3, 5",
            "0, 5, 5",
            "-2, -3, -5"
    })
    public void testAdditionWithCsv(long a, long b, long expected) {
        assertEquals(expected, calculator.sum(a, b));
    }
}