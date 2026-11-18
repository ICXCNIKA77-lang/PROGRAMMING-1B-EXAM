import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ProductCalculationsTest {
    @Test
    void GetVat_WithValidData_ReturnsCorrectValue() {
        IProductCalculations calc = new ProductCalculations(3500);
        assertEquals(525.0, calc.GetVat(), 0.001);
    }
}