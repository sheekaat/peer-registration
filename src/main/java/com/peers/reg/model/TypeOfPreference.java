package com.peers.reg.model;

import java.time.LocalDateTime;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class TypeOfPreference {

	private Integer zipCode;
	private Integer acceptableRange;
	private String acceptableRangeDimension;
	private LocalDateTime timeZone;
	private Boolean acceptOnTheWay = false;
}