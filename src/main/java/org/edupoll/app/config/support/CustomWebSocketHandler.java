package org.edupoll.app.config.support;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.annotation.PostConstruct;

@Component
public class CustomWebSocketHandler extends TextWebSocketHandler {
	private List<WebSocketSession> sessions;

	@PostConstruct
	public void init() {
		sessions = new ArrayList<>();
	}

	@Override
	public void afterConnectionEstablished(WebSocketSession session) throws Exception {
		sessions.add(session);
	}

	@Override
	public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
		sessions.remove(session);
	}

	@Deprecated
	public void sendMessageToAll(String message) throws Exception {
		for (var session : sessions) {
			session.sendMessage(new TextMessage(message));
		}
	}
	
	
	public void sendMessageToAll(Map<String, Object> message) throws Exception {
		ObjectMapper mapper = new ObjectMapper();
		for (var session : sessions) {
			session.sendMessage(new TextMessage(mapper.writeValueAsString(message)));
		}
	}
}





