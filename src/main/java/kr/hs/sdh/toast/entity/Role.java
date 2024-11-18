package kr.hs.sdh.toast.entity;

public class Role {
    private String r_id;
    private String r_name;

    public String getR_id() {
        return r_id;
    }

    public String getR_name() {
        return r_name;
    }

    public String getR_code() {
        return r_code;
    }

    public Role(String r_id, String r_name, String r_code) {
        this.r_id = r_id;
        this.r_name = r_name;
        this.r_code = r_code;
    }

    private String r_code;
}
