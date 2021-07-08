package group7.jibberjabber.messages.dtos;

import group7.jibberjabber.messages.models.Message;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseMessageDto {
    private String senderId;

//    private String recipientId;

    private String body;

    private String time;

    public static ResponseMessageDto toDto(Message message){
        return new ResponseMessageDto(message.getSenderId(), message.getBody(), message.getTime().format(DateTimeFormatter.ofPattern("HH:mm dd/MM/yyyy")));
    }
}