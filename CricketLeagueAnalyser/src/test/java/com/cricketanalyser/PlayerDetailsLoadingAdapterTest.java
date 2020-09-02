package com.cricketanalyser;

import org.junit.Assert;
import org.junit.Test;

public class PlayerDetailsLoadingAdapterTest {
    private static final String IPL_BATSMEN_DETAILS_SHEET_FILE_PATH ="./src/test/resources/IPL2019FactsheetMostRuns.csv";
    private static final String IPL_BOWLERS_DETAILS_SHEET_FILE_PATH = "./src/test/resources/IPL2019FactsheetMostWkts.csv";
    @Test
    public void givenBatsMenDetailsFile_whenLoaded_shouldReturnNumberOfBatsMen() {
        PlayerDetailsLoaderAdapterFactory playerDetailsLoaderAdapterFactory=new PlayerDetailsLoaderAdapterFactory();
        try {
            int expectedNumberOfPlayers=100;
            int exactNumberOfPlayers=playerDetailsLoaderAdapterFactory.loadTournamentDetails(CricketLeagueAnalyser.AnalyserMode.BATTING,IPL_BATSMEN_DETAILS_SHEET_FILE_PATH)
                                                                      .size();
            Assert.assertEquals(expectedNumberOfPlayers,exactNumberOfPlayers);
        } catch (CricketLeagueAnalyserException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void givenBowlersDetailsFile_whenLoaded_shouldReturnNumberOfBatsMen() {
        PlayerDetailsLoaderAdapterFactory playerDetailsLoaderAdapterFactory=new PlayerDetailsLoaderAdapterFactory();
        try {
            int expectedNumberOfPlayers=99;
            int exactNumberOfPlayers=playerDetailsLoaderAdapterFactory.loadTournamentDetails(CricketLeagueAnalyser.AnalyserMode.BOWLING,IPL_BOWLERS_DETAILS_SHEET_FILE_PATH)
                                                                      .size();
            Assert.assertEquals(expectedNumberOfPlayers,exactNumberOfPlayers);
        } catch (CricketLeagueAnalyserException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void givenBatsMenBowlersDetailsFile_whenLoaded_shouldReturnNumberOfPlayers() {
        PlayerDetailsLoaderAdapterFactory playerDetailsLoaderAdapterFactory=new PlayerDetailsLoaderAdapterFactory();
        try {
            int expectedNumberOfPlayers=150;
            int exactNumberOfPlayers=playerDetailsLoaderAdapterFactory.loadTournamentDetails(CricketLeagueAnalyser.AnalyserMode.BATTING_THEN_BOWLING,IPL_BATSMEN_DETAILS_SHEET_FILE_PATH,IPL_BOWLERS_DETAILS_SHEET_FILE_PATH)
                                                                      .size();
            Assert.assertEquals(expectedNumberOfPlayers,exactNumberOfPlayers);
        } catch (CricketLeagueAnalyserException e) {
            e.printStackTrace();
        }
    }
}
