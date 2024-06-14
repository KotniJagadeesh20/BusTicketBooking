package com.example.busticketbooking.service;

import java.util.List;

import com.example.busticketbooking.entity.Bookingdetails;

public interface BookingDetailsService {
	
	Bookingdetails savebookingdetails(Bookingdetails bookingdetails);
	
	List<Object>  getBookingDetails(int userid);
	
	Boolean cancelTickets(int id);

}
