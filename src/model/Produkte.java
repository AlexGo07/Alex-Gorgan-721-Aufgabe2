package model;

public class Produkte {
    private String name;
    private double price;
    private String Herkunftregion;

    public Produkte(String name, double price, String Herkunftregion) {
        this.name = name;
        this.price = price;
        this.Herkunftregion = Herkunftregion;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getHerkunftregion() {
        return Herkunftregion;
    }

    public void Herkunftregion(String season) {
        this.Herkunftregion = season;
    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", Herkunftregion='" + Herkunftregion + '\'' +
                '}';
    }
}