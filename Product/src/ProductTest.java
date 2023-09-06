import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class ProductTest {
    private Product product;

    @Before
    public void setUp() {
        product = new Product("Pipeweed", "Long Bottom Leaf", "000005", 600.0);
    }

    @Test
    public void testConstructor() {
        assertEquals("000005", product.getIDNum());
        assertEquals("Pipeweed", product.getName());
        assertEquals("Long Bottom Leaf", product.getDescription());
        assertEquals(600.0, product.getCost(), 0.001); // Using delta for double comparison
    }

    @Test
    public void testSetIDNum() {
        product.setIDNum("000007");
        assertEquals("000007", product.getIDNum());
    }

    @Test
    public void testSetName() {
        product.setName("Armor");
        assertEquals("Armor", product.getName());
    }

    @Test
    public void testSetDescription() {
        product.setDescription("Elven");
        assertEquals("Elven", product.getDescription());
    }

    @Test
    public void testSetCost() {
        product.setCost(700.0);
        assertEquals(700.0, product.getCost(), 0.001); // Using delta for double comparison
    }
}
