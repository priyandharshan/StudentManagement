package com.example.messagesocket;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.util.HtmlUtils;

@Controller
public class GreetingsController {


	  @MessageMapping("/chat")
	  @SendTo("/topic/greetings")
	
	public Greetings greetings(HelloMessage message) throws InterruptedException
	{
		  Thread.sleep(1000);
		
		return new Greetings("Hello"+message.getName() + "!");
	}
}
