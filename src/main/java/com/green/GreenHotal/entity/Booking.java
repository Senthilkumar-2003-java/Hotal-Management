package com.green.GreenHotal.entity;

import jakarta.persistence.Entity;

import java.time.LocalDate;

import jakarta.persistence.*;
import jakarta.persistence.Table;
import jakarta.validation.constraints.*;
import lombok.Data;

@Data
@Entity
@Table(name = "bookings")
public class Booking {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull(message = "check in date is required")
	private LocalDate checkInDate;
	@Future(message = "check out date must be in the future")
	
	@Min(value = 1, message = "Number of aduls must not be less that 1")
	private int numOfAdults;
	
	@Min(value = 1, message = "Number of children must not be less that 0")
	private int numOfChildren;
	private int totalNumOfGuest;
	private String bookingConfirmationCode;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "user_id")
	private User user;
	

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "room_id")
	private Room room;


	
	
	public void calculateTotalNumberOfGuest() {
		this.totalNumOfGuest = this.numOfAdults + this.numOfChildren;
	}
	
	public void setNumOfAdults(int numOfAdults) {
		this.numOfAdults = numOfAdults;
		calculateTotalNumberOfGuest();
	}


	public void setNumOfChildren(int numOfChildren) {
		this.numOfChildren = numOfChildren;
		calculateTotalNumberOfGuest();
		
	}

	@Override
	public String toString() {
		return "Booking [id=" + id + ", checkInDate=" + checkInDate + ", numOfAdults=" + numOfAdults
				+ ", numOfChildren=" + numOfChildren + ", totalNumOfGuest=" + totalNumOfGuest
				+ ", bookingConfirmationCode=" + bookingConfirmationCode + '\'' + ']';
	}



}
