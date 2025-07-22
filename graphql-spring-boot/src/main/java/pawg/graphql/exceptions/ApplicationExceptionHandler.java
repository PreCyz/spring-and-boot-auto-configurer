package pawg.graphql.exceptions;

import graphql.GraphQLError;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import pawg.graphql.books.BookNotFoundException;
import pawg.graphql.users.UserNotFoundException;

@ControllerAdvice(annotations = RestController.class)
public class ApplicationExceptionHandler {

    @ExceptionHandler(BookNotFoundException.class)
    public GraphQLError handleBookNotFoundException(BookNotFoundException e) {
        return e;
    }

    @ExceptionHandler(UserNotFoundException.class)
    public GraphQLError handleUserNotFoundException(UserNotFoundException e) {
        return e;
    }
}
