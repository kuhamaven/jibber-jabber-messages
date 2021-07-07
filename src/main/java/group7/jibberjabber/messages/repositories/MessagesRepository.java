package group7.jibberjabber.messages.repositories;

import group7.jibberjabber.messages.models.Message;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface MessagesRepository extends PagingAndSortingRepository<Message,String> {
}
