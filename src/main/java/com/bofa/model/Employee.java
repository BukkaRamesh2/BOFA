package com.bofa.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;


@NoArgsConstructor(force = true)
@AllArgsConstructor
@Entity
public class Employee {

//    public Employee(){}
//     *  Employees -- Gowth
     @Id
     @GeneratedValue(strategy = GenerationType.AUTO)
     private long employeeId;
     private String firstName;
     private String lastName;
     private String address;
     private String email;
     private long mobileNumber;
     private String gender;
     private long  salary;

//    public Employee(long employeeId, String firstName, String lastName, String address, String email, long mobileNumber, String gender, long salary) {
//        this.employeeId = employeeId;
//        this.firstName = firstName;
//        this.lastName = lastName;
//        this.address = address;
//        this.email = email;
//        this.mobileNumber = mobileNumber;
//        this.gender = gender;
//        this.salary = salary;
//    }


    public Employee(int i, String string, String string2, String string3, String string4, long l, String string5,
			int j) {
		// TODO Auto-generated constructor stub
	}

	public long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(long employeeId) {
        this.employeeId = employeeId;
    }

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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public long getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(long mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public long getSalary() {
        return salary;
    }

    public void setSalary(long salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employees{" +
                "employeeId='" + employeeId + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", address='" + address + '\'' +
                ", email='" + email + '\'' +
                ", mobileNumber=" + mobileNumber +
                ", gender='" + gender + '\'' +
                ", salary=" + salary +
                '}';
    }
}
