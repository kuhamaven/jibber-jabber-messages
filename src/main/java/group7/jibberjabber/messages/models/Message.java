package group7.jibberjabber.messages.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Message {
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid")
    @Column(nullable = false)
    private String id;

    private String senderId;

    private String recipientId;

    private String body;

    @CreationTimestamp
    private LocalDateTime time;

    @ManyToOne
    private Conversation conversation;
}
