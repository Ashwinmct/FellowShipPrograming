package com.modeanalyser;

public class MoodAnalyser {
    private String message;
    public MoodAnalyser(){
        this.message="";
    }

    public MoodAnalyser(String message){
        this.message=message;
    }

    public String analyseMood()  {
        try {
            return ((message.toLowerCase()).contains("sad")) ? "SAD" : "HAPPY";
        }catch (NullPointerException e){
            return "Happy";
        }
    }

    public String analyseMoodagain() throws MoodAnalysisException {
        try {
            if (message.length() == 0)
                throw new MoodAnalysisException(MoodAnalysisException.ExceptionType.ENTERED_EMPTY, "Please enter proper mood");
            return ((message.toLowerCase()).contains("sad")) ? "SAD" : "HAPPY";
        }catch (NullPointerException e){
            throw new MoodAnalysisException(MoodAnalysisException.ExceptionType.ENTERED_NULL,"Please enter proper mood");
        }
    }
}
