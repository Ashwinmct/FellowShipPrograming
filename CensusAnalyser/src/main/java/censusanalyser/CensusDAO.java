package censusanalyser;

public class CensusDAO {
    public String state;
    public int population;
    public double areaInSqKm;
    public double densityPerSqKm;
    public String stateCode;
    public CensusDAO(IndiaCensusCSV indiaCensusCSV){
        state=indiaCensusCSV.state;
        population=indiaCensusCSV.population;
        areaInSqKm=indiaCensusCSV.areaInSqKm;
        densityPerSqKm=indiaCensusCSV.densityPerSqKm;
    }
    public CensusDAO(USCensusCSV censusCSV) {
        state=censusCSV.state;
        stateCode=censusCSV.stateID;
        population=censusCSV.Population;
        areaInSqKm=censusCSV.totalArea;
        densityPerSqKm=censusCSV.populationDensity;
    }
    public Object getCensusDTO(CensusAnalyser.Country country) {
        if(country.equals(CensusAnalyser.Country.INDIA))
            return new IndiaCensusCSV(state,population,densityPerSqKm,areaInSqKm);
        return new USCensusCSV(state,stateCode,population,(int)densityPerSqKm,areaInSqKm);
    }
}
