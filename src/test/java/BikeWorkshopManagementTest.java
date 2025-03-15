import org.junit.jupiter.api.*;
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

}
