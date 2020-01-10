package ink.chebotarium.api.user.service;

import ink.chebotarium.api.user.model.User;
import ink.chebotarium.api.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.regex.Pattern;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserServiceImp {

    /*Возможно понадобится*/
    // RFC 5322 email pattern
    private static final String EMAIL_REGEX = "^[a-zA-Z0-9_!#$%&’*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$";
    public static final Pattern emailPattern = Pattern.compile(EMAIL_REGEX);
    public static final Pattern phoneMatcher = Pattern.compile("");

    private final UserRepository userRepository;

    Mono<User> findById(final long id){
        return userRepository.findById(id);
    }
}
