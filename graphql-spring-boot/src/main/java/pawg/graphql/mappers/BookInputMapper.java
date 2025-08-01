package pawg.graphql.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import pawg.graphql.books.BookEntity;
import pawg.graphql.books.BookInput;

import java.util.List;

@Mapper
public interface BookInputMapper {
    BookInputMapper INSTANCE = Mappers.getMapper(BookInputMapper.class);

    @Mapping(target = "id", ignore = true)
    BookEntity bookInputToBookEntity(BookInput bookInput);

    List<BookEntity> bookInputsToBookEntities(List<BookInput> bookInputs);
}
