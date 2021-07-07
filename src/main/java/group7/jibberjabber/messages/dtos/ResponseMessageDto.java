package group7.jibberjabber.messages.dtos;

import group7.jibberjabber.messages.models.Message;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseMessageDto {
    private String senderId;

//    private String recipientId;

    private String body;

    private LocalDateTime time;

    public static ResponseMessageDto toDto(Message message){
        return new ResponseMessageDto(message.getSenderId(), message.getBody(), message.getTime());
    }
}