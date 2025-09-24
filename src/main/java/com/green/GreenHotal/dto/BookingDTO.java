package com.green.GreenHotal.dto;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.green.GreenHotal.entity.Room;
import com.green.GreenHotal.entity.User;

import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BookingDTO {
	private Long id;
	
	private LocalDate checkInDate;
	
	private int numOfAdults;
	
	private int numOfChildren;
	private int totalNumOfGuest;
	private String bookingConfirmationCode;
	
	private UserDTO user;

	private RoomDTO room;

}
