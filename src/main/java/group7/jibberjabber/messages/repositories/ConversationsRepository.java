package group7.jibberjabber.messages.repositories;

import group7.jibberjabber.messages.models.Conversation;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.Optional;

public interface ConversationsRepository extends PagingAndSortingRepository<Conversation,String> {

    Optional<Conversation> findBySenderIdAndRecipientId(String senderId, String recipientId);
}
