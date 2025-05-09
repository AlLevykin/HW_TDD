import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class PhoneBookTest {

    static PhoneBook phoneBook;

    @BeforeAll
    public static void init() {
        phoneBook = new PhoneBook();
    }

    @Nested
    class TestAdd {
        @ParameterizedTest
        @CsvSource({
                "Мария, 70951112233, 1",
                "Мария, 79221112233, 1",
                "Петр, 73511112233, 2"
        })
        public void testAdd(String name, Long number, Integer recordCount) {
            // Act
            Integer result = phoneBook.add(name, number);
            // Assert
            Assertions.assertEquals(recordCount, result);
        }
    }

}
