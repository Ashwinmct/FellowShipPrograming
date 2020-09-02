package com.modeanalyser;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class ModeAnalyserTest {
@Rule
    public ExpectedException thrown=ExpectedException.none();
    @Test
    public void should_return_SAD_if_message_contains_sad(){
        MoodAnalyser moodAnalyser=new MoodAnalyser("I am in sad mood");
        String mood_status=moodAnalyser.analyseMood();
        Assert.assertEquals("SAD", mood_status);
    }
    @Test
    public void should_return_HAPPY_if_message_not_contains_sad(){
        MoodAnalyser moodAnalyser=new MoodAnalyser("I am in any mood");
        String mood_status=moodAnalyser.analyseMood();
        Assert.assertEquals("HAPPY", mood_status);
    }
    @Test
    public void should_return_HAPPY_if_input_is_null() {
        MoodAnalyser moodAnalyser=new MoodAnalyser("I am in any mood");
        String mood_status=moodAnalyser.analyseMood();
        Assert.assertEquals("HAPPY", mood_status);
    }
    @Test
    public void should_throw_MoodAnalysisException_if_input_is_empty() {
        MoodAnalyser moodAnalyser = new MoodAnalyser();
        try {
            String mood_status = moodAnalyser.analyseMoodagain();
        } catch (MoodAnalysisException e) {
            Assert.assertEquals(MoodAnalysisException.ExceptionType.ENTERED_EMPTY,e.type);
        }
    }
    @Test
    public void should_throw_MoodAnalysisException_if_input_is_null(){
        MoodAnalyser moodAnalyser=new MoodAnalyser(null);
        try {
            moodAnalyser.analyseMoodagain();
            }catch (MoodAnalysisException e){
             Assert.assertEquals(MoodAnalysisException.ExceptionType.ENTERED_NULL,e.type);
            }

    }

}

