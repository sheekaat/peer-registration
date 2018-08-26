package com.peer.reg.dao;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.google.gson.Gson;
import com.peers.reg.model.Peer;

@DataMongoTest
@RunWith(SpringRunner.class)
public class PeerRegistrationRepoTest {
	
	@Autowired
	private PeerRegistrationRepository peerRegRepo;

	@Before
	public void setup() {
		peerRegRepo.deleteAll();
		Peer peer = buildPeer();
		peerRegRepo.save(peer);
	}
	
	@Test
	public void testFindAll() {
		List<Peer> peerList = peerRegRepo.findAll();
		Assert.assertEquals(0, peerList.size());
	}

	private Peer buildPeer(){
		try(BufferedReader reader = new BufferedReader(new FileReader("PeerRegistrationReq.json"))) {
			return new Gson().fromJson(reader, Peer.class);
		} catch (IOException exception) {
			exception.printStackTrace();
		} 
		return null;
	}
}
