package pawg.graphql.books;

import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;

@Controller
@RequiredArgsConstructor(onConstructor_ = {@Autowired})
public class BookResolver {

    private final BookService bookService;

    @QueryMapping(name = "findAllBooks")
    public List<BookEntity> findAllBooks() {
        return bookService.findAllBooks();
    }

    @SchemaMapping(typeName = "Query", field = "findBookById")
    public BookEntity findBookById(@Argument Long id) {
        return bookService.findBookById(id);
    }

    @MutationMapping
    public BookEntity createBook(@Argument BookInput bookInput) {
        return bookService.createBook(bookInput);
    }

    @MutationMapping
    public List<BookEntity> createBooks(@Argument List<BookInput> bookInputs) {
        return bookService.createBooks(bookInputs);
    }

    @MutationMapping
    public BookEntity updateBook(@Argument Long id, @Argument BookInput bookInput) {
        return bookService.updateBook(id, bookInput);
    }

    @MutationMapping
    public Boolean deleteBook(@Argument Long id) {
        return bookService.deleteBook(id);
    }

    @QueryMapping
    public List<BookEntity> fetchBooks(@Argument int pageSize, @Argument int pageNumber) {
        return bookService.findAllPaginated(PageRequest.of(pageNumber, pageSize));
    }

    @QueryMapping
    public BookConnection booksByCursor(@Argument Long cursor, @Argument int limit) {
        List<BookEntity> books;

        if (cursor != null) {
            books = bookService.findByIdGreaterThanOrderByIdAsc(cursor, PageRequest.of(0, limit));
        } else {
            books = bookService.findAllByOrderByIdAsc(PageRequest.of(0, limit));
        }

        List<BookEdge> edges = books.stream()
                                    .map(book -> new BookEdge(book, book.getId().toString()))
                                    .collect(Collectors.toList());

        Long id = books.getLast().getId();
        String endCursor = books.isEmpty() ? null : id.toString();
        boolean hasNextPage = !books.isEmpty() && bookService.existsByIdGreaterThan(id);

        BookPageInfo bookPageInfo = new BookPageInfo(hasNextPage, endCursor);

        return new BookConnection(edges, bookPageInfo);
    }
}

