package censusanalyser;

public class CSVBuilderException extends Exception {
    enum ExceptionType {
        PROBLEM_IN_READING_FILE
    }
    ExceptionType type;
    public CSVBuilderException(ExceptionType type,String message) {
        super(message);
        this.type = type;
    }
}
