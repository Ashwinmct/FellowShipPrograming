package censusanalyser;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Iterator;
import java.util.Map;
import java.util.stream.StreamSupport;

public class IndiaCensusAdapter extends CensusAdapter {
    public Map<String, CensusDAO> loadCensusData(String[] csvFilePath) throws CensusAnalyserException {
        Map<String, CensusDAO> censusDataMap = super.loadCensusData(IndiaCensusCSV.class,csvFilePath[0]);
        this.loadIndiaStateCode(censusDataMap,csvFilePath[1]);
        return censusDataMap;
    }

    private Map<String, CensusDAO> loadIndiaStateCode(Map<String, CensusDAO> censusDataMap, String csvFilePath) throws CensusAnalyserException {
        try ( Reader reader = Files.newBufferedReader(Paths.get(csvFilePath)))
        {
            ICSVBuilder csvBuilder = CSVFileBuilderFactory.createOpenCSVBuilder();
            Iterator<IndiaStateCodeCSV> csvFileIterator = csvBuilder.getCSVFileIterator(reader, IndiaStateCodeCSV.class);
            Iterable<IndiaStateCodeCSV> csvIterable = () -> csvFileIterator;
            StreamSupport.stream(csvIterable.spliterator(),false)
                         .filter(csvState -> censusDataMap.get(csvState) != null)
                         .forEach(csvState -> censusDataMap.get(csvState.stateName).stateCode = csvState.stateCode);
            return censusDataMap;
        } catch (IOException e) {
            throw new CensusAnalyserException(CensusAnalyserException.ExceptionType.WRONG_FILE_PATH,e.getMessage());
        }catch (RuntimeException e) {
            throw new CensusAnalyserException(CensusAnalyserException.ExceptionType.PROBLEM_IN_READING_FILE,e.getMessage());
        } catch (CSVBuilderException e) {
            throw new CensusAnalyserException(e.getMessage(),e.type.name());
        }
    }
}

