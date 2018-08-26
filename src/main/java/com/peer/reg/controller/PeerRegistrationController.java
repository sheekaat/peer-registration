package com.peer.reg.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.peer.reg.exceptions.PeerNotFoundException;
import com.peer.reg.service.PeerRegistrationService;
import com.peers.reg.model.Peer;

@RestController
public class PeerRegistrationController {

	@Autowired
	private PeerRegistrationService peerRegistrationService;

	@PostMapping(path="/peerreg", consumes="application/json", produces="application/json")
	public Peer registerPeer(@RequestBody Peer peer) {
		return peerRegistrationService.registerPeer(peer);
	}

	@GetMapping("/uniqueKey")
	public String getPeerUniqueId(@RequestParam String mobileNo, @RequestParam String email ) {
		String uniqueId =  peerRegistrationService.getUniqueKeyOfPeer(mobileNo, email);
		if(null == uniqueId) {
			throw new PeerNotFoundException();
		}
		return uniqueId;
	}
	
}
