package com.cricketanalyser;

import java.util.LinkedHashMap;


public class BatsMenDetailsLoadingAdapter extends PlayerDetailsLoadingAdapter {
    LinkedHashMap<String, PlayerDetailsDAO> batsManDetailsMap=new LinkedHashMap<String, PlayerDetailsDAO>();
    @Override
    public <E> LinkedHashMap<String, PlayerDetailsDAO> loadPlayerDetails(String... csvFilePath) throws CricketLeagueAnalyserException {
        batsManDetailsMap= super.loadPlayerDetails(csvFilePath[0], IPLBatsMenDetailsCSV.class, batsManDetailsMap);
        if(csvFilePath.length>1){
            return new BowlerDetailsLoadingAdapter().loadBowlerDetailsMap(batsManDetailsMap,csvFilePath[1]);
        }
        return batsManDetailsMap;
    }
    protected <E> LinkedHashMap<String, PlayerDetailsDAO> loadBatsManDetails(LinkedHashMap<String, PlayerDetailsDAO> playerDetailsMap, String csvFilePath) throws CricketLeagueAnalyserException {
        batsManDetailsMap=playerDetailsMap;
        return this.loadPlayerDetails(csvFilePath);
    }
}
