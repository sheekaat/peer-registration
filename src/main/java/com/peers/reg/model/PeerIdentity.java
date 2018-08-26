package com.peers.reg.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class PeerIdentity extends PeerKey {

	private String idType;
	private String idValue;
	private String idAttachment;
	private Boolean approved;
}
