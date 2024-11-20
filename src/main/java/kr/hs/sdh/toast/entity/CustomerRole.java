package kr.hs.sdh.toast.entity;

public class CustomerRole {
    private String c_id;
    private String r_id;

    public String getC_id() {
        return c_id;
    }

    public String getR_id() {
        return r_id;
    }

    public CustomerRole(String c_id, String r_id) {
        this.c_id = c_id;
        this.r_id = r_id;
    }

    public String getC_Id (){return c_id;}
    public String getR_Id (){return r_id;}

}

// Customer(사용자)
// id    password    role
// admin 1234        MAN, VIP

// admin MAN
// admin VIP


// Role(권한)
// 매니저     MAN
// 부 매니저  SUB_MAN
// 브이아이피  VIP
// 골드       GOLD