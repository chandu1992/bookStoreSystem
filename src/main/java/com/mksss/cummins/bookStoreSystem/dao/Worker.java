package com.mksss.cummins.bookStoreSystem.dao;

import jakarta.validation.constraints.*;

import java.time.LocalDate;

public class Worker {

    @NotNull(message = "Name is mandatory")
    private String firstName;

    @NotNull(message = "Name is mandatory")
    private String lastName;

    @Email(message = "Email should be valid")
    private String email;

    @Min(value=18, message = "Age should be at least 18")
    @Max(value=60, message = "Age should not be more than 60")
    private int age;

    @Pattern(regexp = "\\d{10}",message = "Phone number should be 10 digits")
    private String mobileNo;

    @Size(min=8, message = "Password must be at least 8 characters")
    private String password;

    @NotBlank
    private String gender;

    @Past(message = "Date of birth must be in past" )
    private LocalDate birthDate;

    @PastOrPresent(message = "join date cannot be in future")
    private LocalDate joinDate;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public LocalDate getJoinDate() {
        return joinDate;
    }

    public void setJoinDate(LocalDate joinDate) {
        this.joinDate = joinDate;
    }
}
