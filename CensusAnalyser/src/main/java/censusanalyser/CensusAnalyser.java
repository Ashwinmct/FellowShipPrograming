package censusanalyser;
import com.google.gson.Gson;
import java.util.*;
import java.util.stream.Collectors;

public class CensusAnalyser {

    public enum Country {INDIA,US}
    public enum SortingOption{
        STATE_NAME,POPULATION,POPULATION_DENSITY,AREA
    }
    private Map<String, CensusDAO> censusDataMap=null;
    private final Country country;
    GenerateComparator generateComparator=new GenerateComparator();

    public CensusAnalyser(Country country) {
        this.country=country;
    }
    public int loadCensusData(String... csvFilePath) throws CensusAnalyserException {
        censusDataMap = CensusAdapterFactory.getCensusDataMap(country,csvFilePath);
        return censusDataMap.size();
    }
    public String getSortedCensusDataWithSortWithRespectTo(CensusAnalyser.SortingOption option) throws CensusAnalyserException {
        if(censusDataMap == null || censusDataMap.size() ==0 ) {
            throw new CensusAnalyserException(CensusAnalyserException.ExceptionType.NO_DATA_FOUND,"No Census Data found");
        }
        Comparator<CensusDAO>  censusComparator=generateComparator.getComparatorOf(option);
        List sortedCensusData = censusDataMap.values()
                                             .stream()
                                             .sorted(censusComparator)
                                             .map(censusDAO -> censusDAO.getCensusDTO(country))
                                             .collect(Collectors.toList());
        return new Gson().toJson(sortedCensusData);
    }
}
