package com.hobby.stomp.controller;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;

/**
 * @author Harris
 */
public class StompController {

    @MessageMapping("/message")
    @SendTo("/topic/message")
    public String messageToCurrentUser(){
        return "message to current user";
    }
}
