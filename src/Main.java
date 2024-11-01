import java.util.ArrayList;
import java.util.Scanner;

interface Ingredient{
    String getName();
    double getQuantity();
}
class SolidIngredient implements Ingredient {
    private String name;
    private double grams;

    SolidIngredient(String name, double quantity) {
        this.name = name;
        this.grams = quantity;
    }
    public String getName(){ return name;}
    public double getQuantity(){ return grams;}
    public void setName(String n) {name = n;}
    public void setGrams(int q) {grams = q;}
    public boolean equals(Object o){
        if (this == o) return true;
        if (o == null) return false;
        if (o instanceof LiquidIngredient s)
            return s.getName().equals(name)
                && s.getQuantity() == grams;
        return false;
    }
}
class LiquidIngredient implements Ingredient {
    private String name;
    private double milliliters;

    LiquidIngredient(String name, double quantity) {
        this.name = name;
        this.milliliters = quantity;
    }
    public String getName(){ return name;}
    public double getQuantity(){ return milliliters;}
    public void setName(String n) {name = n;}
    public void setQuantity(int q) { milliliters = q;}
    public boolean equals(Object o){
        if (this == o) return true;
        if (o == null) return false;
        if (o instanceof LiquidIngredient l)
            return l.getName().equals(name)
                    && l.getQuantity() == milliliters;
        return false;
    }
}
class Recipe<T extends Ingredient>{
    private String name;
    private String[] instructions;
    private ArrayList<T> ingredients;

    public Recipe(String name, String[] instructions){
        this.name = name;
        this.instructions = instructions;
        this.ingredients = new ArrayList<>();
    }
    public void addIngredient(T ing){
        ingredients.add(ing);
    }
    public void print() {
        System.out.println("Recipe: " + name);
        System.out.println("Instructions: " + instructions);
        System.out.println("Ingredients: ");
        for (T t : ingredients) {
            System.out.println("- " + t.getName() + ": " + t.getQuantity());
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Recipe Menu:");
        System.out.println("1. Add Ingredient");
        System.out.println("2. Print Ingredients");
        System.out.println("3. Exit");
        int choice = scan.nextInt();
        try {

        }
        //addIngredient function
        //menu function
        while (choice != 3){
            switch (choice){
                case 1:
                    System.out.println("True or False: The Ingredient is Solid ");
                    char type = scan.nextLine(); //only use next line because buffer
                    System.out.println("Enter Name of Ingredient: ");
                    String name = scan.nextLine();
                    System.out.println("Enter Quantity of Ingredient: ");
                    double quantity = scan.nextDouble();
                    Ingredient ingredient;
                    if (char == 's')
                        ingredient = new SolidIngredient(name, quantity);
                    else
                        ingredient = new LiquidIngredient(name, quantity);

                    Recipe.addIngredient(ingredient);
                case 2:

            }
        } //provide a simple example of how to conduct a unit test in intellij
    }
}