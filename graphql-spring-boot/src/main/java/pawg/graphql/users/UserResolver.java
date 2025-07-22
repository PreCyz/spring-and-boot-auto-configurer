package pawg.graphql.users;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

@Controller
@RequiredArgsConstructor(onConstructor_ = {@Autowired})
public class UserResolver {
    private final UserService userService;

    @QueryMapping
    public List<UserEntity> findAllUsers() {
        return userService.findAll();
    }

    @QueryMapping
    public UserEntity findUserById(@Argument Long id) {
        return userService.findById(id);
    }

    @MutationMapping
    public List<UserEntity> createUsers(@Argument List<UserInput> userInputs) {
        return userService.createUsers(userInputs);
    }
}
