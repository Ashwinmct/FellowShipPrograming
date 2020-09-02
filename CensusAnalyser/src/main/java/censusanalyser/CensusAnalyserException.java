package censusanalyser;

public class CensusAnalyserException extends Exception {
    public enum ExceptionType {
        WRONG_FILE_PATH,
        PROBLEM_IN_READING_FILE,
        NO_DATA_FOUND,
        INVALID_COUNTRY
    }
    public ExceptionType type;
    public CensusAnalyserException( ExceptionType type,String message) {
        super(message);
        this.type = type;
    }
    public CensusAnalyserException( String name,String message) {
        super(message);
        this.type = ExceptionType.valueOf(name);
    }
}
