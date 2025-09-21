package com.green.GreenHotal.entity;

import jakarta.persistence.Entity;

import java.math.BigDecimal;
import java.util.*;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "room")
public class Room {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	private Long id;
	
	private String roomtype;
	private BigDecimal roomPrice;
	private String roomPhotoUrl;
	private String roomDescription;
	private List<Booking> bookings = new ArrayList<>();
	@Override
	public String toString() {
		return "Room [id=" + id + ", roomtype=" + roomtype + ", roomPrice=" + roomPrice + ", roomPhotoUrl="
				+ roomPhotoUrl + ", roomDescription=" + roomDescription + "]";
	}
	
}
