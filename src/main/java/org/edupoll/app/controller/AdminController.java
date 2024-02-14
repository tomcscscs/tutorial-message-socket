package org.edupoll.app.controller;

import org.edupoll.app.config.support.CustomWebSocketHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
@RequestMapping("/admin")
public class AdminController {
	private final CustomWebSocketHandler customWebSocketHandler;
	
	
	@GetMapping("/notice")
	public String proceedAddNotice() throws Exception {
		// ....
		
		customWebSocketHandler.sendMessageToAll("newNotice");
		
		return "return:/admin/index";
		
	}
}
