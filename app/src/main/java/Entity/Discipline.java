package Entity;

public class Discipline {
    private String id,name;
    private int g1,g2,g3,g4;
    private String uni;

    public Discipline() {
        super();
    }

    public Discipline(String id,String name,int g1,int g2,int g3,int g4,String uni) {
        super();
        this.id = id;
        this.name = name;
        this.g1 = g1;
        this.g2 = g2;
        this.g3 = g3;
        this.g4 = g4;
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

    public String getUni() {
        return uni;
    }

    public void setUni(String uni) {
        this.uni = uni;
    }

    public int getG1() {
        return g1;
    }

    public void setG1(int g1) {
        this.g1 = g1;
    }

    public int getG2() {
        return g2;
    }

    public void setG2(int g2) {
        this.g2 = g2;
    }

    public int getG3() {
        return g3;
    }

    public void setG3(int g3) {
        this.g3 = g3;
    }

    public int getG4() {
        return g4;
    }

    public void setG4(int g4) {
        this.g4 = g4;
    }
}
