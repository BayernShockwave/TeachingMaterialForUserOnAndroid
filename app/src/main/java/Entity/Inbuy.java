package Entity;

import java.util.Date;

public class Inbuy {
    private String id,name;
    private int price;
    private Date intime;
    private int count;
    private String uni;

    public Inbuy() {
        super();
    }

    public Inbuy(String id,String name,int price,Date intime,int count,String uni) {
        super();
        this.id = id;
        this.name = name;
        this.price = price;
        this.intime = intime;
        this.count = count;
        this.uni = uni;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Date getIntime() {
        return intime;
    }

    public void setIntime(Date intime) {
        this.intime = intime;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getUni() {
        return uni;
    }

    public void setUni(String uni) {
        this.uni = uni;
    }
}
