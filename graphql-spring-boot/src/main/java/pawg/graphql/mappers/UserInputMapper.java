package pawg.graphql.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import pawg.graphql.users.UserEntity;
import pawg.graphql.users.UserInput;

import java.util.List;

@Mapper
public interface UserInputMapper {
    UserInputMapper INSTANCE = Mappers.getMapper(UserInputMapper.class);

    @Mapping(target = "id", ignore = true)
    UserEntity userInputToUserEntity(UserInput userInput);

    List<UserEntity> userInputsToUserEntities(List<UserInput> userInputs);
}
