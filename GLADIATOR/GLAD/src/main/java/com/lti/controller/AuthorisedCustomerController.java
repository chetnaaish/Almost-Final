package com.lti.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.lti.dto.BookingDto;
import com.lti.dto.PassengerDto;
import com.lti.dto.Status;
import com.lti.dto.UpdateBusStatus;
import com.lti.dto.UpdateCustomerStatus;
import com.lti.entity.AuthorisedCustomer;
import com.lti.entity.Booking;
import com.lti.entity.Bus;
import com.lti.entity.PassengerDetail;
import com.lti.service.AuthorisedCustomerService;

@RestController
public class AuthorisedCustomerController {

	@Autowired
	private AuthorisedCustomerService authorisedCustomerService;
	
	@PostMapping("/addNewData.lti")
	public Status add (@RequestBody AuthorisedCustomer ac) {
		System.out.println(ac);
		int custid = authorisedCustomerService.add(ac);
		Status status = new Status();
		status.setMessage("Details added!!!!!!!!!!!!!!!!!!!!!");
		status.setGeneratedId(custid);
		return status;
	}
	
	@PostMapping("/check.lti")
	public boolean get (@RequestBody AuthorisedCustomer ac) {
		Boolean tf = authorisedCustomerService.get(ac);
		return tf; 	
	}
	
	@PostMapping("/getAll.lti")
	public List<AuthorisedCustomer> getAll() {
		return authorisedCustomerService.getAll();
	}
	
	@PostMapping("/updateauthorisedcustomer.lti")
	public void update(@RequestBody UpdateCustomerStatus ucs) {
		AuthorisedCustomer ac = authorisedCustomerService.fetchById(ucs.getCustId());

		ac.setfName(ucs.getFirstName());
		ac.setlName(ucs.getLastName());

		authorisedCustomerService.update(ac);
	}
	
	@PostMapping("/updatebus.lti")
	public void updateBus(@RequestBody UpdateBusStatus ubs) {
		Bus b = authorisedCustomerService.fetchByBusId(ubs.getBusId());

		b.setBusName(ubs.getBusName());
		b.setSource(ubs.getSource());
		b.setDestination(ubs.getDestination());


		authorisedCustomerService.updateBus(b);
	}
	
	@PostMapping("/search.lti")
	public List<Bus> BusList(@RequestBody Bus b) {
		List<Bus> bus = authorisedCustomerService.SearchResult(b);
		return bus;
	}
	
	@PostMapping("/ticketbook.lti")
	public List<PassengerDetail> BookList() {
	
		return authorisedCustomerService.Display();
	}
	
	@PostMapping(path = "/newPassengers.lti")
	public Status add ( PassengerDto dto) {
		
		int bookingId = authorisedCustomerService.addBooking(dto);
		
		Status status = new Status();
		status.setMessage("Passenger Details added!!!!!!!!!!!!!!!!!!!!!");
		status.setGeneratedId(bookingId);
		return status;
	}
}
