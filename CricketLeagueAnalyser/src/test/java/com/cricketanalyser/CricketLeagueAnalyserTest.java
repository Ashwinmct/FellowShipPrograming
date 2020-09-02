package com.cricketanalyser;

import org.junit.Assert;
import org.junit.Test;

public class CricketLeagueAnalyserTest {
    private static final String IPL_BATSMEN_DETAILS_SHEET_FILE_PATH ="./src/test/resources/IPL2019FactsheetMostRuns.csv";
    private static final String WRONG_IPL_BATSMEN_DETAILS_SHEET_FILE_PATH ="./src/main/resources/IPL2019FactsheetMostRuns.csv" ;
    private static final String EMPTY_IPL_BATSMEN_DETAILS_SHEET_FILE_PATH ="./src/test/resources/emptyMostRuns.csv";
    private static final String IPL_BOWLERS_DETAILS_SHEET_FILE_PATH = "./src/test/resources/IPL2019FactsheetMostWkts.csv";

    @Test
    public void givenIPLBatsMenDetailsFile_whenLoaded_shouldReturnNoOfEntriesInFileForLoading()  {
        try {
            CricketLeagueAnalyser cricketLeagueAnalyser=new CricketLeagueAnalyser(CricketLeagueAnalyser.AnalyserMode.BATTING,IPL_BATSMEN_DETAILS_SHEET_FILE_PATH);
            int numberOfRecords=cricketLeagueAnalyser.getNumberOfPlayers();
            Assert.assertEquals(100,numberOfRecords);
        } catch (CricketLeagueAnalyserException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void givenIPLBatsMenDetailsFile_withWrongPath_shouldThrowException(){
        try {
            new CricketLeagueAnalyser(CricketLeagueAnalyser.AnalyserMode.BATTING,WRONG_IPL_BATSMEN_DETAILS_SHEET_FILE_PATH);
        } catch (CricketLeagueAnalyserException e) {
            Assert.assertEquals(CricketLeagueAnalyserException.ExceptionType.WRONG_FILE_PATH,e.exceptionType);
        }
    }
    @Test
    public void givenIPLBatsMenDetailsFile_whenHasNoData_shouldThrowException() {
        try {
            CricketLeagueAnalyser cricketLeagueAnalyser=new CricketLeagueAnalyser(CricketLeagueAnalyser.AnalyserMode.BATTING,EMPTY_IPL_BATSMEN_DETAILS_SHEET_FILE_PATH);
            cricketLeagueAnalyser.sortPlayersDataBy();
        } catch (CricketLeagueAnalyserException e) {
            Assert.assertEquals(CricketLeagueAnalyserException.ExceptionType.NO_DATA_FOUND,e.exceptionType);
        }
    }
    @Test
    public void givenIPLBatsMenDetailsFile_whenSortedByBattingAverage_shouldReturnPlayerWithTopBattingAverage() {
        try {
            CricketLeagueAnalyser cricketLeagueAnalyser=new CricketLeagueAnalyser(CricketLeagueAnalyser.AnalyserMode.BATTING,IPL_BATSMEN_DETAILS_SHEET_FILE_PATH);
            cricketLeagueAnalyser.sortPlayersDataBy(CricketLeagueAnalyser.SortingOption.BattingAverage);
            String playerWithTopBattingAverage=cricketLeagueAnalyser.getTopPlayer();
            Assert.assertEquals("MS Dhoni",playerWithTopBattingAverage);
        } catch (CricketLeagueAnalyserException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void givenIPLBatsMenDetailsFile_whenSortedByBatsManStrikeRate_shouldReturnPlayerWithTopStrikingRate() {
        try {
            CricketLeagueAnalyser cricketLeagueAnalyser=new CricketLeagueAnalyser(CricketLeagueAnalyser.AnalyserMode.BATTING,IPL_BATSMEN_DETAILS_SHEET_FILE_PATH);
            cricketLeagueAnalyser.sortPlayersDataBy(CricketLeagueAnalyser.SortingOption.BattingStrikeRate);
            String playerWithTopStrikingRate=cricketLeagueAnalyser.getTopPlayer();
            Assert.assertEquals("Ishant Sharma",playerWithTopStrikingRate);
        } catch (CricketLeagueAnalyserException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void givenIPLBatsMenDetailsFile_whenSortedByBoundaries_shouldReturnPlayerWithMostNumberOfBoundaries() {
        try {
            CricketLeagueAnalyser cricketLeagueAnalyser=new CricketLeagueAnalyser(CricketLeagueAnalyser.AnalyserMode.BATTING,IPL_BATSMEN_DETAILS_SHEET_FILE_PATH);
            cricketLeagueAnalyser.sortPlayersDataBy(CricketLeagueAnalyser.SortingOption.Boundaries);
            String playerWithMostBoundaries=cricketLeagueAnalyser.getTopPlayer();
            Assert.assertEquals("Andre Russell",playerWithMostBoundaries);
        } catch (CricketLeagueAnalyserException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void givenIPLBatsMenDetailsFile_whenSortedByBoundariesAndBattingStrikeRate_shouldReturnPlayerWithMostNumberOfBoundariesAndBestStrikingRate() {
        try {
            CricketLeagueAnalyser cricketLeagueAnalyser=new CricketLeagueAnalyser(CricketLeagueAnalyser.AnalyserMode.BATTING,IPL_BATSMEN_DETAILS_SHEET_FILE_PATH);
            cricketLeagueAnalyser.sortPlayersDataBy(CricketLeagueAnalyser.SortingOption.boundariesAndBattingStrikingRate);
            String playerWithMostNumberOfBoundariesAndBestStrikingRate=cricketLeagueAnalyser.getTopPlayer();
            Assert.assertEquals("Ishant Sharma",playerWithMostNumberOfBoundariesAndBestStrikingRate);
        } catch (CricketLeagueAnalyserException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void givenIPLBatsMenDetailsFile_whenSortedByBattingAverageAndStrikingRate_shouldReturnPlayerWithBestAverageAndBestStrikingRate() {
        try {
            CricketLeagueAnalyser cricketLeagueAnalyser=new CricketLeagueAnalyser(CricketLeagueAnalyser.AnalyserMode.BATTING,IPL_BATSMEN_DETAILS_SHEET_FILE_PATH);
            cricketLeagueAnalyser.sortPlayersDataBy(CricketLeagueAnalyser.SortingOption.BattingAverageAndStrikingRate);
            String playerWithBestAverageAndBestStrikingRate=cricketLeagueAnalyser.getTopPlayer();
            Assert.assertEquals("Ishant Sharma",playerWithBestAverageAndBestStrikingRate);
        } catch (CricketLeagueAnalyserException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void givenIPLBatsMenDetailsFile_whenSortedByBattingAverageAndRun_shouldReturnPlayerWithBestAverageAndMostRuns() {
        try {
            CricketLeagueAnalyser cricketLeagueAnalyser=new CricketLeagueAnalyser(CricketLeagueAnalyser.AnalyserMode.BATTING,IPL_BATSMEN_DETAILS_SHEET_FILE_PATH);
            cricketLeagueAnalyser.sortPlayersDataBy(CricketLeagueAnalyser.SortingOption.BattingAverageAndMostRuns);
            String playerWithBestAverageAndMostRuns=cricketLeagueAnalyser.getTopPlayer();
            Assert.assertEquals("David Warner ",playerWithBestAverageAndMostRuns);
        } catch (CricketLeagueAnalyserException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void givenIPLBowlersDetailsFile_whenSortedByBowlingAverage_shouldReturnBowlerWithTopBowlingAverage() {
        try {
            CricketLeagueAnalyser cricketLeagueAnalyser=new CricketLeagueAnalyser(CricketLeagueAnalyser.AnalyserMode.BOWLING,IPL_BOWLERS_DETAILS_SHEET_FILE_PATH);
            cricketLeagueAnalyser.sortPlayersDataBy(CricketLeagueAnalyser.SortingOption.BowlingAverage);
            String playerWithTopBowlingAverage=cricketLeagueAnalyser.getTopPlayer();
            Assert.assertEquals("Krishnappa Gowtham",playerWithTopBowlingAverage);
        } catch (CricketLeagueAnalyserException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void givenIPLBowlersDetailsFile_whenSortedByBowlingStrikingRate_shouldReturnBowlerWithTopStrikingRate() {
        try {
            CricketLeagueAnalyser cricketLeagueAnalyser=new CricketLeagueAnalyser(CricketLeagueAnalyser.AnalyserMode.BOWLING,IPL_BOWLERS_DETAILS_SHEET_FILE_PATH);
            cricketLeagueAnalyser.sortPlayersDataBy(CricketLeagueAnalyser.SortingOption.BowlingStrikingRate);
            String bowlerWithTopStrikingRate=cricketLeagueAnalyser.getTopPlayer();
            Assert.assertEquals("Krishnappa Gowtham",bowlerWithTopStrikingRate);
        } catch (CricketLeagueAnalyserException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void givenIPLBowlersDetailsFile_whenSortedByBowlingEconomy_shouldReturnBowlerWithBestBowlingEconomy() {
        try {
            CricketLeagueAnalyser cricketLeagueAnalyser=new CricketLeagueAnalyser(CricketLeagueAnalyser.AnalyserMode.BOWLING,IPL_BOWLERS_DETAILS_SHEET_FILE_PATH);
            cricketLeagueAnalyser.sortPlayersDataBy(CricketLeagueAnalyser.SortingOption.BowlingEconomy);
            String bowlerWithBestBowlingEconomy=cricketLeagueAnalyser.getTopPlayer();
            Assert.assertEquals("Ben Cutting",bowlerWithBestBowlingEconomy);
        } catch (CricketLeagueAnalyserException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void givenIPLBowlersDetailsFile_whenSortedByBowlingStrikeRateAnd5wAnd5w_shouldReturnBowlerWithBestStrikingRateWith5wand4w() {
        try {
            CricketLeagueAnalyser cricketLeagueAnalyser=new CricketLeagueAnalyser(CricketLeagueAnalyser.AnalyserMode.BOWLING,IPL_BOWLERS_DETAILS_SHEET_FILE_PATH);
            cricketLeagueAnalyser.sortPlayersDataBy(CricketLeagueAnalyser.SortingOption.BowlingStrikeRateAnd4w5w);
            String bowlerWithBestStrikingRateWith5wand4w=cricketLeagueAnalyser.getTopPlayer();
            Assert.assertEquals("Krishnappa Gowtham",bowlerWithBestStrikingRateWith5wand4w);
        } catch (CricketLeagueAnalyserException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void givenIPLBowlersDetailsFile_whenSortedByBowlingAverageAndStrikingRate_shouldReturnBowlerWithBestStrikingRateAndBowlingAverage() {
        try {
            CricketLeagueAnalyser cricketLeagueAnalyser=new CricketLeagueAnalyser(CricketLeagueAnalyser.AnalyserMode.BOWLING,IPL_BOWLERS_DETAILS_SHEET_FILE_PATH);
            cricketLeagueAnalyser.sortPlayersDataBy(CricketLeagueAnalyser.SortingOption.BowlingStrikingRateAndAverage);
            String bowlerWithBestStrikingRateAndBowlingAverage=cricketLeagueAnalyser.getTopPlayer();
            Assert.assertEquals("Krishnappa Gowtham",bowlerWithBestStrikingRateAndBowlingAverage);
        } catch (CricketLeagueAnalyserException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void givenIPLBowlersDetailsFile_whenSortedByMostWicketsAndBowlingAverage_shouldReturnBowlerScoredMostWicketsAndBowlingAverage() {
        try {
            CricketLeagueAnalyser cricketLeagueAnalyser=new CricketLeagueAnalyser(CricketLeagueAnalyser.AnalyserMode.BOWLING,IPL_BOWLERS_DETAILS_SHEET_FILE_PATH);
            cricketLeagueAnalyser.sortPlayersDataBy(CricketLeagueAnalyser.SortingOption.BowlingAverageAndWickets);
            String bowlerWithMostWicketseAndBowlingAverage=cricketLeagueAnalyser.getTopPlayer();
            Assert.assertEquals("Imran Tahir",bowlerWithMostWicketseAndBowlingAverage);
        } catch (CricketLeagueAnalyserException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void givenIPLBatsmenDetailsSheetAndIPLBowlersDetailsFile_whenLoaded_shouldReturnNumberOfTotalEntries(){
        try {
            CricketLeagueAnalyser cricketLeagueAnalyser=new CricketLeagueAnalyser(CricketLeagueAnalyser.AnalyserMode.BOWLING_THEN_BATTING,IPL_BOWLERS_DETAILS_SHEET_FILE_PATH,IPL_BATSMEN_DETAILS_SHEET_FILE_PATH);
            int numberOfRecords=cricketLeagueAnalyser.getNumberOfPlayers();
            Assert.assertEquals(150,numberOfRecords);
        } catch (CricketLeagueAnalyserException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void givenIPLBatsmenDetailsSheetAndIPLBowlersDetailsFile_whenLoadedWithWrongNumberOfFiles_shouldThrowException() {
        try {
            new CricketLeagueAnalyser(CricketLeagueAnalyser.AnalyserMode.BATTING_THEN_BOWLING,IPL_BATSMEN_DETAILS_SHEET_FILE_PATH,IPL_BOWLERS_DETAILS_SHEET_FILE_PATH,WRONG_IPL_BATSMEN_DETAILS_SHEET_FILE_PATH);
        } catch (CricketLeagueAnalyserException e) {
            Assert.assertEquals(CricketLeagueAnalyserException.ExceptionType.INVALID_AMOUNT_OF_FILES,e.exceptionType);
        }
    }
    @Test
    public void givenIPLBatsmenDetailsSheetAndIPLBowlersDetailsFile_whenSortedByBattingAndBowlingAverage_shouldReturnPlayerWithBattingAndBowlingAverage() {
        try {
            CricketLeagueAnalyser cricketLeagueAnalyser=new CricketLeagueAnalyser(CricketLeagueAnalyser.AnalyserMode.BOWLING_THEN_BATTING,IPL_BATSMEN_DETAILS_SHEET_FILE_PATH,IPL_BOWLERS_DETAILS_SHEET_FILE_PATH);
            cricketLeagueAnalyser.sortPlayersDataBy(CricketLeagueAnalyser.SortingOption.BatingAndBowlingAverages);
            String playerWithHighestBattingAndBowlingAverage=cricketLeagueAnalyser.getTopPlayer();
            Assert.assertEquals("MS Dhoni",playerWithHighestBattingAndBowlingAverage);
        } catch (CricketLeagueAnalyserException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void givenIPLBatsmenDetailsSheetAndIPLBowlersDetailsFile_whenSortedByRunsAndWickets_shouldReturnTopAllRounder() {
        try {
            CricketLeagueAnalyser cricketLeagueAnalyser=new CricketLeagueAnalyser(CricketLeagueAnalyser.AnalyserMode.BOWLING_THEN_BATTING,IPL_BOWLERS_DETAILS_SHEET_FILE_PATH,IPL_BATSMEN_DETAILS_SHEET_FILE_PATH);
            cricketLeagueAnalyser.sortPlayersDataBy(CricketLeagueAnalyser.SortingOption.RunsAndWickets);
            String playerScoredMoreRunsAndWickets=cricketLeagueAnalyser.getTopPlayer();
            Assert.assertEquals("David Warner ",playerScoredMoreRunsAndWickets);
        } catch (CricketLeagueAnalyserException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void givenIPLBatsmenDetailsSheetAndIPLBowlersDetailsFile_whenSortedWithNOValue_shouldSortByNameAlphabetically() {
        try {
            CricketLeagueAnalyser cricketLeagueAnalyser=new CricketLeagueAnalyser(CricketLeagueAnalyser.AnalyserMode.BOWLING_THEN_BATTING,IPL_BOWLERS_DETAILS_SHEET_FILE_PATH,IPL_BATSMEN_DETAILS_SHEET_FILE_PATH);
            cricketLeagueAnalyser.sortPlayersDataBy();
            String firstPlayerName=cricketLeagueAnalyser.getLeastPlayer();
            String leastPlayerName=cricketLeagueAnalyser.getLeastPlayer();
            Assert.assertEquals("AB de Villiers",firstPlayerName);
            Assert.assertEquals("Yuzvendra Chahal",leastPlayerName);
        } catch (CricketLeagueAnalyserException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void givenIPLBatsmenDetailsSheetAndIPLBowlersDetailsFile_whenAskedToLoadInvalidPlayerPosition_shouldThrowException(){
        try {
            CricketLeagueAnalyser cricketLeagueAnalyser=new CricketLeagueAnalyser(CricketLeagueAnalyser.AnalyserMode.BOWLING_THEN_BATTING,IPL_BOWLERS_DETAILS_SHEET_FILE_PATH,IPL_BATSMEN_DETAILS_SHEET_FILE_PATH);
            cricketLeagueAnalyser.getPlayerAtPositionOf(190);
            cricketLeagueAnalyser.getPlayerAtPositionOf(0);
            cricketLeagueAnalyser.getPlayerAtPositionOf(-10);
        } catch (CricketLeagueAnalyserException e) {
            Assert.assertEquals(CricketLeagueAnalyserException.ExceptionType.INVALID_POSITION_OF_PLAYER,e.exceptionType);
        }
    }
}
