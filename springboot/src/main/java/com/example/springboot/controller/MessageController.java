package com.example.springboot.controller;

import com.example.springboot.common.WebSocketHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.Map;

@RestController
public class MessageController {

    @Resource
    private WebSocketHandler webSocketHandler;

    @PostMapping("/send-message")
    public void sendMessage(@RequestBody String message) throws IOException {
        TextMessage textMessage = new TextMessage(message);
        for (WebSocketSession session : webSocketHandler.sessions) {
            session.sendMessage(textMessage);
        }
    }

//    @PostMapping("/send-message/{seatId}")
//    public void reMessage(@PathVariable int seatId, @RequestBody String message) throws IOException {
//        for (Map.Entry<WebSocketSession, Seat> entry : webSocketHandler.sessions.entrySet()) {
//            WebSocketSession session = entry.getKey();
//            Seat seat = entry.getValue();
//            if (seat.getId() == seatId) {
//                seat.setHasMessage(true);
//                session.sendMessage(new TextMessage(message));
//            }
//        }
//    }
}
