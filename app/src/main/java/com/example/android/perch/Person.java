package com.example.android.perch;

public class Person {
    private String id;
    private String name;
    private String email;
    private String phone;
    private String ownerID;

    public Person(String id, String name, String email, String phone, String ownerID) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.ownerID = ownerID;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public String getOwnerID() {
        return ownerID;
    }
}
