package com.peers.reg.model;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Document(collection = "Peer")
@Getter
@Setter
@ToString
public class Peer extends PeerIdentity {

	@Id
	private String id;
	private String firstName;
	private String lastName;
	private String middleName;
	private Integer birthYear;
	private Location location;
	private List<Preference> preferences;
}
