package group7.jibberjabber.messages.models;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
public class Conversation {
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid")
    @Column(nullable = false)
    private String id;

    private String senderId;

    private String recipientId;

    @OneToMany(mappedBy = "conversation", fetch = FetchType.EAGER)
    private List<Message> messages = new ArrayList<>();

    public Conversation(String senderId, String recipientId){
        this.senderId = senderId;
        this.recipientId = recipientId;
    }

    public void addMessage(Message message) {
        messages.add(message);
    }
}