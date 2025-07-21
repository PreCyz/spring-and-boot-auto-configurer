package pawg.graphql.books;

import java.util.List;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

@Controller
public class BookResolver {

    private final BookService bookService;

    public BookResolver(BookService bookService) {
        this.bookService = bookService;
    }

    @QueryMapping
    public List<BookEntity> findAllBooks() {
        return bookService.findAllBooks();
    }

    @QueryMapping
    public BookEntity findBookById(@Argument Long id) {
        return bookService.findBookById(id);
    }

    @MutationMapping
    public BookEntity createBook(@Argument BookInput bookInput) {
        return bookService.createBook(bookInput);
    }

    @MutationMapping
    public BookEntity updateBook(@Argument Long id, @Argument BookInput bookInput) {
        return bookService.updateBook(id, bookInput);
    }

    @MutationMapping
    public Boolean deleteBook(@Argument Long id) {
        return bookService.deleteBook(id);
    }
}

