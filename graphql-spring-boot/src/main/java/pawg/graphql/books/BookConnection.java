package pawg.graphql.books;

import java.util.List;
import lombok.Data;

@Data
public class BookConnection {
    private final List<BookEdge> edges;
    private final BookPageInfo bookPageInfo;
}
