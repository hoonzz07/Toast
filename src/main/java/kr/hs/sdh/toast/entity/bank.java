package kr.hs.sdh.toast.entity;

public class bank {

    private String b_name;
    private String b_rep;
    private String b_setter;
    private String b_code;

    public void setB_name(String b_name) {
        this.b_name = b_name;
    }

    public void setB_rep(String b_rep) {
        this.b_rep = b_rep;
    }

    public void setB_setter(String b_setter) {
        this.b_setter = b_setter;
    }

    public void setB_code(String b_code) {
        this.b_code = b_code;
    }

    public void setB_establish_date(String b_establish_date) {
        this.b_establish_date = b_establish_date;
    }

    public void setB_uuid(String b_uuid) {
        this.b_uuid = b_uuid;
    }

    private String b_establish_date ;

    public String getB_uuid() {
        return b_uuid;
    }

    public String getB_establish_date() {
        return b_establish_date;
    }

    public String getB_code() {
        return b_code;
    }

    public String getB_setter() {
        return b_setter;
    }

    public String getB_rep() {
        return b_rep;
    }

    public String getB_name() {
        return b_name;
    }

    private String b_uuid;
}
