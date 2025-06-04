import org.junit.jupiter.api.*;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

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

}
