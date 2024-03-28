import com.example.Animal;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.List;

import static org.junit.Assert.assertEquals;
@RunWith(Parameterized.class)
public class AnimalGetFoodParametrizedTest {
    private Animal animal;
    private static final String ANIMAL_HERBIVORE = "Травоядное";
    private static final String ANIMAL_PREDATOR = "Хищник";
    private static final List<String> HERBIVORE_FOOD = List.of("Трава", "Различные растения");
    private static final List<String> PREDATOR_FOOD = List.of("Животные", "Птицы", "Рыба");

    private final String animalKind;
    private final List<String> foods;

    public AnimalGetFoodParametrizedTest(String animalKind, List<String> foods) {
        this.animalKind = animalKind;
        this.foods = foods;
    }

    @Parameterized.Parameters
    public static Object[][] getParameters() {
        return new Object[][]{
                {ANIMAL_HERBIVORE, HERBIVORE_FOOD},
                {ANIMAL_PREDATOR, PREDATOR_FOOD}
        };
    }

    @Before
    public void setUp() {
        animal = new Animal();
    }

    @Test
    public void testGetFood() throws Exception {
        List<String> actual = animal.getFood(animalKind);
        assertEquals("Список еды для животных не совпадает с ожидаемым",
                foods, actual);
    }
}
