package group7.jibberjabber.messages.dtos;

import group7.jibberjabber.messages.models.Conversation;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ConversationDto {
    private String senderId;

    private String recipientId;

    private List<ResponseMessageDto> messages;

    public static ConversationDto toDto(Conversation conversation){
        return new ConversationDto(conversation.getSenderId(), conversation.getRecipientId(), conversation.getMessages().stream().map(ResponseMessageDto::toDto).collect(Collectors.toList()));
    }
}
