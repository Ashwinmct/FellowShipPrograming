package com.cricketanalyser;

import com.google.gson.Gson;

import java.util.*;
import java.util.stream.Collectors;

public class CricketLeagueAnalyser {

    public enum AnalyserMode {
        BOWLING,BATTING,BATTING_THEN_BOWLING,BOWLING_THEN_BATTING
    }
    public enum SortingOption {
        BattingAverage, BattingStrikeRate,Boundaries, boundariesAndBattingStrikingRate,
        BattingAverageAndStrikingRate,BattingAverageAndMostRuns,BowlingAverage,BowlingStrikingRate,
        BowlingStrikeRateAnd4w5w,BowlingStrikingRateAndAverage,BatingAndBowlingAverages,RunsAndWickets,
        PlayerName, BowlingAverageAndWickets, BowlingEconomy
    }
    private Map<String, PlayerDetailsDAO> playerDetailsMap = new LinkedHashMap<>();
    private final int numberOfPlayers;

    public CricketLeagueAnalyser(AnalyserMode type, String... playersDetailsFilePath) throws CricketLeagueAnalyserException {
        playerDetailsMap =new PlayerDetailsLoaderAdapterFactory().loadTournamentDetails(type,playersDetailsFilePath);
        numberOfPlayers= playerDetailsMap.size();
    }
    public int getNumberOfPlayers() {
        return numberOfPlayers;
    }
    public void sortPlayersDataBy() throws CricketLeagueAnalyserException {
        sortPlayersDataBy(SortingOption.PlayerName);
    }
    public void sortPlayersDataBy(SortingOption option) throws CricketLeagueAnalyserException {
        Comparator<PlayerDetailsDAO> comparator=new ComparatorGenerator().getComparator(option);
        sortMapByComparator(comparator);
    }
    private void sortMapByComparator(Comparator<PlayerDetailsDAO> comparator) throws CricketLeagueAnalyserException {
        if (playerDetailsMap ==null || numberOfPlayers==0)
            throw new CricketLeagueAnalyserException(CricketLeagueAnalyserException.ExceptionType.NO_DATA_FOUND,"No data found in given file");
        List<PlayerDetailsDAO> sortedDataList=getPlayerDetailList().stream()
                                                                   .sorted(comparator)
                                                                   .collect(Collectors.toList());
        upDatePlayersDataMap(sortedDataList);
    }
    private void upDatePlayersDataMap(List<PlayerDetailsDAO> sortedDataList) {
        this.playerDetailsMap
            .clear();
        sortedDataList.forEach(player -> playerDetailsMap.put(player.playerName,player));
    }
    private PlayerDetailsDAO[] getPlayerDetailsArray() {
        String sortedPlayerScoreDetails = getJSONString();
        return new Gson().fromJson(sortedPlayerScoreDetails, PlayerDetailsDAO[].class);
    }
    public String getJSONString() {
        List<PlayerDetailsDAO> playerDetailsList=getPlayerDetailList();
        return new Gson().toJson(playerDetailsList);
    }
    private List<PlayerDetailsDAO> getPlayerDetailList() {
        List<PlayerDetailsDAO> playerDetailsList = new ArrayList<>(playerDetailsMap.values());
        return playerDetailsList;
    }
    public String getTopPlayer() throws CricketLeagueAnalyserException {
        return getPlayerAtPositionOf(numberOfPlayers);
    }
    public String getLeastPlayer() throws CricketLeagueAnalyserException {
        return getPlayerAtPositionOf(1);
    }
    public String getPlayerAtPositionOf(int position) throws CricketLeagueAnalyserException {
        try {
            PlayerDetailsDAO[] playerDataArray = getPlayerDetailsArray();
            return playerDataArray[position - 1].playerName;
        } catch (IndexOutOfBoundsException e){
            throw new CricketLeagueAnalyserException(CricketLeagueAnalyserException.ExceptionType.INVALID_POSITION_OF_PLAYER,"Invalid position entered");
        }
    }
}
