import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import com.epam.tat.module4.Calculator;

@DisplayName("Calculator Multiplication Tests")
@Tag("arithmetic")
public class MultiplicationTest {  // Class name matches filename MultiplicationTest.java

    private Calculator calculator;

    @BeforeEach
    public void setUp() {
        calculator = new Calculator();
    }

    @Test
    @DisplayName("Multiplication of two positive numbers")
    public void testMultiplyPositiveNumbers() {
        assertEquals(50, calculator.mult(10, 5), "10 * 5 should equal 50");
    }

    @Test
    @DisplayName("Multiplication by zero")
    public void testMultiplyByZero() {
        assertEquals(0, calculator.mult(10, 0), "10 * 0 should equal 0");
    }

    @Test
    @DisplayName("Multiplication of negative numbers")
    public void testMultiplyNegativeNumbers() {
        assertEquals(50, calculator.mult(-10, -5), "-10 * -5 should equal 50");
    }

    @Test
    @DisplayName("Multiplication by one (identity property)")
    public void testMultiplyByIdentity() {
        assertEquals(7, calculator.mult(7, 1), "7 * 1 should equal 7");
    }

    @Test
    @DisplayName("Multiplication with maximum long value")
    public void testMultiplyWithMaxValue() {
        assertEquals(Long.MAX_VALUE, calculator.mult(Long.MAX_VALUE, 1));
    }
}