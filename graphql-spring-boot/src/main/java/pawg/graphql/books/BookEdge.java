package pawg.graphql.books;

import lombok.Data;

@Data
public class BookEdge {
    private final BookEntity node;
    private final String cursor;
}
