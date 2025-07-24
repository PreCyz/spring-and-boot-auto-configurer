package pawg.graphql.books;

import java.util.List;

public record BookConnection(List<BookEdge> edges, BookPageInfo bookPageInfo) { }
