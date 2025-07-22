package pawg.graphql.mappers;

import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import pawg.graphql.books.BookEntity;
import pawg.graphql.books.BookInput;

@Mapper
public interface BookInputMapper {
    BookInputMapper INSTANCE = Mappers.getMapper(BookInputMapper.class);

    BookEntity bookInputToBookEntity(BookInput bookInput);
    List<BookEntity> bookInputsToBookEntities(List<BookInput> bookInputs);
}
