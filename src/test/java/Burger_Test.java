import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;
import praktikum.IngredientType;

public class Burger_Test {

    @Rule
    public MockitoRule mockitoRule = MockitoJUnit.rule();
    @Mock
    Bun bun;
    @Mock
    Ingredient ingredient;

    @Test
    public void checkSetBuns() {
        Burger burger = new Burger();
        burger.setBuns(bun);
        Assert.assertEquals(burger.bun, bun);
    }

    @Test
    public void CheckAddIngredient() {
        Burger burger = new Burger();
        burger.addIngredient(ingredient);
        boolean isIncluded = burger.ingredients.stream().anyMatch(i -> i == ingredient);
        Assert.assertTrue(isIncluded);
    }

    @Test
    public void CheckRemoveIngredient() {
        Burger burger = new Burger();
        burger.addIngredient(ingredient);
        int realIndex = burger.ingredients.indexOf(ingredient);
        burger.removeIngredient(realIndex);
        boolean isNowIncluded = burger.ingredients.stream().anyMatch(i -> i == ingredient);
        Assert.assertFalse(isNowIncluded);
    }

    @Test
    public void CheckMoveIngredient() {
        Burger burger = new Burger();
        Ingredient ingredient1 = Mockito.mock(Ingredient.class);
        Ingredient ingredient2 = Mockito.mock(Ingredient.class);
        burger.addIngredient(ingredient1);
        burger.addIngredient(ingredient2);
        int realIndex1 = burger.ingredients.indexOf(ingredient1);
        int realIndex2 = burger.ingredients.indexOf(ingredient2);
        burger.moveIngredient(realIndex1, realIndex2);
        int realNewIndex1 = burger.ingredients.indexOf(ingredient1);
        int realNewIndex2 = burger.ingredients.indexOf(ingredient2);
        Assert.assertEquals(realIndex1, realNewIndex2);
        Assert.assertEquals(realIndex2, realNewIndex1);
    }

    @Test
    public void CheckGetPrice() {
        Burger burger = new Burger();
        burger.setBuns(bun);
        burger.addIngredient(ingredient);
        Mockito.when(bun.getPrice()).thenReturn(100.0F);
        Mockito.when(ingredient.getPrice()).thenReturn(50.0F);
        float actual = burger.getPrice();
        float expected = 250.0F;
        Assert.assertEquals(expected, actual, 0.0);
    }

    @Test
    public void CheckGetReceipt() {
        Burger burger = new Burger();
        burger.setBuns(bun);
        burger.addIngredient(ingredient);
        Mockito.when(bun.getName()).thenReturn("brioche");
        Mockito.when(ingredient.getType()).thenReturn(IngredientType.FILLING);
        Mockito.when(ingredient.getName()).thenReturn("Котлета");
        Mockito.when(bun.getPrice()).thenReturn(100.0F);
        Mockito.when(ingredient.getPrice()).thenReturn(50.0F);
        StringBuilder receipt = new StringBuilder(String.format("(==== %s ====)%n", bun.getName()));
        receipt.append(String.format("= %s %s =%n", ingredient.getType().toString().toLowerCase(), ingredient.getName()));
        receipt.append(String.format("(==== %s ====)%n", bun.getName()));
        receipt.append(String.format("%nPrice: %f%n", burger.getPrice()));
        String expected = receipt.toString();
        String actual = burger.getReceipt();
        Assert.assertEquals(expected, actual);
    }
}
