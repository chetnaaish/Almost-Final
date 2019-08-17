package com.lti.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="AUTH_CUST")
public class AuthorisedCustomer {
	
	@Id
	@GeneratedValue
	private int custId;
	private String fName;
	private String lName;
	private String email;
	private String password;
	private int contactNo;
	private double wallet;
	public int getCustId() {
		return custId;
	}
	public void setCustId(int custId) {
		this.custId = custId;
	}
	public String getfName() {
		return fName;
	}
	public void setfName(String fName) {
		this.fName = fName;
	}
	public String getlName() {
		return lName;
	}
	public void setlName(String lName) {
		this.lName = lName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getContactNo() {
		return contactNo;
	}
	public void setContactNo(int contactNo) {
		this.contactNo = contactNo;
	}
	public double getWallet() {
		return wallet;
	}
	public void setWallet(double wallet) {
		this.wallet = wallet;
	}
	@Override
	public String toString() {
		return "AuthorisedCustomer [custId=" + custId + ", fName=" + fName + ", lName=" + lName + ", email=" + email
				+ ", password=" + password + ", contactNo=" + contactNo + ", wallet=" + wallet + "]";
	}
	
	
}
