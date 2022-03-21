package my.javabrains.dao;

public class ItemsDao {
    public String name;
    public String price;
    public String counter;

    public ItemsDao(String name, String price, String counter) {
        this.name = name;
        this.price = price;
        this.counter = counter;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getCounter() {
        return counter;
    }

    public void setCounter(String counter) {
        this.counter = counter;
    }

}
