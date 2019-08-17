package com.lti.entity;

import java.time.LocalDateTime;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Booking {
	
	@Id
	@GeneratedValue
	@Column(name="BID")
	private int bookingId;

	@ManyToOne
	@JoinColumn(name = "CUSTID_FK")
	private AuthorisedCustomer cust;

	@Column(name="NO_OF_SEATS")
	private int numberofseat;
	
	private int totalfare;
	
	@Column(name="DATEANDTIME")
	private LocalDateTime datetime;

	@ManyToOne
	@JoinColumn(name = "ROUTEID_FK")
	private BusRoute busroute;
	
	@OneToMany(mappedBy = "book",cascade=CascadeType.ALL)
	private Set<PassengerDetail> passd;

	public int getBookingId() {
		return bookingId;
	}

	public void setBookingId(int bookingId) {
		this.bookingId = bookingId;
	}

	public AuthorisedCustomer getCust() {
		return cust;
	}

	public void setCust(AuthorisedCustomer cust) {
		this.cust = cust;
	}

	public int getNumberofseat() {
		return numberofseat;
	}

	public void setNumberofseat(int numberofseat) {
		this.numberofseat = numberofseat;
	}

	public int getTotalfare() {
		return totalfare;
	}

	public void setTotalfare(int totalfare) {
		this.totalfare = totalfare;
	}

	public LocalDateTime getDatetime() {
		return datetime;
	}

	public void setDatetime(LocalDateTime datetime) {
		this.datetime = datetime;
	}

	public BusRoute getBusroute() {
		return busroute;
	}

	public void setBusroute(BusRoute busroute) {
		this.busroute = busroute;
	}

	public Set<PassengerDetail> getPassd() {
		return passd;
	}

	public void setPassd(Set<PassengerDetail> passd) {
		this.passd = passd;
	}


	
}
