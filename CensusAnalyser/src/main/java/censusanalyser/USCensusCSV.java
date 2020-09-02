package censusanalyser;

import com.opencsv.bean.CsvBindByName;

public class USCensusCSV {

    @CsvBindByName(column = "State", required = true)
    public String state;
    @CsvBindByName(column = "State Id", required = true)
    public String stateID;
    @CsvBindByName(column = "Population", required = true)
    public int Population;
    @CsvBindByName(column = "Population Density", required = true)
    public double populationDensity;
    @CsvBindByName(column = "Total area", required = true)
    public double totalArea;

    public USCensusCSV(String state, String stateCode, int population, double populationDensity, double areaInSqKm) {
        this.state=state;
        this.stateID=stateCode;
        this.Population=population;
        this.populationDensity=populationDensity;
        this.totalArea=areaInSqKm;
    }
    @Override
    public String toString() {
        return "USCensusCSV{" +
                "state='" + state + '\'' +
                ", stateID='" + stateID + '\'' +
                ", Population='" + Population + '\'' +
                ", populationDensity='" + populationDensity + '\'' +
                ", totalArea='" + totalArea + '\'' +
                '}';
    }
}
