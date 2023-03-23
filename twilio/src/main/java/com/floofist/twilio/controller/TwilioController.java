package com.floofist.twilio.controller;

import java.net.URI;
import java.net.URISyntaxException;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.twilio.rest.api.v2010.account.Call;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.rest.api.v2010.account.MessageCreator;
import com.twilio.type.PhoneNumber;

@RestController
public class TwilioController {

	@GetMapping("/send-message")
	public void sendVoiceMessage() {
		MessageCreator creator = Message.creator(new PhoneNumber("+917989628448"), new PhoneNumber("+1 507 584 3579"),
				"Hello Baby");
		creator.create();
	}

	@PostMapping("/call")
	public void handleIncomingCall() throws URISyntaxException {
//        Dial dial = new Dial.Builder("+918985105931").build();
//        VoiceResponse response = new VoiceResponse.Builder().dial(dial).build();
//        System.out.println(response.toXml());
		Call.creator(new PhoneNumber("+917989628448"), new PhoneNumber("+918985105931"),
				new URI("http://demo.twilio.com/docs/voice.xml")).create();
	}

}
