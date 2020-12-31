package Entity;

public class Email {
    private String userid,useremail,userrequest;
    public Email() {
        super();
    }

    public Email(String userid,String useremail,String userrequest) {
        super();
        this.userid = userid;
        this.useremail = useremail;
        this.userrequest = userrequest;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getUseremail() {
        return useremail;
    }

    public void setUseremail(String useremail) {
        this.useremail = useremail;
    }

    public String getUserrequest() {
        return userrequest;
    }

    public void setUserrequest(String userrequest) {
        this.userrequest = userrequest;
    }
}
