import com.example.Animal;
import com.example.Feline;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;
@RunWith(MockitoJUnitRunner.class)
public class FelineTest {
    @Spy
    private Feline felineSpy;

    @Test
    public void eatMeatTest() throws Exception {
        Feline feline = new Feline();
        Animal animal = new Animal();
        assertEquals(feline.eatMeat(), animal.getFood("Хищник"));
    }

    @Test
    public void getFamilyTest() {
        Feline feline = new Feline();
        assertEquals("Кошачьи", feline.getFamily());
    }

    @Test
    public void getKittensTest() {
        felineSpy.getKittens();
        Mockito.verify(felineSpy, Mockito.times(1)).getKittens(1);
    }

    @Test
    public void getKittensWithParameterTest() {
        Feline feline = new Feline();
        assertEquals(1, feline.getKittens(1));
    }
}
