package pawg.graphql.mappers;

import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import pawg.graphql.users.UserEntity;
import pawg.graphql.users.UserInput;

@Mapper
public interface UserInputMapper {
    UserInputMapper INSTANCE = Mappers.getMapper(UserInputMapper.class);

    UserEntity userInputToUserEntity(UserInput userInput);
    List<UserEntity> userInputsToUserEntities(List<UserInput> userInputs);
}
