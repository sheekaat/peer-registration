package com.peer.reg.controller;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.json.JSONObject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.peer.reg.service.PeerRegistrationService;
import com.peers.reg.model.Peer;

@RunWith(SpringRunner.class)
@WebMvcTest(PeerRegistrationController.class)
public class PeerRegistrationControllerTest {

	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private PeerRegistrationService peerRegistrationService;
	
	@Test
	public void registrationShouldRegisterPeer() throws Exception{
		
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("mobileNo", 1234567890);
		
		when(peerRegistrationService.registerPeer(Mockito.any(Peer.class))).thenReturn(new Peer());
		mockMvc.perform(post("/peerreg").content(jsonObject.toString()).accept("application/json").contentType("application/json")).andDo(print()).andExpect(status().isOk());
	}
}
