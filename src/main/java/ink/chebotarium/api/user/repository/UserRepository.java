package ink.chebotarium.api.user.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import ink.chebotarium.api.user.model.User;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
public interface UserRepository extends MongoRepository<User, String> {

    Mono<User> findById(long id);
}
