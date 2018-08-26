package com.peers.reg.model;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Document(collection = "Locations")
@Getter
@Setter
@ToString
public class Location {

	private String zipCode;
	private String address1;
	private String address2;
	private String city;
	private String state;
	private String country;
}
