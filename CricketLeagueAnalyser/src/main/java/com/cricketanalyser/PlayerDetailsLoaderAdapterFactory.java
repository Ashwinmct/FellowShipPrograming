package com.cricketanalyser;

import java.util.LinkedHashMap;

public class PlayerDetailsLoaderAdapterFactory {
    public LinkedHashMap<String, PlayerDetailsDAO> loadTournamentDetails(CricketLeagueAnalyser.AnalyserMode analyserMode, String... tournamentPlayersDetailsFilePath) throws CricketLeagueAnalyserException {
        if((analyserMode.equals(CricketLeagueAnalyser.AnalyserMode.BATTING) && tournamentPlayersDetailsFilePath.length==1) ||
            (analyserMode.equals(CricketLeagueAnalyser.AnalyserMode.BATTING_THEN_BOWLING) && tournamentPlayersDetailsFilePath.length==2))
            return new BatsMenDetailsLoadingAdapter().loadPlayerDetails(tournamentPlayersDetailsFilePath);

        if((analyserMode.equals(CricketLeagueAnalyser.AnalyserMode.BOWLING) && tournamentPlayersDetailsFilePath.length==1) ||
           (analyserMode.equals(CricketLeagueAnalyser.AnalyserMode.BOWLING_THEN_BATTING) && tournamentPlayersDetailsFilePath.length==2))
            return new BowlerDetailsLoadingAdapter().loadPlayerDetails(tournamentPlayersDetailsFilePath);

        throw new CricketLeagueAnalyserException(CricketLeagueAnalyserException.ExceptionType.INVALID_AMOUNT_OF_FILES,"Required files missing");

    }
}
