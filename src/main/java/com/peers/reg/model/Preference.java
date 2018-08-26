package com.peers.reg.model;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Preference {

	private String travellingPattern;
	private Date date;
	private Boolean includingHolidays = false;
	private Boolean subscribeToThis = false;
	private TypeOfPreference pickupPref;
	private TypeOfPreference deliverPref;

}