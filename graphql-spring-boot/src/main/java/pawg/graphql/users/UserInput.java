package pawg.graphql.users;

import lombok.Data;

@Data
public class UserInput {
    private final String nickname;
    private final String email;
}
