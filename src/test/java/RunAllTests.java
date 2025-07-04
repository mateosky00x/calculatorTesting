import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;
import org.junit.platform.suite.api.SuiteDisplayName;
import static org.junit.jupiter.api.Assertions.*;
import com.epam.tat.module4.Calculator;

@Suite
@SuiteDisplayName("Master Calculator Test Suite")
@SelectClasses({
        AdditionTest.class,
        SubtractionTest.class,
        MultiplicationTest.class,
        DivisionTest.class
})
public class RunAllTests {

    private static Calculator calculator;
    private static long startTime;

    @BeforeAll
    public static void setUpClass() {
        startTime = System.currentTimeMillis();
        calculator = new Calculator();
        System.out.println("=== Starting Test Suite ===");
    }

    @AfterAll
    public static void tearDownClass() {
        long duration = System.currentTimeMillis() - startTime;
        System.out.println("=== Test Suite Completed ===");
        System.out.println("Total duration: " + duration + "ms");
    }

    @BeforeEach
    public void setUp() {
        calculator = new Calculator();
    }

    @AfterEach
    public void tearDown() {
        // Verify calculator remains stable after each test
        assertDoesNotThrow(() -> calculator.sum(0, 0));
    }

    @Test
    public void testAllOperations() {
        assertAll("Verify all calculator operations",
                () -> assertEquals(5, calculator.sum(2, 3)),
                () -> assertEquals(1, calculator.sub(3, 2)),
                () -> assertEquals(6, calculator.mult(2, 3)),
                () -> assertEquals(2.0, calculator.div(6, 3), 0.001)
        );
    }

    public void testErrorConditions() {
        assertAll("Verify error handling",
                () -> assertThrows(NumberFormatException.class,
                        () -> calculator.div(1, 0))
        );
    }
}