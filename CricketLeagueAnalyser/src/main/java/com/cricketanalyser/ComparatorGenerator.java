package com.cricketanalyser;

import java.util.Comparator;
import java.util.Dictionary;
import java.util.Hashtable;

import static com.cricketanalyser.CricketLeagueAnalyser.*;

public class ComparatorGenerator {
    public static Dictionary<SortingOption, Comparator<PlayerDetailsDAO>> comparatorDictionary= new Hashtable<>();
    public ComparatorGenerator(){
        generateComparatorDictionary();
    }
    static void generateComparatorDictionary(){
        Comparator<PlayerDetailsDAO> nameWiseComparator = Comparator.comparing(player -> player.playerName);
        comparatorDictionary.put(SortingOption.PlayerName,nameWiseComparator);

        Comparator<PlayerDetailsDAO> battingAverageWiseComparator = Comparator.comparing(player -> player.battingAverage);
        comparatorDictionary.put(SortingOption.BattingAverage,battingAverageWiseComparator);

        Comparator<PlayerDetailsDAO> battingStrikeRateWiseComparator = Comparator.comparing(player -> player.battingStrikeRate);
        comparatorDictionary.put(SortingOption.BattingStrikeRate,battingStrikeRateWiseComparator);

        Comparator<PlayerDetailsDAO> boundryWiseComparator = Comparator.comparing(player -> player.numberOfBoundaries);
        comparatorDictionary.put(SortingOption.Boundaries,boundryWiseComparator);

        Comparator<PlayerDetailsDAO> boundryWiseANDStrikeRateComparator = battingStrikeRateWiseComparator.thenComparing(player -> player.numberOfBoundaries);
        comparatorDictionary.put(SortingOption.boundariesAndBattingStrikingRate,boundryWiseANDStrikeRateComparator);

        Comparator<PlayerDetailsDAO> battingAverageANDStrikeRateComparator = battingStrikeRateWiseComparator.thenComparing(player -> player.battingAverage);
        comparatorDictionary.put(SortingOption.BattingAverageAndStrikingRate,battingAverageANDStrikeRateComparator);

        Comparator<PlayerDetailsDAO> runWiseComparator = Comparator.comparing(player -> player.runs);
        Comparator<PlayerDetailsDAO> runAndBattingAverageWiseComparator = runWiseComparator.thenComparing(player -> player.battingAverage);
        comparatorDictionary.put(SortingOption.BattingAverageAndMostRuns,runAndBattingAverageWiseComparator);

        Comparator<PlayerDetailsDAO> bowlingStrikeRateWiseComparator = Comparator.comparing(player -> player.bowlingStrikeRate);
        comparatorDictionary.put(SortingOption.BowlingStrikingRate,bowlingStrikeRateWiseComparator);

        Comparator<PlayerDetailsDAO> bowlingEconomyWiseComparator = Comparator.comparing(player -> player.economy);
        comparatorDictionary.put(SortingOption.BowlingEconomy,bowlingEconomyWiseComparator);

        Comparator<PlayerDetailsDAO> bowlingAverageWiseComparator = Comparator.comparing(player -> player.bowlingAverage);
        comparatorDictionary.put(SortingOption.BowlingAverage,bowlingAverageWiseComparator);

        Comparator<PlayerDetailsDAO> bowlingStrikeRateAndFiveAndFourWicketsWiseComparator = bowlingStrikeRateWiseComparator.thenComparing(player -> player.fiveWickets+player.fiveWickets);
        comparatorDictionary.put(SortingOption.BowlingStrikeRateAnd4w5w,bowlingStrikeRateAndFiveAndFourWicketsWiseComparator);

        Comparator<PlayerDetailsDAO> bowlingStrikeRateAndBowlingAverageWiseComparator = bowlingStrikeRateWiseComparator.thenComparing(player -> player.bowlingAverage);
        comparatorDictionary.put(SortingOption.BowlingStrikingRateAndAverage,bowlingStrikeRateAndBowlingAverageWiseComparator);

        Comparator<PlayerDetailsDAO> wicketWiseComparator = Comparator.comparing(player -> player.wickets);
        Comparator<PlayerDetailsDAO> wicketAndBowlingAverageWiseComparator = wicketWiseComparator.thenComparing(player -> player.bowlingAverage);
        comparatorDictionary.put(SortingOption.BowlingAverageAndWickets,wicketAndBowlingAverageWiseComparator);

        Comparator<PlayerDetailsDAO> battingAverageAndBowlingAverageWiseComparator = battingAverageWiseComparator.thenComparing(player -> player.bowlingAverage);
        comparatorDictionary.put(SortingOption.BatingAndBowlingAverages,battingAverageAndBowlingAverageWiseComparator);

        Comparator<PlayerDetailsDAO> runsScoredWiseComparator = Comparator.comparing(player -> player.runs);
        Comparator<PlayerDetailsDAO> runsAndWicketsWiseComparator = runsScoredWiseComparator.thenComparing(player -> player.wickets);
        comparatorDictionary.put(SortingOption.RunsAndWickets,runsAndWicketsWiseComparator);
    }
    public Comparator<PlayerDetailsDAO> getComparator(SortingOption option) {
        return comparatorDictionary.get(option);
    }
}
