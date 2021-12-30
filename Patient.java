package com;

public class Patient {
    enum Gender {
        MALE, FEMALE, OTHER;
    }
    String name;
    String id;
    int age;
    long mobileNum;
    String emailId;
    String address;
    String city;
    String disease;
    Gender gender;

    @Override
    public String toString() {
        return "Patient{" +
                "name=" + name + "\n" +
                "id='" + id + "\n" +
                "age=" + age + "\n" +
                "mobileNum=" + mobileNum + "\n" +
                "emailId=" + emailId + "\n" +
                "address=" + address + "\n" +
                "city=" + city + "\n" +
                "disease=" + disease + "\n" +
                "gender=" + gender +
                '}';
    }
}

