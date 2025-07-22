package pawg.graphql.users;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor(onConstructor_ = {@Autowired})
public class UserService {
    private final UserRepository userRepository;

    public List<UserEntity> findAll() {
        return userRepository.findAll();
    }

    public UserEntity findById(Long id) {
        return userRepository.findById(id).orElseThrow(() -> new UserNotFoundException(
                "User with id %d not found".formatted(id),
                List.of(),
                "findById"
        ));
    }
}
