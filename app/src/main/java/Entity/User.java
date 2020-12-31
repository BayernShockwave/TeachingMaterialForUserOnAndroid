package Entity;

public class User {
    private String userid,password,name,uni;

    public User() {
        super();
    }

    public User(String userid,String password,String name,String uni) {
        super();
        this.userid = userid;
        this.password = password;
        this.name = name;
        this.uni = uni;
    }

    public void setUserid(String userid) {
        this.userid=userid;
    }
    public String getUserid() {
        return userid;
    }
    public void setPassword(String password) {
        this.password=password;
    }
    public String getPassword() {
        return password;
    }
    public void setName(String name) {
        this.name=name;
    }
    public String getName() {
        return name;
    }
    public void setUni(String uni) {
        this.uni=uni;
    }
    public String getUni() { return uni; }
}
