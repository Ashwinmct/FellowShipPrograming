package com.cricketanalyser;

import java.util.LinkedHashMap;

public class BowlerDetailsLoadingAdapter extends PlayerDetailsLoadingAdapter {
    LinkedHashMap<String, PlayerDetailsDAO> bowlerDetailsMap= new LinkedHashMap<>();
    @Override
    public LinkedHashMap<String, PlayerDetailsDAO> loadPlayerDetails(String... csvFilePath) throws CricketLeagueAnalyserException {
        bowlerDetailsMap = super.loadPlayerDetails(csvFilePath[0], IPLBowlersDetailsCSV.class, bowlerDetailsMap);
        if(csvFilePath.length>1){
            return new BatsMenDetailsLoadingAdapter().loadBatsManDetails(bowlerDetailsMap,csvFilePath[1]);
        }
        return bowlerDetailsMap;
    }
    protected LinkedHashMap<String, PlayerDetailsDAO> loadBowlerDetailsMap(LinkedHashMap<String, PlayerDetailsDAO> playerDetailsMap, String csvFilePath) throws CricketLeagueAnalyserException {
        bowlerDetailsMap=playerDetailsMap;
        return this.loadPlayerDetails(csvFilePath);
    }
}
