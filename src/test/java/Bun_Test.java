import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Bun;
import praktikum.IngredientType;

@RunWith(Parameterized.class)

public class Bun_Test {

    private final String name;

    private final float price;

    private final String expectedName;

    private final float expectedPrice;


    public Bun_Test(String name,float price, String expectedName, float expectedPrice){
        this.name = name;
        this.price = price;
        this.expectedName = expectedName;
        this.expectedPrice = expectedPrice;
    }
    @Parameterized.Parameters
    public static Object[][] getData() {
        return new Object[][] {
                {"black bun", 100,"black bun", 100},
                {"white bun", 200,"white bun", 200},
                {"red bun", 300,"red bun", 300}
        };
    }
    @Test
    public void checkGetName(){
        Bun bun = new Bun (name, price);
        String actualName = bun.getName();
        Assert.assertEquals(expectedName, actualName);
    }

    @Test
    public void checkGetPrice(){
        Bun bun = new Bun(name, price);
        float actualPrice = bun.getPrice();
        Assert.assertEquals(expectedPrice, actualPrice,0.0);
    }

}
