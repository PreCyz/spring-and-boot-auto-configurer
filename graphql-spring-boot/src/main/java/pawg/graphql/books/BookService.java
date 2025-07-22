package pawg.graphql.books;

import java.util.List;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import pawg.graphql.mappers.BookInputMapper;

@Service
public class BookService {

    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
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
        return bookRepository.save(BookInputMapper.INSTANCE.bookInputToBookEntity(bookInput));
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

    public List<BookEntity> findByIdGreaterThanOrderByIdAsc(Long cursor, PageRequest of) {
        return bookRepository.findByIdGreaterThanOrderByIdAsc(cursor, of);
    }

    public List<BookEntity> findAllByOrderByIdAsc(PageRequest of) {
        return bookRepository.findAllByOrderByIdAsc(of);
    }

    public boolean existsByIdGreaterThan(Long id) {
        return bookRepository.existsByIdGreaterThan(id);
    }

    public List<BookEntity> createBooks(List<BookInput> bookInputs) {
        return bookRepository.saveAll(BookInputMapper.INSTANCE.bookInputsToBookEntities(bookInputs));
    }

    public List<BookEntity> findAllPaginated(PageRequest pageRequest) {
        return bookRepository.findAll(pageRequest).stream().toList();
    }
}

