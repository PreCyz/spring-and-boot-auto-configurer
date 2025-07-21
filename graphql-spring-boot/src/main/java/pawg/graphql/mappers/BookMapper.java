package pawg.graphql.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import pawg.graphql.books.BookDTO;
import pawg.graphql.books.BookEntity;

@Mapper(componentModel = "spring")
public interface BookMapper {
    BookMapper INSTANCE = Mappers.getMapper(BookMapper.class);

    @Mapping(source = "id", target = "dtoId")
    @Mapping(source = "title", target = "dtoTitle")
    @Mapping(source = "author", target = "dtoAuthor")
    @Mapping(source = "publicationYear", target = "dtoPublicationYear")
    BookDTO bookEntityToBookDTO(BookEntity bookEntity);
}
