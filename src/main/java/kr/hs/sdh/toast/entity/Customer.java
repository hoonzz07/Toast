package kr.hs.sdh.toast.entity;

public class Customer {
    private String c_id;
    private String c_password;
    private String c_name;
    private String c_identity;
    private String c_email;
    private String c_contact;
    private String c_address;


    public Customer(String c_id, String c_password, String c_name, String c_identity, String c_email, String c_contact, String c_address) {
        this.c_id = c_id;
        this.c_password = c_password;
        this.c_name = c_name;
        this.c_identity = c_identity;
        this.c_email = c_email;
        this.c_contact = c_contact;
        this.c_address = c_address;
    }


    public String getC_id() {
        return c_id;
    }

    public String getC_password() {
        return c_password;
    }

    public String getC_name() {
        return c_name;
    }

    public String getC_identity() {
        return c_identity;
    }

    public String getC_email() {
        return c_email;
    }

    public String getC_contact() {
        return c_contact;
    }

    public String getC_Address() {
        return c_address;
    }

    public String getId (){return c_id;}
    public String getPassword (){return c_password;}
    public String getName (){return c_name;}
    public String getIdentity (){return c_identity;}
    public String getEmail (){return c_email;}
    public String getContact (){return c_contact;}
    public String getAddress (){return c_address;}

}
