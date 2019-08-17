package com.lti.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="PASS_DETAIL")
public class PassengerDetail {
	
	@Id
	@GeneratedValue
	
	@Column(name="PID")
	private int passengerId;
	
	@Column(name="PNAME")
	private String passengerName;
	
	private String gender;
	private int age;
	
	@Column(name="EMAILID")
	private String pemail;
	
	@Column(name="CONTACTNO")
	private int pcontactno;
	private String seatno;

	
	@ManyToOne
	@JoinColumn(name="bookid_fk")
	private Booking book;


	public int getPassengerId() {
		return passengerId;
	}


	public void setPassengerId(int passengerId) {
		this.passengerId = passengerId;
	}


	public String getPassengerName() {
		return passengerName;
	}


	public void setPassengerName(String passengerName) {
		this.passengerName = passengerName;
	}


	public String getGender() {
		return gender;
	}


	public void setGender(String gender) {
		this.gender = gender;
	}


	public int getAge() {
		return age;
	}


	public void setAge(int age) {
		this.age = age;
	}


	public String getPemail() {
		return pemail;
	}


	public void setPemail(String pemail) {
		this.pemail = pemail;
	}


	public int getPcontactno() {
		return pcontactno;
	}


	public void setPcontactno(int pcontactno) {
		this.pcontactno = pcontactno;
	}


	public String getSeatno() {
		return seatno;
	}


	public void setSeatno(String seatno) {
		this.seatno = seatno;
	}


	public Booking getBook() {
		return book;
	}


	public void setBook(Booking book) {
		this.book = book;
	}
	
	
	
	
	
	
}
