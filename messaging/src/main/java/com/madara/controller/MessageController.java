package com.madara.controller;

import com.madara.model.Message;
import com.madara.service.MessageService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/message")
public class MessageController {
    private final MessageService messageService;

    public MessageController(MessageService messageService) {
        this.messageService = messageService;
    }

    @PostMapping("/create-message")
    public Message saveMessage(@RequestBody Message message){
        return messageService.save(message);
    }
}
