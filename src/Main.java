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
        for (int i = 0; i < instructions.length; i++)
            System.out.println("Instruction " + (i+1) + ". " + instructions[i]);
        System.out.println("Ingredients: ");
        for (T t : ingredients)
            System.out.println("- " + t.getName() + ": " + t.getQuantity());


    }
}


public class Main {
    public static void addIngredient(Recipe<Ingredient> recipe,Scanner scan){
        System.out.println("Press s for Solid Ingredient or l for Liquid");
        char type = 'c';
        try {
            type = scan.nextLine().charAt(0); //only use next line because buffer
        }
        catch (Exception e){
            System.out.println("Invalid Input");
            System.exit(-1);
        }
        System.out.println("Enter Name of Ingredient: ");
        String name = scan.nextLine();
        System.out.println("Enter Quantity of Ingredient: ");
        double quantity = 0;
        try {
            quantity = Double.parseDouble(scan.nextLine());
        }
        catch (NumberFormatException e){
            System.out.println("Invalid Input");
            System.exit(-1);
        }
        Ingredient ingredient;
        type = Character.toLowerCase(type);
        if (type == 's') {
            ingredient = new SolidIngredient(name, quantity);
            recipe.addIngredient(ingredient);
        }
        else if (type == 'l') {
            ingredient = new LiquidIngredient(name, quantity);
            recipe.addIngredient(ingredient);
        }
        else
            System.out.println("Not a Valid Input");
    }
    public static void menu(int choice, Recipe<Ingredient> recipe,Scanner scan){
        while (choice != 3){
            switch (choice){
                case 1:
                    addIngredient(recipe,scan);
                    break;
                case 2:
                    recipe.print();
                    break;
                default:
                    System.out.println("Not a Valid Input");
            }
            System.out.println();
            System.out.println("Recipe Menu:");
            System.out.println("1. Add Ingredient");
            System.out.println("2. Print Ingredients");
            System.out.println("3. Exit");
            choice = Integer.parseInt(scan.nextLine());
        }
    }
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] instructions = new String[] {"Gather Ingredients.",
                "Mix into Large Bowl.",
                "Pour onto Baking Sheet.",
                "Bake in Oven for 15 Minutes.",
                "Cool for 5 Minutes.",
                "Enjoy!"};
        Recipe<Ingredient> recipe = new Recipe<>("Monkey Bread", instructions);
        System.out.println("Recipe Menu:");
        System.out.println("1. Add Ingredient");
        System.out.println("2. Print Ingredients");
        System.out.println("3. Exit");
        int choice = 0;
        try {
            choice = Integer.parseInt(scan.nextLine());
        }
        catch (NumberFormatException e){
            System.out.println("Invalid Input");
            System.exit(-1);
        }
        menu(choice,recipe,scan);
    }
} //provide a simple example of how to conduct a unit test in intellij