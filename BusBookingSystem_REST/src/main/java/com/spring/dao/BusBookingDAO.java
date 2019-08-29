package com.spring.dao;

import java.util.Date;
import java.util.List;

import com.spring.beans.Admin;
import com.spring.beans.Available;
import com.spring.beans.Bus;
import com.spring.beans.Suggestion;
import com.spring.beans.Ticket;
import com.spring.beans.User;
import com.spring.exception.RegisterException;

public interface BusBookingDAO {
	
	    //user manipulation
		public Boolean createUser(User user)throws RegisterException;
		public Boolean updateUser(User user);
		public Boolean deleteUser(int user_id , String password);
		public User loginUser(int user_id, String password);
		public User searchUser(int user_id);
		
		//bus manipulation
		public Boolean createBus(Bus bus);
		public Boolean updateBus(Bus bus);
		public Bus searchBus(int bus_id);
		public Boolean deletebus(int bus_id);
		
		//admin
		public Admin adminLogin(int admin_id, String password);
		
		
		//ticket booking
		public Ticket bookTicket(Ticket ticket);
		public Boolean cancelTicket(int booking_id);
		public Ticket getTicket(int booking_id,int userid);
		public List <Available>checkAvailability(String source,String destination,Date date);
		public Integer checkAvailability( int bus_id, Date date);
		public Boolean setAvailability(Available available);
		public List<Ticket> getAllTicket(int userId);
		
		public Boolean giveFeedback(Suggestion sugg);
		public List<Suggestion> getAllSuggestions(Suggestion sugg); 
		

}
