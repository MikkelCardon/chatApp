package com.ChatApp.controllers;

import com.ChatApp.models.Message;
import com.ChatApp.models.MessageResponseDto;
import com.ChatApp.models.Room;
import com.ChatApp.models.repository.MessageRepository;
import com.ChatApp.models.repository.RoomRepository;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.stereotype.Controller;

import java.util.NoSuchElementException;

@Controller
public class ChatController {
    private final RoomRepository roomRepository;
    private final MessageRepository messageRepository;

    public ChatController(RoomRepository roomRepository, MessageRepository messageRepository) {
        this.roomRepository = roomRepository;
        this.messageRepository = messageRepository;
    }

    @MessageMapping("/sendMessage/{roomId}")
    @SendTo("/topic/messages/{roomId}")
    public MessageResponseDto sendMessage(String message,
                                          @DestinationVariable String roomId,
                                          SimpMessageHeaderAccessor headerAccessor) {
        System.out.println("message = " + message);

        String username = headerAccessor.getFirstNativeHeader("username");
        System.out.println(username);

        Message newMessage = new Message();
        newMessage.setMessage(message);

        System.out.println(roomId);
        Room room = roomRepository.findById(roomId).orElseThrow(() -> new NoSuchElementException());
        newMessage.setRoomId(room);
        messageRepository.save(newMessage);

        return  new MessageResponseDto(newMessage.getMessage(), username);// broadcast message to all subscribers
    }
}

