package group7.jibberjabber.messages.controllers;

import group7.jibberjabber.messages.dtos.ConversationDto;
import group7.jibberjabber.messages.dtos.MessageDto;
import group7.jibberjabber.messages.dtos.ResponseMessageDto;
import group7.jibberjabber.messages.services.ConversationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/conversation")
public class ConversationController {

    private final ConversationService conversationService;

    @Autowired
    public ConversationController(ConversationService conversationService) {
        this.conversationService = conversationService;
    }

    @MessageMapping()
    @SendTo("/topic/messages")
    public List<ResponseMessageDto> processMessage(@Payload MessageDto messageDto) {
        return conversationService.addMessage(messageDto);
    }

    @GetMapping("/{senderId}/{recipientId}")
    public ConversationDto findConversation(@PathVariable String senderId, @PathVariable String recipientId) {
        return conversationService.getConversation(senderId, recipientId);
    }

}
