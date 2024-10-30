interface Ingredient{
    String getName();
    double getQuantity();
}
class SolidIngredient implements Ingredient {
    private String name;
    private double quantity;

    SolidIngredient(String name, double quantity) {
        this.name = name;
        this.quantity = quantity;
    }
    public String getName(){ return name;}
    public double getQuantity(){ return quantity;}
    public void setName(String n) {name = n;}
    public void setQuantity(int q) {quantity = q;}
    public boolean equals(Object o){
        if (this == o) return true;
        if (o == null) return false;
        if (o instanceof LiquidIngredient s)
            return s.getName().equals(name)
                && s.getQuantity() == quantity;
        return false;
    }
}
class LiquidIngredient implements Ingredient {
    private String name;
    private double quantity;

    LiquidIngredient(String name, double quantity) {
        this.name = name;
        this.quantity = quantity;
    }
    public String getName(){ return name;}
    public double getQuantity(){ return quantity;}
    public void setName(String n) {name = n;}
    public void setQuantity(int q) {quantity = q;}
    public boolean equals(Object o){
        if (this == o) return true;
        if (o == null) return false;
        if (o instanceof LiquidIngredient l)
            return l.getName().equals(name)
                    && l.getQuantity() == quantity;
        return false;
    }
}
class Recipe<T extends Ingredient>{

}

public class Main {
    public static void main(String[] args) {

    }
}