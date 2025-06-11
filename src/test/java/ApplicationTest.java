import org.junit.jupiter.api.*;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.assumeTrue;

public class ApplicationTest {


    @BeforeAll
    public static void setUp() {

    }

    @BeforeEach
    public void init() {

    }

    @DisplayName("Success Test")
    @Test
    public void successTest() {

    }

    @Test
    @Disabled("Disable to run latter")
    public void disabledTest() {

    }

    @AfterEach
    public void doneEach() {

    }

    @Test
    void failingTest() {
        fail("a failing test");
    }

    @Test
    void abortedTest() {
        assumeTrue("abc".contains("Z"));
        fail("test should have been aborted");
    }

    @AfterAll
    static void done() {
        System.out.println("-------------------Finished all the tests-------------------");
    }

    @Test
    public void assertLambda() {
        List<Integer> numbers = Arrays.asList(1, 2, 3);

        assertTrue(numbers.stream()
            .mapToInt(Integer::intValue)
            .sum() > 5, () -> "Sum should be greater than 5");
    }

    @Test
    void groupAssertions() {
        int[] numbers = {0, 1, 2, 3, 4};

        assertAll("numbers",
                () -> assertEquals(0, numbers[0]),
                () -> assertEquals(1, numbers[1]),
                () -> assertEquals(2, numbers[2])
        );
    }

    @Test
    void groupedAssertions() {
        Person person = new Person("Fabio", "Fucks");
        assertAll("person",
                () -> assertEquals("Fabio", person.getFirstName()),
                () -> assertEquals("Fucks", person.getLastName())
        );
    }

    @Test
    @DisplayName("😱")
    void testWithDisplayNameContainingEmoji() {
    }

    @Test
    void dependentAssertions() {
        Person person = new Person("Fabio", "Fucks");
        assertAll("properties",
            () -> {
                String firstName = person.getFirstName();
                assertNotNull(firstName);

                // Executed only if the previous assertion is valid.
                assertAll("first name",
                        () -> assertTrue(firstName.startsWith("F")),
                        () -> assertTrue(firstName.endsWith("o"))
                );
            },
            () -> {
                // Grouped assertion, so processed independently
                // of results of first name assertions.
                String lastName = person.getLastName();
                assertNotNull(lastName);

                // Executed only if the previous assertion is valid.
                assertAll("last name",
                        () -> assertTrue(lastName.startsWith("F")),
                        () -> assertTrue(lastName.endsWith("s"))
                );
            }
        );
    }

    @Test
    void exceptionTesting() {
        Calculator calculator = new Calculator();
        Exception exception = assertThrows(ArithmeticException.class, () ->
                calculator.divide(0, 1));
        assertEquals("No number can be divided by zero", exception.getMessage());
    }


}
