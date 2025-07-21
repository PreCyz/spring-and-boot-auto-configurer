package pawg.graphql.exceptions;

import graphql.GraphQLError;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import pawg.graphql.books.BookNotFoundException;

@ControllerAdvice(annotations = RestController.class)
public class ApplicationExceptionHandler {

    @ExceptionHandler(BookNotFoundException.class)
    public GraphQLError handleCustomException(BookNotFoundException e) {
        return e;
    }
}
