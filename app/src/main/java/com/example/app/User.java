package com.example.app;

public class User {
   String name;
   String email;
  String phone;
   String carNumber;
  String carModel;
    public User( ){

    }
    public User(String name,String email,String phone,String carNumber,String carModel) {
        this.name = name;
        this.email=email;
        this.phone=phone;
        this.carNumber=carNumber;
        this.carModel=carModel;
    }


    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public String getCarNumber() {
        return carNumber;
    }

    public String getCarModel() {
        return carModel;
    }
}
