package kr.hs.sdh.toast.entity;

import java.util.List;

public class Customer {
    private final String id;
    private final String password;
    private final String alias;
    private  People people;

    public String getId() {
        return id;
    }

    public Customer(String id, String password, String alias) {
        this.id = id;
        this.password = password;
        this.alias = alias;
    }

    public String getPassword() {
        return password;
    }

    public String getAlias() {
        return alias;
    }

    public void setPeople(People people) {
        this.people = people;
    }

    public People getPeople() {
        return people;
    }
}
