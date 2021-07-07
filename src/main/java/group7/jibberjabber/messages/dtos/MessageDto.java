package group7.jibberjabber.messages.dtos;

import group7.jibberjabber.messages.models.Message;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MessageDto {
    private String senderId;

    private String recipientId;

    private String body;

    public static MessageDto toDto(Message message){
        return new MessageDto(message.getSenderId(), message.getRecipientId(), message.getBody());
    }
}
