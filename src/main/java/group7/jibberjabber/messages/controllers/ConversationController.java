package group7.jibberjabber.messages.controllers;

import group7.jibberjabber.messages.dtos.MessageDto;
import group7.jibberjabber.messages.models.Message;
import group7.jibberjabber.messages.services.ConversationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/conversation")
public class ConversationController {

    private final ConversationService conversationService;

    public ConversationController(ConversationService conversationService) {
        this.conversationService = conversationService;
    }

    @Autowired


    @MessageMapping()
    @SendTo("/queue/messages")
    public Message processMessage(@Payload MessageDto messageDto) {
        return conversationService.addMessage(messageDto);
    }

    @GetMapping("/{senderId}/{recipientId}/messages")
    public List<Message> findConversationMessages(@PathVariable String senderId, @PathVariable String recipientId) {
        return conversationService.getConversationMessages(senderId, recipientId);
    }

}
