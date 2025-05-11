import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class PhoneBookTest {

    static PhoneBook phoneBook;

    @Nested
    class TestAdd {
        @BeforeAll
        public static void init() {
            phoneBook = new PhoneBook();
        }

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

        @ParameterizedTest
        @CsvSource({
                "-, 70951112233",
                "Петр, -1112233"
        })
        public void testAddError(String name, Long number) {
            // Act & Assert
            Assertions.assertThrows(IllegalArgumentException.class, () -> phoneBook.add(name, number));
        }
    }

    @Nested
    class TestFind {
        @BeforeAll
        public static void init() {
            phoneBook = new PhoneBook();
            phoneBook.add("Мария", 70951112233L);
            phoneBook.add("Петр", 73511112233L);
        }

        @Test
        public void testFindByNumber() throws ClassNotFoundException {
            // Arrange
            Long number = 73511112233L;
            String expected = "Петр";
            // Act
            String result = phoneBook.findByNumber(number);
            // Assert
            Assertions.assertEquals(expected, result);
        }

        @Test
        public void testFindByNumberNotFound() {
            // Arrange
            Long number = 79111111111L;
            // Act & Assert
            Assertions.assertThrows(ClassNotFoundException.class, () -> phoneBook.findByNumber(number));
        }

        @Test
        public void testFindByName() throws ClassNotFoundException {
            // Arrange
            String name = "Петр";
            Long expected = 73511112233L;
            // Act
            Long result = phoneBook.findByName(name);
            // Assert
            Assertions.assertEquals(expected, result);
        }

        @Test
        public void testFindByNameNotFound() {
            // Arrange
            String name = "Иван";
            // Act & Assert
            Assertions.assertThrows(ClassNotFoundException.class, () -> phoneBook.findByName(name));
        }
    }

    @Nested
    class TestPrintAllNames {
        @BeforeAll
        public static void init() {
            phoneBook = new PhoneBook();
            phoneBook.add("Яна", 70951112233L);
            phoneBook.add("Аня", 73511112233L);
            phoneBook.add("Петр", 79221112233L);
            phoneBook.add("Борис", 79631112233L);
        }

        @Test
        public void testPrintAllNames() {
            // Arrange
            String expected = "Аня, Борис, Петр, Яна, ";
            // Act
            String result = phoneBook.printAllNames();
            // Assert
            Assertions.assertEquals(expected, result);
        }
    }
}
