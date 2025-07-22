package pawg.graphql.books;

import java.util.List;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<BookEntity, Long> {
    List<BookEntity> findByIdGreaterThanOrderByIdAsc(Long id, Pageable pageable);
    List<BookEntity> findAllByOrderByIdAsc(Pageable pageable);
    boolean existsByIdGreaterThan(Long id);
}

