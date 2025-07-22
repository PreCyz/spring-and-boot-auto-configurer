package pawg.graphql.books;

import java.util.List;
import lombok.Data;
import org.springframework.data.domain.Page;

@Data
public class BookPage {
    private List<BookEntity> content;
    private int totalPages;
    private long totalElements;
    private int number;
    private int size;

    public BookPage(Page<BookEntity> page) {
        this.content = page.getContent();
        this.totalPages = page.getTotalPages();
        this.totalElements = page.getTotalElements();
        this.number = page.getNumber();
        this.size = page.getSize();
    }
}
