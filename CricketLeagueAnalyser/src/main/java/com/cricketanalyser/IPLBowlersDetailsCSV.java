package com.cricketanalyser;

import com.opencsv.bean.CsvBindByName;

public class IPLBowlersDetailsCSV {
    @CsvBindByName(column="PLAYER",required=true)
    public String name;
    @CsvBindByName(column="Mat")
    public int matches;
    @CsvBindByName(column="Inns")
    public int innings;
    @CsvBindByName(column="Ov")
    public double overs;
    @CsvBindByName(column="Runs")
    public int runs;
    @CsvBindByName(column="Wkts")
    public int wickets;
    @CsvBindByName(column="Avg")
    public double bowlingAverage;
    @CsvBindByName(column="Econ")
    public double economy;
    @CsvBindByName(column="SR")
    public double strikeRate;
    @CsvBindByName(column="4w")
    public int fourWickets;
    @CsvBindByName(column="5w")
    public int fiveWickets;

    @Override
    public String toString() {
        return "IPLWicketsDetailCSV{" +
                "bowlerName='" + name + '\'' +
                ", matches=" + matches +
                ", innings=" + innings +
                ", overs=" + overs +
                ", runs=" + runs +
                ", wickets=" + wickets +
                ", bowlingAverage=" + bowlingAverage +
                ", economy=" + economy +
                ", strikeRate=" + strikeRate +
                ", fourWickets=" + fourWickets +
                ", fiveWickets=" + fiveWickets +
                '}';
    }
}
