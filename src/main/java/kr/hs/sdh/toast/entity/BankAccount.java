package kr.hs.sdh.toast.entity;

public class BankAccount {



    private String ba_uuid;
    private String bk_uuid;
    private String bc_uuid;
    private String ba_name;

    public void setBa_number(String ba_number) {
        this.ba_number = ba_number;
    }

    public void setBa_uuid(String ba_uuid) {
        this.ba_uuid = ba_uuid;
    }

    public void setBk_uuid(String bk_uuid) {
        this.bk_uuid = bk_uuid;
    }

    public void setBc_uuid(String bc_uuid) {
        this.bc_uuid = bc_uuid;
    }

    public void setBa_name(String ba_name) {
        this.ba_name = ba_name;
    }

    public void setBa_open_date(String ba_open_date) {
        this.ba_open_date = ba_open_date;
    }

    public void setBa_amount(String ba_amount) {
        this.ba_amount = ba_amount;
    }

    public void setBa_locked(String ba_locked) {
        this.ba_locked = ba_locked;
    }

    private String ba_number;

    public String getBa_open_date() {
        return ba_open_date;
    }

    public String getBa_uuid() {
        return ba_uuid;
    }

    public String getBk_uuid() {
        return bk_uuid;
    }

    public String getBc_uuid() {
        return bc_uuid;
    }

    public String getBa_name() {
        return ba_name;
    }

    public String getBa_number() {
        return ba_number;
    }

    public String getBa_amount() {
        return ba_amount;
    }

    public String getBa_locked() {
        return ba_locked;
    }

    private String ba_open_date;
    private String ba_amount;
    private String ba_locked;
}
