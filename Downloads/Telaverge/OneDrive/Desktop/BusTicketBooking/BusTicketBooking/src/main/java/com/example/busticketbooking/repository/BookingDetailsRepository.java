package com.example.busticketbooking.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.busticketbooking.entity.Bookingdetails;

@Repository
public interface BookingDetailsRepository extends JpaRepository<Bookingdetails, Long> {

	@Query("SELECT bd.name, bd.email, bd.phoneno, bd.age, b.source, b.destination " + "FROM Bookingdetails bd "
			+ "INNER JOIN Bus b ON bd.bus.id = b.id " + 
			"INNER JOIN UserAdmin u ON bd.user.id = u.id " + // Assuming																							// user table
			"WHERE u.id = ?1")
	List<Object> getBookingDetails(int userid);

	// @Query("SELECT bd.name, bd.email, bd.phoneno, bd.age, bd.bus.source,
	// bd.bus.destination " +
	// "FROM Bookingdetails bd " +
	// "INNER JOIN bd.bus " +
	// "INNER JOIN bd.user u " + // Assuming there's a user attribute in
	// Bookingdetails entity
	// "WHERE u.id = ?1")
	// List<Object> getBookingDetails(int userId);

	Bookingdetails findByid(int id);

	@Transactional
	void deleteByid(int id);

}
