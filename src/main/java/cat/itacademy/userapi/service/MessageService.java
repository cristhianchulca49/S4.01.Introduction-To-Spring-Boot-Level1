package cat.itacademy.userapi.service;

import cat.itacademy.userapi.model.Message;
import org.springframework.stereotype.Service;

@Service
public class MessageService {
    public Message getMessage(String status) {
        return new Message(status);
    }
}
