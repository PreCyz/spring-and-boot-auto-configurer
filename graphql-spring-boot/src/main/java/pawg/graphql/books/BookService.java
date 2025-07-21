package pawg.graphql.books;

import java.util.List;
import org.springframework.stereotype.Service;
import pawg.graphql.mappers.BookMapper;
import pawg.graphql.mappers.BookMapper2;

@Service
public class BookService {

    private final BookRepository bookRepository;
    private final BookMapper bookMapper;
    private final BookMapper2 bookMapper2;

    public BookService(BookRepository bookRepository, BookMapper bookMapper, BookMapper2 bookMapper2) {
        this.bookRepository = bookRepository;
        this.bookMapper = bookMapper;
        this.bookMapper2 = bookMapper2;
    }

    public List<BookEntity> findAllBooks() {
        return bookRepository.findAll();
    }

    public BookEntity findBookById(Long id) {
        return bookRepository.findById(id)
                             .orElseThrow(() -> new BookNotFoundException(
                                     "Book with ID %s not found".formatted(id),
                                     List.of(),
                                     "findBookById"
                             ));
    }

    public BookEntity createBook(BookInput bookInput) {
        BookEntity book = new BookEntity();
        book.setTitle(bookInput.getTitle());
        book.setAuthor(bookInput.getAuthor());
        book.setPublicationYear(bookInput.getPublicationYear());
        return bookRepository.save(book);
    }

    public BookEntity updateBook(Long id, BookInput bookInput) {
        return bookRepository.findById(id)
                             .map(existingBook -> {
                                 existingBook.setTitle(bookInput.getTitle());
                                 existingBook.setAuthor(bookInput.getAuthor());
                                 existingBook.setPublicationYear(bookInput.getPublicationYear());
                                 return bookRepository.save(existingBook);
                             })
                             .orElseThrow(() -> new BookNotFoundException(
                                     "Book with ID %s not found".formatted(id),
                                     List.of(),
                                     "findBookById"
                             ));
    }

    public Boolean deleteBook(Long id) {
        if (bookRepository.existsById(id)) {
            bookRepository.deleteById(id);
            return true;
        }
        throw new BookNotFoundException(
                "Book with ID %s not found".formatted(id),
                List.of(),
                "findBookById"
        );
    }
}

