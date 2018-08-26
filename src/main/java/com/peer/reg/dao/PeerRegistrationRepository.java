package com.peer.reg.dao;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.peers.reg.model.Peer;
import com.peers.reg.model.PeerKey;

public interface PeerRegistrationRepository extends MongoRepository<Peer, PeerKey> {}
