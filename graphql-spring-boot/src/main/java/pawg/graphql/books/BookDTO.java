package pawg.graphql.books;

import lombok.Data;

@Data
public class BookDTO {
    private Long dtoId;
    private String dtoTitle;
    private String dtoAuthor;
    private String dtoPublicationYear;
}
