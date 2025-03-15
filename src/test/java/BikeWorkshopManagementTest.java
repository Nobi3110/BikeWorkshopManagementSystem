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

}
