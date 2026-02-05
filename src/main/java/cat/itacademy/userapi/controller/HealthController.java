package cat.itacademy.userapi.controller;

import cat.itacademy.userapi.model.Message;
import cat.itacademy.userapi.service.MessageService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HealthController {
    private final MessageService service;

    public HealthController(MessageService service) {
        this.service = service;
    }

    @GetMapping("/health")
    public Message getMessage() {
        return service.getMessage("ok");
    }
}
