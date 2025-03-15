import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;
import org.junit.jupiter.api.Test;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class BikeWorkshopManagementTest {

    @BeforeAll
    static void beforeAllTests() {
        System.out.println("Starting all tests.");
    }

    @AfterAll
    static void afterAllTests() {
        System.out.println("All tests completed.");
    }

    @BeforeEach
    void setUp() {
        Cart.getCart().clear();
        Cart.setTotalCost(0);
    }

    @AfterEach
    void tearDown() {
        System.out.println("Test completed.");
    }

    @Test
    void testAddToCart() {
        Cart.getCart().add("Brake Pads");
        Cart.setTotalCost(880.0);
        assertNotNull(Cart.getCart());
        assertFalse(Cart.getCart().isEmpty());
        assertEquals(880.0, Cart.getTotalCost());
        assertNotEquals(0, Cart.getTotalCost());
    }

    @Test
    void testClearCart() {
        Cart.getCart().add("Tires");
        Cart.setTotalCost(3550.0);
        Cart.getCart().clear();
        Cart.setTotalCost(0);
        assertTrue(Cart.getCart().isEmpty());
        assertEquals(0, Cart.getTotalCost());
    }

    @Test
    void testApplyDiscount() {
        Cart.getCart().add("Master Service");
        Cart.setTotalCost(3500.0);
        double discount = Cart.getTotalCost() * 0.1;
        double discountedTotal = Cart.getTotalCost() - discount;
        assertEquals(3150.0, discountedTotal);
        assertNotSame(3500.0, discountedTotal);
    }

    @Test
    void testCheckout() {
        Cart.getCart().add("Wheel Alignment");
        Cart.setTotalCost(250.0);
        assertDoesNotThrow(() -> {
            Cart.getCart().clear();
            Cart.setTotalCost(0);
        });
        assertTrue(Cart.getCart().isEmpty());
        assertEquals(0, Cart.getTotalCost());
    }

    @Test
    void testInvalidDiscount() {
        assertThrows(NumberFormatException.class, () -> {
            Double.parseDouble("Invalid");
        });
    }

    @Test
    void testCartNotNull() {
        assertNotNull(Cart.getCart());
    }

    @Test
    void testSameCartInstance() {
        assertSame(Cart.getCart(), Cart.getCart());
    }

    @Test
    void testCartArray() {
        Cart.getCart().add("Brake Pads");
        Cart.getCart().add("Oil Change");

        String[] expectedCart = {"Brake Pads", "Oil Change"};
        assertArrayEquals(expectedCart, Cart.getCart().toArray());
    }


    @Test
    void testCartLinesMatch() {
        Cart.getCart().add("Brake Pads");
        String expectedLine = "Brake Pads";
        assertLinesMatch(Cart.getCart(), java.util.List.of(expectedLine));
    }

    @Test
    void testCartTimeout() {
        assertTimeout(java.time.Duration.ofMillis(100), () -> {
            Cart.getCart().add("Oil Change");
        });
    }

    @Test
    void testFailCondition() {
        if (Cart.getTotalCost() < 0) {
            fail("Total cost cannot be negative");
        }
    }

    @ParameterizedTest
    @ValueSource(strings = {"Brake Pads", "Tires", "Chain", "Lubricant"})
    void testAddToCartWithValueSource(String part) {
        Cart.getCart().clear();
        Cart.getCart().add(part);
        assertTrue(Cart.getCart().contains(part));
    }

    @ParameterizedTest
    @CsvSource({
            "Brake Pads, 880.0",
            "Tires, 3550.0",
            "Chain, 4850.0",
            "Lubricant, 1890.0"
    })
    void testAddToCartWithPrice(String part, double price) {
        Cart.getCart().clear();
        Cart.getCart().add(part);
        Cart.setTotalCost(price);
        assertEquals(price, Cart.getTotalCost());
        assertTrue(Cart.getCart().contains(part));
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/info.csv", numLinesToSkip = 0)
    void testAddToCartWithCsvFile(String part, double price) {
        Cart.getCart().clear();
        Cart.getCart().add(part);
        Cart.setTotalCost(price);
        assertEquals(price, Cart.getTotalCost());
    }

    static Stream<Arguments> providePartsAndPrices() {
        return Stream.of(
                Arguments.of("Brake Pads", 880.0),
                Arguments.of("Tires", 3550.0),
                Arguments.of("Chain", 4850.0),
                Arguments.of("Lubricant", 1890.0)
        );
    }

    @ParameterizedTest
    @MethodSource("providePartsAndPrices")
    void testAddToCartWithMethodSource(String part, double price) {
        Cart.getCart().clear();
        Cart.getCart().add(part);
        Cart.setTotalCost(price);
        assertEquals(price, Cart.getTotalCost());
    }
}


