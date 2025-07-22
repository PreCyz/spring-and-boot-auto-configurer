package pawg.graphql.users;

import graphql.ErrorClassification;
import graphql.GraphQLError;
import graphql.language.SourceLocation;
import java.util.ArrayList;
import java.util.List;

public class UserNotFoundException extends RuntimeException implements GraphQLError {
    private final String message;
    private final List<SourceLocation> locations;
    private final String errorType;

    public UserNotFoundException(String message, List<SourceLocation> locations, String errorType) {
        this.message = message;
        this.locations = locations;
        this.errorType = errorType;
    }

    @Override
    public String getMessage() {
        return message;
    }

    @Override
    public List<SourceLocation> getLocations() {
        return new ArrayList<>(locations);
    }

    @Override
    public ErrorClassification getErrorType() {
        return ErrorClassification.errorClassification(errorType);
    }
}
