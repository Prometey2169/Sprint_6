import com.example.Animal;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.assertEquals;

public class AnimalTest {
    @Rule
    public ExpectedException expectedEx = ExpectedException.none();

    @Test
    public void getFamilyIsCorrectTest() {
        String expectedString = "Существует несколько семейств: заячьи, беличьи, мышиные, кошачьи, псовые, медвежьи, куньи";
        String actualString = new Animal().getFamily();

        assertEquals("Некорректный перечень семейств", expectedString, actualString);
    }

    @Test
    public void getFoodThrowsExceptionTest() throws Exception {
        expectedEx.expect(Exception.class);
        expectedEx.expectMessage("Неизвестный вид животного, используйте значение Травоядное или Хищник");

        new Animal().getFood("");
    }
}
