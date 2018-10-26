package com.example.android.perch;

public class ParkingSpace {
    private String id;
    private String ownerName;
    private String address;
    private String email;
    private String phone;
    private float review;
    private String reviewDesc;
    private boolean isHourly;
    private boolean isDaily;
    private boolean isWeekly;
    private boolean isMonthly;
    private String ownerID;
    private double hourlyCost;
    private double dailyCost;
    private double weeklyCost;
    private double monthlyCost;
    private int age;

    public ParkingSpace(String id, String ownerName, String address, String email, String phone,
                        float review, String reviewDesc, boolean isHourly, boolean isDaily,
                        boolean isWeekly, boolean isMonthly, String ownerID, double hourlyCost,
                        double dailyCost, double weeklyCost, double monthlyCost, int age) {
        this.id = id;
        this.ownerName = ownerName;
        this.address = address;
        this.email = email;
        this.phone = phone;
        this.review = review;
        this.reviewDesc = reviewDesc;
        this.isHourly = isHourly;
        this.isDaily = isDaily;
        this.isWeekly = isWeekly;
        this.isMonthly = isMonthly;
        this.ownerID = ownerID;
        this.hourlyCost = hourlyCost;
        this.dailyCost = dailyCost;
        this.weeklyCost = weeklyCost;
        this.monthlyCost = monthlyCost;
        this.age = age;
    }

    public String getId() {
        return id;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public String getAddress() {
        return address;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public float getReview() {
        return review;
    }

    public String getReviewDesc() {
        return reviewDesc;
    }

    public boolean isHourly() {
        return isHourly;
    }

    public boolean isDaily() {
        return isDaily;
    }

    public boolean isWeekly() {
        return isWeekly;
    }

    public boolean isMonthly() {
        return isMonthly;
    }

    public String getOwnerID() {
        return ownerID;
    }

    public double getHourlyCost() {
        return hourlyCost;
    }

    public double getDailyCost() {
        return dailyCost;
    }

    public double getWeeklyCost() {
        return weeklyCost;
    }

    public double getMonthlyCost() {
        return monthlyCost;
    }

    public int getAge() {
        return age;
    }
}
