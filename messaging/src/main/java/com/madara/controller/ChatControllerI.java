package com.madara.controller;

import com.madara.model.Chat;
import com.madara.service.ChatService;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/v1/chat")
public class ChatControllerI {
    private final ChatService chatService;

    public ChatControllerI(ChatService chatService) {
        this.chatService = chatService;
    }

    @PostMapping("/create")
    public Chat createChat(@RequestBody Chat chat){
        return chatService.save(chat);
    }

    @GetMapping("/get-chat/{id}")
    public Optional<Chat> getChat(@PathVariable Long id){
        return chatService.findOne(id);
    }
}
