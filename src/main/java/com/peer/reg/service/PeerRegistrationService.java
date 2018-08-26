package com.peer.reg.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.peer.reg.dao.PeerRegistrationRepository;
import com.peers.reg.model.Peer;
import com.peers.reg.model.PeerKey;

@Service
public class PeerRegistrationService {

	@Autowired
	private PeerRegistrationRepository peerRegistrationRepo;
	
	public Peer registerPeer(Peer peer) {
		return peerRegistrationRepo.insert(peer);
	}

	public String getUniqueKeyOfPeer(String mobileNo, String email) {
		PeerKey key = new PeerKey();
		key.setEmail(email);
		key.setMobileNo(mobileNo);
		Optional<Peer> optionalPeer = peerRegistrationRepo.findById(key);
		if(optionalPeer.isPresent()) {
			return optionalPeer.get().getId();
		}
		return null;
	}
}
