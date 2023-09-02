import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Ingredient;
import praktikum.IngredientType;
@RunWith(Parameterized.class)

public class IngredientTest {

    private final IngredientType type;
    private final String name;

    private final float price;

    private final IngredientType expectedType;

    private final String expectedName;

    private final float expectedPrice;


    public IngredientTest(IngredientType type, String name, float price, IngredientType expectedType, String expectedName, float expectedPrice){
        this.type = type;
        this.name = name;
        this.price = price;
        this.expectedType = expectedType;
        this.expectedName = expectedName;
        this.expectedPrice = expectedPrice;
    }
    @Parameterized.Parameters
    public static Object[][] getData() {
        return new Object[][] {
                {IngredientType.SAUCE, "hot sauce", 100, IngredientType.SAUCE, "hot sauce", 100},
                {IngredientType.SAUCE, "sour cream", 200, IngredientType.SAUCE, "sour cream", 200},
                {IngredientType.SAUCE, "chili sauce", 300, IngredientType.SAUCE, "chili sauce", 300},
                {IngredientType.FILLING, "cutlet", 100, IngredientType.FILLING, "cutlet", 100},
                {IngredientType.FILLING, "dinosaur", 200, IngredientType.FILLING, "dinosaur", 200},
                {IngredientType.FILLING, "sausage", 300, IngredientType.FILLING, "sausage", 300}
        };
    }

    @Test
    public void checkGetType(){
        Ingredient ingredient = new Ingredient(type, name, price);
        IngredientType actualType = ingredient.getType();
        Assert.assertEquals(expectedType, actualType);
    }

    @Test
    public void checkGetPrice(){
        Ingredient ingredient = new Ingredient(type, name, price );
        float actualPrice = ingredient.getPrice();
        Assert.assertEquals(expectedPrice, actualPrice,0.0);
    }

    @Test
    public void checkGetName(){
        Ingredient ingredient = new Ingredient(type, name, price );
        String actualName = ingredient.getName();
        Assert.assertEquals(expectedName, actualName);
    }
}
