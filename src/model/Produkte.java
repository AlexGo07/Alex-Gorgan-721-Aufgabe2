package model;

public class Produkte implements HasID {
    private Integer id;
    private String name;
    private double price;
    private String Herkunftregion;

    public Produkte(Integer id,String name, double price, String Herkunftregion) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.Herkunftregion = Herkunftregion;
    }
    public Integer getPacketId(){
        return id;
    }
    public void setPacketId(Integer id){
        this.id = id;
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

    public void setHerkunftregion(String herkunftregion) {
        this.Herkunftregion = herkunftregion;
    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", Herkunftregion='" + Herkunftregion + '\'' +
                '}';
    }

    @Override
    public Integer getId() {
        return id;
    }
}