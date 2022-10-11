package com.example.messagesocket;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

@EnableScheduling
@Configuration
public class SchedularConfig {
	@Autowired
	SimpMessagingTemplate template;
	
	@Scheduled(fixedDelay=3000)
	public void sendMessage()
	{
		template.convertAndSend("topic/chat",new HelloMessage("fixed rating"));
	}


}