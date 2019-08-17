package com.lti.service;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lti.dao.LoginDao;
import com.lti.dao.SearchDao;
import com.lti.dto.PassengerDto;
import com.lti.entity.AuthorisedCustomer;
import com.lti.entity.Booking;
import com.lti.entity.Bus;
import com.lti.entity.BusRoute;
import com.lti.entity.PassengerDetail;

@Service
public class AuthorisedCustomerService {

	@Autowired
	private SearchDao dao;
	
	@Autowired
	private LoginDao logindao;

	@Transactional
    public int add(AuthorisedCustomer ac) {
	AuthorisedCustomer updatedDetails = (AuthorisedCustomer) dao.save(ac);
	return updatedDetails.getCustId();
	}
	
	public List<AuthorisedCustomer> getAll(){
    	   return dao.fetchAll(AuthorisedCustomer.class);
       }
	
    public boolean get(AuthorisedCustomer ac) {
		String email = ac.getEmail(); 
		String password = ac.getPassword();
		return logindao.loginValidation(email, password);
	}
    
    public List<Bus> SearchResult(Bus b){
    	String source = b.getSource();
    	String destination = b.getDestination();
    	return  dao.SearchResult(source, destination);
	}
    
    
    public List<PassengerDetail> Display(){
    	
    	
    
    	return  dao.fetchAll(PassengerDetail.class);
	}
    
    
    public int add(Booking book) {
		Booking updatedDetails = (Booking) dao.save(book);
	return updatedDetails.getBookingId();
	}
    public Bus fetchByBusId(int id) {
		return dao.fetchById(Bus.class, id);
	}
	
    public Booking fetchByBookId(int id) {
		return dao.fetchById(Booking.class, id);
	}
	public AuthorisedCustomer fetchById(int id) {
		return dao.fetchById(AuthorisedCustomer.class, id);
	}
    @Transactional
	public void update(AuthorisedCustomer ac) {
		dao.save(ac);
	}

	@Transactional
	public void updateBus(Bus b) {
		dao.save(b);
	}
	
	@Transactional 
	public int addBooking(PassengerDto dto) {
		AuthorisedCustomer cust = dao.fetchById(AuthorisedCustomer.class, dto.getCustomerId());
		BusRoute route = dao.fetchById(BusRoute.class, dto.getRouteId());
		
		Booking booking = new Booking();
		booking.setBusroute(route);
		booking.setCust(cust);
		booking.setNumberofseat(2);
		booking.setTotalfare(1600);
		
		booking.setDatetime(LocalDateTime.now());
		
		HashSet<PassengerDetail> passengers = new HashSet<PassengerDetail>();
		for(PassengerDetail p : dto.getPassengerDetails()) {
			p.setBook(booking);
			passengers.add(p);
		}
		booking.setPassd(passengers);
		
		Booking updatedBooking = (Booking) dao.save(booking);
		return updatedBooking.getBookingId();
	}
}
	

