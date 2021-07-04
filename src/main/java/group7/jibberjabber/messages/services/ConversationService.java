package group7.jibberjabber.messages.services;

import group7.jibberjabber.messages.dtos.MessageDto;
import group7.jibberjabber.messages.models.Conversation;
import group7.jibberjabber.messages.models.Message;
import group7.jibberjabber.messages.repositories.ConversationsRepository;
import group7.jibberjabber.messages.repositories.MessagesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ConversationService {
    private ConversationsRepository conversationsRepository;
    private MessagesRepository messagesRepository;

    @Autowired
    public ConversationService(ConversationsRepository conversationsRepository, MessagesRepository messagesRepository) {
        this.conversationsRepository = conversationsRepository;
        this.messagesRepository = messagesRepository;
    }

    public Message addMessage(MessageDto messageDto){
        Conversation conversation;
        Optional<Conversation> optional = findConversation(messageDto.getSenderId(), messageDto.getRecipientId());
        if (optional.isEmpty()) conversation = conversationsRepository.save(new Conversation(messageDto.getSenderId(),messageDto.getRecipientId()));
        else conversation = optional.get();

        Message message = dtoToMessage(messageDto);
        conversation.addMessage(message);
        message.setConversation(conversation);
        conversationsRepository.save(conversation);
        return message;
    }

    private Optional<Conversation> findConversation(String senderId, String recipientId){
        Optional<Conversation> optional = conversationsRepository.findBySenderIdAndRecipientId(senderId, recipientId);
        if(optional.isPresent()) return optional;
        else {
            return conversationsRepository.findBySenderIdAndRecipientId(recipientId, senderId);
        }
    }

    private Message dtoToMessage(MessageDto messageDto){
        Message message = new Message();
        message.setBody(messageDto.getBody());
        message.setSenderId(messageDto.getSenderId());
        message.setRecipientId(messageDto.getRecipientId());
        return message;
    }

    public List<Message> getConversationMessages(String senderId, String recipientId){
        Optional<Conversation> conversation = findConversation(senderId,recipientId);
        if(conversation.isPresent()){
            List<Message> messages = conversation.get().getMessages();
            messages.sort(Comparator.comparing(Message::getTime).reversed());
            return messages;
        }
        return new ArrayList<Message>();
    }


}

