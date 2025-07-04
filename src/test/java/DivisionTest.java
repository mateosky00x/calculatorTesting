import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import com.epam.tat.module4.Calculator;

@DisplayName("Calculator Division Tests")
@Tag("arithmetic")
public class DivisionTest {

    private Calculator calculator;

    @BeforeEach
    public void setUp() {
        calculator = new Calculator();
    }

    @Test
    @DisplayName("Division of two positive integers")
    public void testDividePositiveIntegers() {
        assertEquals(2.5, calculator.div(5, 2), 0.001, "5 / 2 should equal 2.5");
    }

    @Test
    @DisplayName("Division by one (identity property)")
    public void testDivideByOne() {
        assertEquals(10.0, calculator.div(10, 1), 0.001, "10 / 1 should equal 10");
    }

    @Test
    @DisplayName("Division by zero should throw exception")
    public void testDivideByZero() {
        assertThrows(NumberFormatException.class,
                () -> calculator.div(10, 0),
                "Division by zero should throw NumberFormatException");
    }

    @Test
    @DisplayName("Division of negative numbers")
    public void testDivideNegativeNumbers() {
        assertEquals(2.0, calculator.div(-10, -5), 0.001, "-10 / -5 should equal 2");
    }
}