package pawg.graphql.books;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor(onConstructor_ = {@Autowired})
public class BookService {

    private final BookRepository bookRepository;

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

    public BookEntity createBook(BookEntity book) {
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

    public boolean bookExistsByIdGreaterThan(Long id) {
        return bookRepository.existsByIdGreaterThan(id);
    }

    public List<BookEntity> createBooks(List<BookEntity> books) {
        return bookRepository.saveAll(books);
    }

    public List<BookEntity> findAllPaginated(PageRequest pageRequest) {
        return bookRepository.findAll(pageRequest).stream().toList();
    }

    public List<BookEntity> getBooks(Long cursor, int limit) {
        if (cursor != null) {
            return findByIdGreaterThanOrderByIdAsc(cursor, PageRequest.of(0, limit));
        } else {
            return findAllByOrderByIdAsc(PageRequest.of(0, limit));
        }
    }

    private List<BookEntity> findByIdGreaterThanOrderByIdAsc(Long cursor, PageRequest of) {
        return bookRepository.findByIdGreaterThanOrderByIdAsc(cursor, of);
    }

    private List<BookEntity> findAllByOrderByIdAsc(PageRequest of) {
        return bookRepository.findAllByOrderByIdAsc(of);
    }
}

