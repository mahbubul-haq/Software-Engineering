package ServerPackage;

import java.io.Serializable;

public class StockList implements Serializable {
    public String name;
    public int count;
    public float price;

    public StockList(String name, int count, float price) {
        this.name = name;
        this.count = count;
        this.price = price;
    }
}