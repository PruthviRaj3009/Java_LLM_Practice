import java.util.*;

class BurgerMeal {
    // required properties
    
    private final String bunType;
    private final String pattyType;

    //Optional properties

    private boolean hasChess;
    private List<String> toppings;
    private String side;
    private String drink;

    private BurgerMeal(BurgerBuilder burgerBuilder) {
        this.bunType = burgerBuilder.bunType;
        this.pattyType = burgerBuilder.pattyType;
        this.hasChess = burgerBuilder.hasChess;
        this.toppings = burgerBuilder.toppings;
        this.side = burgerBuilder.side;
        this.drink = burgerBuilder.drink;
    }
    public static class BurgerBuilder{
        private final String bunType;
        private final String pattyType;

        private boolean hasChess;
        private List<String> toppings = new ArrayList<>();
        private String side;
        private String drink;

        public BurgerBuilder(String bunType, String pattyType){
            this.bunType = bunType;

            this.pattyType = pattyType;
        }
        public BurgerBuilder addCheese(boolean hasChess){
            this.hasChess = hasChess;

            System.out.println(this);

            return this;
        }
        public BurgerBuilder addTopping(String topping){
            this.toppings.add(topping);
            System.out.println("addTopping called");
            System.out.println(this);

            return this;
        }
        public BurgerBuilder addSide(String side){
            this.side = side;
            System.out.println("addSide called");
            
            System.out.println(this);

            return this;
        }

        public BurgerBuilder addDrink(String drink) {
            this.drink = drink;
            System.out.println("addDrink called");

            System.out.println(this);
            return this;
        }

        public BurgerMeal build() {
            System.out.println(this);

            return new BurgerMeal(this);
        }
         
    } 
}
public class Main {
    public static void main(String[] args) {
        BurgerMeal burgerMeal = new BurgerMeal.BurgerBuilder("Whole Wheat", "Beef")
                .addCheese(true)
                .addTopping("Lettuce")
                .addTopping("Tomato")
                .addSide("Fries")
                .addDrink("Cola")
                .build();
    }
}
