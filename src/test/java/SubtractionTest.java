import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import com.epam.tat.module4.Calculator;

@DisplayName("Calculator Subtraction Tests")
@Tag("arithmetic")
public class SubtractionTest {

    private Calculator calculator;

    @BeforeEach
    public void setUp() {
        calculator = new Calculator();
    }

    @Test
    @DisplayName("Positive number minus positive number")
    public void testPositiveMinusPositive() {
        assertEquals(3, calculator.sub(7, 4), "7 - 4 should equal 3");
    }

    @Test
    @DisplayName("Positive number minus zero")
    public void testPositiveMinusZero() {
        assertEquals(5, calculator.sub(5, 0), "5 - 0 should equal 5");
    }

    @Test
    @DisplayName("Zero minus positive number")
    public void testZeroMinusPositive() {
        assertEquals(-3, calculator.sub(0, 3), "0 - 3 should equal -3");
    }

    @Test
    @DisplayName("Negative number minus negative number")
    public void testNegativeMinusNegative() {
        assertEquals(-2, calculator.sub(-5, -3), "-5 - (-3) should equal -2");
    }

    @Test
    @DisplayName("Subtraction with maximum long value")
    public void testSubtractWithMaxValue() {
        assertEquals(Long.MAX_VALUE - 5, calculator.sub(Long.MAX_VALUE, 5));
    }

    @Test
    @DisplayName("Subtraction with minimum long value")
    public void testSubtractWithMinValue() {
        assertEquals(Long.MIN_VALUE + 5, calculator.sub(Long.MIN_VALUE, -5));
    }
}