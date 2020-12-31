package Entity;

public class Book {
    private String Bid,Bname,Btype,Barea,Bpublish,Buseuni,Busediscipline;
    private int Bcount,Busegrade;

    public Book() {
        super();
    }

    public Book(String Bid,String Bname,String Btype,String Barea,int Bcount,String Bpublish,String Buseuni,String Busediscipline,int Busegrade) {
        super();
        this.Bid = Bid;
        this.Bname = Bname;
        this.Btype = Btype;
        this.Barea = Barea;
        this.Bcount = Bcount;
        this.Bpublish = Bpublish;
        this.Buseuni = Buseuni;
        this.Busediscipline = Busediscipline;
        this.Busegrade = Busegrade;
    }

    public String getBid() {
        return Bid;
    }

    public String getBname() {
        return Bname;
    }

    public String getBtype() {
        return Btype;
    }

    public String getBarea() {
        return Barea;
    }

    public int getBcount() {
        return Bcount;
    }

    public String getBpublish() {
        return Bpublish;
    }

    public String getBuseuni() {
        return Buseuni;
    }

    public String getBusediscipline() {
        return Busediscipline;
    }

    public int getBusegrade() {
        return Busegrade;
    }

    public void setBid(String bid) {
        Bid = bid;
    }

    public void setBname(String bname) {
        Bname = bname;
    }

    public void setBtype(String btype) {
        Btype = btype;
    }

    public void setBarea(String barea) {
        Barea = barea;
    }

    public void setBcount(int bcount) {
        Bcount = bcount;
    }

    public void setBpublish(String bpublish) {
        Bpublish = bpublish;
    }

    public void setBuseuni(String buseuni) {
        Buseuni = buseuni;
    }

    public void setBusediscipline(String busediscipline) {
        Busediscipline = busediscipline;
    }

    public void setBusegrade(int busegrade) {
        Busegrade = busegrade;
    }
}
