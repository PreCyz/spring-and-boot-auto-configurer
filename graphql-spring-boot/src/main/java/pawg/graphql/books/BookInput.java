package pawg.graphql.books;

import lombok.Data;

@Data
public class BookInput {
    private String title;
    private String author;
    private Integer publicationYear;
}

