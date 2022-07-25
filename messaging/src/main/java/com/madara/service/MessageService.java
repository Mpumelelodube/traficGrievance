package com.madara.service;

import com.madara.model.Message;
import com.madara.repository.MessageRepository;
import org.springframework.stereotype.Service;

@Service
public class MessageService extends IService<Message, MessageRepository>{
    public MessageService(MessageRepository repository) {
        super(repository);
    }
}
