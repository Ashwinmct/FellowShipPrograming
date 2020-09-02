package censusanalyser;

import java.util.Comparator;
import java.util.EnumMap;

public class GenerateComparator {
    EnumMap<CensusAnalyser.SortingOption, Comparator<CensusDAO>> sortingOptionComparatorMap= new EnumMap<>(CensusAnalyser.SortingOption.class);

    public GenerateComparator() {
        sortingOptionComparatorMap.put(CensusAnalyser.SortingOption.STATE_NAME,Comparator.comparing(censusData -> censusData.state));
        sortingOptionComparatorMap.put(CensusAnalyser.SortingOption.POPULATION,Comparator.comparing(censusData -> censusData.population));
        sortingOptionComparatorMap.put(CensusAnalyser.SortingOption.POPULATION_DENSITY,Comparator.comparing(censusData -> censusData.densityPerSqKm));
        sortingOptionComparatorMap.put(CensusAnalyser.SortingOption.AREA,Comparator.comparing(censusData -> censusData.areaInSqKm));
    }

    public Comparator<CensusDAO> getComparatorOf(CensusAnalyser.SortingOption option) {
        return sortingOptionComparatorMap.get(option);
    }
}
