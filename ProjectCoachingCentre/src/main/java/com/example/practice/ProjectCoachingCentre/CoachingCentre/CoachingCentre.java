package com.example.practice.ProjectCoachingCentre.CoachingCentre;

import javax.persistence.*;

@Entity
@Table(name = "coachingtutorial")
public class CoachingCentre {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    Integer id;
    Integer userId;
    String userName;
    String email;
    Long phoneNumber;
    String address;
    String status;
    Integer bookingHistory;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(Long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getBookingHistory() {
        return bookingHistory;
    }

    public void setBookingHistory(Integer bookingHistory) {
        this.bookingHistory = bookingHistory;
    }
}
