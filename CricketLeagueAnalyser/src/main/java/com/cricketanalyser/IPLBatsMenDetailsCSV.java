package com.cricketanalyser;

import com.opencsv.bean.CsvBindByName;

public class IPLBatsMenDetailsCSV {

    @CsvBindByName(column ="PLAYER")
    public String playerName;
    @CsvBindByName(column ="Mat")
    public int matches;
    @CsvBindByName(column ="Inns")
    public int innings;
    @CsvBindByName(column ="NO")
    public int notOuts;
    @CsvBindByName(column ="Runs")
    public int runs;
    @CsvBindByName(column ="Avg")
    public double average;
    @CsvBindByName(column ="SR")
    public double strikeRate;
    @CsvBindByName(column ="100")
    public int centuries;
    @CsvBindByName(column ="50")
    public int fifties;
    @CsvBindByName(column ="4s")
    public int fours;
    @CsvBindByName(column="6s")
    public int sixes;

    @Override
    public String toString() {
        return "PlayerRunDetailCSV{" +
                "playerName='" + playerName + '\'' +
                ", matches=" + matches +
                ", innings=" + innings +
                ", notOuts=" + notOuts +
                ", runs=" + runs +
                ", average=" + average +
                ", centuries=" + centuries +
                ", fifties=" + fifties +
                ", fours=" + fours +
                ", sixes=" + sixes +
                '}';
    }
}

