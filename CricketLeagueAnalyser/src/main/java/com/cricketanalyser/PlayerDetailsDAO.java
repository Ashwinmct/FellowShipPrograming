package com.cricketanalyser;

public class PlayerDetailsDAO {
    public final String playerName;
    public int matches;
    public int innings;
    public int runs;
    public double battingAverage;
    public double battingStrikeRate;
    public int notOuts;
    public int fifties;
    public int centuries;
    public int fours;
    public int sixes;
    public double bowlingAverage;
    public double economy;
    public int fiveWickets;
    public double overs;
    public int wickets;
    public double bowlingStrikeRate;
    public double runsGiven;
    public int fourWickets;
    public int numberOfBoundaries;

    public PlayerDetailsDAO(IPLBatsMenDetailsCSV batsManDetailCSV) {
        playerName = batsManDetailCSV.playerName;
        matches= batsManDetailCSV.matches;
        innings= batsManDetailCSV.innings;
        runs= batsManDetailCSV.runs;
        battingAverage = batsManDetailCSV.average;
        battingStrikeRate = batsManDetailCSV.strikeRate;
        notOuts= batsManDetailCSV.notOuts;
        fifties= batsManDetailCSV.fifties;
        centuries= batsManDetailCSV.centuries;
        fours= batsManDetailCSV.fours;
        sixes= batsManDetailCSV.sixes;
        numberOfBoundaries=sixes+fours;
    }
    public PlayerDetailsDAO(IPLBowlersDetailsCSV bowler) {
        playerName=bowler.name;
        bowlingAverage=bowler.bowlingAverage;
        economy=bowler.economy;
        fiveWickets=bowler.fiveWickets;
        fourWickets=bowler.fourWickets;
        innings=bowler.innings;
        matches=bowler.matches;
        overs=bowler.overs;
        runsGiven=bowler.runs;
        bowlingStrikeRate=bowler.strikeRate;
        wickets=bowler.wickets;
        //totalAverage=bowler.bowlingAverage+battingAverage;
    }
    public void setBowlerDetails(IPLBowlersDetailsCSV bowlerData) {
        bowlingAverage=bowlerData.bowlingAverage;
        economy=bowlerData.economy;
        fiveWickets=bowlerData.fiveWickets;
        fourWickets=bowlerData.fourWickets;
        innings=bowlerData.innings;
        matches=bowlerData.matches;
        overs=bowlerData.overs;
        runsGiven=bowlerData.runs;
        bowlingStrikeRate=bowlerData.strikeRate;
        wickets=bowlerData.wickets;
        //totalAverage=bowlerData.bowlingAverage+battingAverage;
    }
    public void setBatsManData(IPLBatsMenDetailsCSV batsManData) {
        matches= batsManData.matches;
        innings= batsManData.innings;
        runs= batsManData.runs;
        battingAverage = batsManData.average;
        battingStrikeRate = batsManData.strikeRate;
        notOuts= batsManData.notOuts;
        fifties= batsManData.fifties;
        centuries= batsManData.centuries;
        fours= batsManData.fours;
        sixes= batsManData.sixes;
        numberOfBoundaries=sixes+fours;
    }
}
