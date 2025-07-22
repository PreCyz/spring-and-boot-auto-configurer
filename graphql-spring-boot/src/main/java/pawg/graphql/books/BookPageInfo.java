package pawg.graphql.books;

import lombok.Data;

@Data
public class BookPageInfo {
    private final boolean hasNextPage;
    private final String endCursor;
}
