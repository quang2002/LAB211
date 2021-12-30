package Components;

/**
 *
 * @author yuyu
 */
public class Fruit {

    private int id;
    private String name;
    private float price;
    private int quantity;
    private String origin;

    public Fruit() {
    }

    public Fruit(int id, String name, float price, int quantity, String origin) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.origin = origin;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public Fruit createClone() {
        return new Fruit(id, name, price, quantity, origin);
    }
}
