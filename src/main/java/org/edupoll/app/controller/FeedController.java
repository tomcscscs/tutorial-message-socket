package org.edupoll.app.controller;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.UUID;

import org.edupoll.app.config.support.CustomWebSocketHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/feed")
@RequiredArgsConstructor
public class FeedController {
	
	private final CustomWebSocketHandler customWebSocketHandler;
	
	
	@GetMapping("/write")
	public String proceedWriteFeed() throws Exception {
		// ......
		
		Map<String, Object> message = new LinkedHashMap<>();
		message.put("type", "newFeed");
		message.put("feedId", UUID.randomUUID().toString().split("-")[0]);
		message.put("title", "웹소켓에 관하여..");
		customWebSocketHandler.sendMessageToAll(message);
		
		return "feed/write-success";
	}
}
