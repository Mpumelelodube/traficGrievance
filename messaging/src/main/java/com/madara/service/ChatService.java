package com.madara.service;

import com.madara.model.Chat;
import com.madara.repository.ChatRepository;
import org.springframework.stereotype.Service;

@Service
public class ChatService extends IService<Chat, ChatRepository>{
    public ChatService(ChatRepository repository) {
        super(repository);
    }
}
