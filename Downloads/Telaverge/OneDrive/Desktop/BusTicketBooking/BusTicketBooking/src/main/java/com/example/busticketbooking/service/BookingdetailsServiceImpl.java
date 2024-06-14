package com.example.busticketbooking.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.busticketbooking.entity.Bookingdetails;
import com.example.busticketbooking.entity.Driver;
import com.example.busticketbooking.repository.BookingDetailsRepository;


@Service
public class BookingdetailsServiceImpl implements BookingDetailsService {
	
	@Autowired
	private BookingDetailsRepository bookRepo;

	@Override
	public Bookingdetails savebookingdetails(Bookingdetails bookingdetails) {
		
		Bookingdetails booking=bookRepo.save(bookingdetails);
	
		return booking;
	}

	@Override
	public List<Object>  getBookingDetails(int userid) {
		List<Object> bookingDetails=bookRepo.getBookingDetails(userid);
		if(bookingDetails!=null) {
			return bookingDetails;
		}
		return null;
	}

	@Override
	public Boolean cancelTickets(int id) {
		Bookingdetails ticket= bookRepo.findByid(id);
		if(ticket!=null) {
			  try {
			        bookRepo.deleteByid(id);
			        return true;
			      
			    } catch (Exception e) {
			        e.printStackTrace();
			        return false;
			    }
			
		}else {
			return false;
		}
	}


}
