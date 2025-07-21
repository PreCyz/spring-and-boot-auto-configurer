package pawg.graphql.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import pawg.graphql.books.BookDTO2;
import pawg.graphql.books.BookEntity;

@Mapper
public interface BookMapper2 {
    BookMapper2 INSTANCE = Mappers.getMapper(BookMapper2.class);

    @Mapping(source = "id", target = "dtoId")
    @Mapping(source = "title", target = "dtoTitle")
    @Mapping(source = "author", target = "dtoAuthor")
    @Mapping(source = "publicationYear", target = "dtoPublicationYear")
    BookDTO2 bookEntityToBookDTO(BookEntity bookEntity);
}
