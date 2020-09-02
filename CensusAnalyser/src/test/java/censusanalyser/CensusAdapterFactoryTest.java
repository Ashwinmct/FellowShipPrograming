package censusanalyser;

import org.junit.Assert;
import org.junit.Test;

public class CensusAdapterFactoryTest {
    private static final String INDIA_CENSUS_CSV_FILE_PATH ="./src/test/resources/IndiaStateCensusData.csv";
    private static final String INDIA_STATE_CODE_CSV_FILE_PATH ="./src/test/resources/IndiaStateCode.csv" ;
    private static final String US_CENSUS_FILE_PATH = "./src/test/resources/USCensusData.csv";

    @Test
    public void givenCensusDataCSVFile_whenLoaded_shouldReturnEnsureExactNumberOfRecordsLoadedFromTheRespectiveFile(){
        try {
            CensusAnalyser censusAnalyser=new CensusAnalyser(CensusAnalyser.Country.INDIA);
            int stateCensusFileRecordsCount = censusAnalyser.loadCensusData(INDIA_CENSUS_CSV_FILE_PATH,INDIA_STATE_CODE_CSV_FILE_PATH);
            Assert.assertEquals(29,stateCensusFileRecordsCount);
        } catch (CensusAnalyserException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void givenUSCensusDataCSVFile_whenLoaded_shouldReturnEnsureExactNumberOfRecordsLoadedFromTheRespectiveFile(){
        try{
            CensusAnalyser censusAnalyser=new CensusAnalyser(CensusAnalyser.Country.US);
            int USDataEntries=51;
            int readableUSDataCount=censusAnalyser.loadCensusData(US_CENSUS_FILE_PATH);
            Assert.assertEquals(USDataEntries,readableUSDataCount);
        } catch (CensusAnalyserException e) {
            e.printStackTrace();
        }
    }
}
