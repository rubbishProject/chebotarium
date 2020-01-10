package ink.chebotarium.api.user.repository;

import ink.chebotarium.api.user.model.User;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
public interface UserRepository extends ReactiveMongoRepository<User, String> {

    Mono<User> findById(long id);
    Mono<User> findByUsername(String username);
}
