package censusanalyser;

import com.opencsv.bean.CsvBindByName;

public class IndiaCensusCSV {

    @CsvBindByName(column = "State", required = true)
    public String state;

    @CsvBindByName(column = "Population", required = true)
    public int population;

    @CsvBindByName(column = "AreaInSqKm", required = true)
    public int areaInSqKm;

    @CsvBindByName(column = "DensityPerSqKm", required = true)
    public int densityPerSqKm;
    public String stateCode;

    public IndiaCensusCSV() { }
    public IndiaCensusCSV(String state, int population, double densityPerSqKm, double areaInSqKm) {
        this.state=state;
        this.population=population;
        this.densityPerSqKm= (int) densityPerSqKm;
        this.areaInSqKm= (int) areaInSqKm;
    }

    @Override
    public String toString() {
        return "IndiaCensusCSV{" +
                "State='" + state + '\'' +
                ", Population='" + population + '\'' +
                ", AreaInSqKm='" + areaInSqKm + '\'' +
                ", DensityPerSqKm='" + densityPerSqKm + '\'' +
                '}';
    }
}
