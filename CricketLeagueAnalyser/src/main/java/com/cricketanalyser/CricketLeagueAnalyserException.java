package com.cricketanalyser;

public class CricketLeagueAnalyserException extends Exception {

    public enum ExceptionType{
        NO_DATA_FOUND,
        PROBLEM_IN_READING_FILE,
        INVALID_AMOUNT_OF_FILES,
        WRONG_FILE_PATH,
        INVALID_FILE_TYPE,
        INVALID_POSITION_OF_PLAYER, FILE_CONTAINS_INVALID_DATA
    }
    public ExceptionType exceptionType;
    public CricketLeagueAnalyserException(ExceptionType type,String message) {
        super(message);
        exceptionType=type;
    }

}
