package censusanalyser;

import censusanalyser.CensusAnalyser;
import censusanalyser.CensusAnalyserException;
import censusanalyser.IndiaCensusCSV;
import censusanalyser.USCensusCSV;
import org.junit.Assert;
import org.junit.Test;
import com.google.gson.Gson;

public class CensusAnalyserTest {
    private static final String INDIA_CENSUS_CSV_FILE_PATH ="./src/test/resources/IndiaStateCensusData.csv";
    private static final String WRONG_STATE_CENSUS_FILE_PATH ="./src/main/resources/IndiaStateCensusData.csv";
    private static final String WRONG_HEADER_STATE_CENSUS_FILE_PATH ="./src/test/resources/WrongHeaderStateCensusData.csv" ;
    private static final String WRONG_DELIMETER_STATE_CENSUS_FILE_PATH ="./src/test/resources/WrongDelimeterCensus.csv" ;
    private static final String WRONG_TYPE_STATE_CENSUS_FILE_PATH ="./src/test/resources/WrongTypeStateCensusData.csv" ;
    private static final String INDIA_STATE_CODE_CSV_FILE_PATH ="./src/test/resources/IndiaStateCode.csv" ;
    private static final String WRONG_STATE_CODE_FILE_PATH ="./src/main/resources/IndiaStateCode.csv";
    private static final String WRONG_HEADER_STATE_CODE_FILE_PATH ="./src/test/resources/WrongHeaderIndiaStateCode.csv" ;
    private static final String WRONG_DELIMETER_STATE_CODE_FILE_PATH ="./src/test/resources/WrongDeleimeterIndiaStateCode.csv" ;
    private static final String WRONG_TYPE_STATE_CODE_FILE_PATH ="./src/test/resources/WrongTypeIndiaStateCode.csv" ;
    private static final String EMPTY_CENSUS_FILE ="./src/test/resources/EmptyCensus.csv" ;
    private static final String US_CENSUS_FILE_PATH = "./src/test/resources/USCensusData.csv";
    private static final String WRONG_US_CENSUS_FILE_PATH ="./src/main/resources/USCensusData.csv" ;
    private static final String WRONG_HEADER_US_CENSUS_FILE_PATH ="./src/test/resources/WrongHeaderUSCensusData.csv" ;
    private static final String WRONG_DELIMETER_US_CENSUS_FILE_PATH ="./src/test/resources/WrongDelimeterUSCensusData.csv";
    private static final String WRONG_TYPE_US_CENSUS_FILE_PATH ="./src/test/resources/WrongTypeUSCensusData.csv";

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
    public void givenCensusDataCSVFileWithWrongPath_whenLoaded_shouldThrowException(){
        CensusAnalyser censusAnalyser=new CensusAnalyser(CensusAnalyser.Country.INDIA);
        try {
            censusAnalyser.loadCensusData(WRONG_STATE_CENSUS_FILE_PATH,INDIA_STATE_CODE_CSV_FILE_PATH);
        } catch (CensusAnalyserException e) {
            Assert.assertEquals(CensusAnalyserException.ExceptionType.WRONG_FILE_PATH,e.type);
        }
    }
    @Test
    public void givenCensusDataCSVFileWithWrongHeaders_whenLoaded_shouldThrowException(){
        CensusAnalyser censusAnalyser=new CensusAnalyser(CensusAnalyser.Country.INDIA);
        try {
            censusAnalyser.loadCensusData(WRONG_HEADER_STATE_CENSUS_FILE_PATH,INDIA_STATE_CODE_CSV_FILE_PATH);
        } catch (CensusAnalyserException e) {
            Assert.assertEquals(CensusAnalyserException.ExceptionType.PROBLEM_IN_READING_FILE,e.type);
        }
    }
    @Test
    public void givenCensusDataCSVFileWithWrongDelimeter_whenLoaded_shouldThrowException(){
        CensusAnalyser censusAnalyser=new CensusAnalyser(CensusAnalyser.Country.INDIA);
        try {
            censusAnalyser.loadCensusData(WRONG_DELIMETER_STATE_CENSUS_FILE_PATH,INDIA_STATE_CODE_CSV_FILE_PATH);
        } catch (CensusAnalyserException e) {
            Assert.assertEquals(CensusAnalyserException.ExceptionType.PROBLEM_IN_READING_FILE,e.type);
        }
    }
    @Test
    public void givenCensusDataCSVFileWithWrongHeaderType_whenLoaded_shouldThrowException(){
        CensusAnalyser censusAnalyser=new CensusAnalyser(CensusAnalyser.Country.INDIA);
        try {
            censusAnalyser.loadCensusData(WRONG_TYPE_STATE_CENSUS_FILE_PATH,INDIA_STATE_CODE_CSV_FILE_PATH);
        } catch (CensusAnalyserException e){
            Assert.assertEquals(CensusAnalyserException.ExceptionType.PROBLEM_IN_READING_FILE, e.type);
        }
    }
    @Test
    public void givenStateCodeDataCSVFile_whenLoaded_shouldReturnEnsureExactNumberOfRecordsLoadedFromTheRespective() {
        CensusAnalyser censusAnalyser=new CensusAnalyser(CensusAnalyser.Country.INDIA);
        int stateCensusFileRecordsCount = 0;
        try {
            stateCensusFileRecordsCount = censusAnalyser.loadCensusData(INDIA_CENSUS_CSV_FILE_PATH,INDIA_STATE_CODE_CSV_FILE_PATH);
        } catch (CensusAnalyserException e) {
            e.printStackTrace();
        }
        Assert.assertEquals(29,stateCensusFileRecordsCount);
    }
    @Test
    public void givenStateCodeDataCSVFileWithWrongPath_whenLoaded_shouldThrowException(){
        CensusAnalyser censusAnalyser=new CensusAnalyser(CensusAnalyser.Country.INDIA);
        try {
            censusAnalyser.loadCensusData(INDIA_CENSUS_CSV_FILE_PATH,WRONG_STATE_CODE_FILE_PATH);
        } catch (CensusAnalyserException e) {
            Assert.assertEquals(CensusAnalyserException.ExceptionType.WRONG_FILE_PATH,e.type);
        }
    }
    @Test
    public void givenStateCodeDataCSVFileWithWrongHeaders_whenLoaded_shouldThrowException(){
        CensusAnalyser censusAnalyser=new CensusAnalyser(CensusAnalyser.Country.INDIA);
        try {
            censusAnalyser.loadCensusData(INDIA_CENSUS_CSV_FILE_PATH,WRONG_HEADER_STATE_CODE_FILE_PATH);
        } catch (CensusAnalyserException e) {
            Assert.assertEquals(CensusAnalyserException.ExceptionType.PROBLEM_IN_READING_FILE,e.type);
        }
    }
    @Test
    public void givenStateCodeDataCSVFileWithWrongDelimeter_whenLoaded_shouldThrowException() {
        CensusAnalyser censusAnalyser=new CensusAnalyser(CensusAnalyser.Country.INDIA);
        try {
            censusAnalyser.loadCensusData(INDIA_CENSUS_CSV_FILE_PATH,WRONG_DELIMETER_STATE_CODE_FILE_PATH);
        } catch (CensusAnalyserException e) {
            Assert.assertEquals(CensusAnalyserException.ExceptionType.PROBLEM_IN_READING_FILE,e.type);
        }
    }
    @Test
    public void givenStateCodeDataCSVFileWithWrongHeaderType_whenLoaded_shouldThrowException(){
        CensusAnalyser censusAnalyser=new CensusAnalyser(CensusAnalyser.Country.INDIA);
        try {
            censusAnalyser.loadCensusData(INDIA_CENSUS_CSV_FILE_PATH,WRONG_TYPE_STATE_CODE_FILE_PATH);
        } catch (CensusAnalyserException e){
            Assert.assertEquals(CensusAnalyserException.ExceptionType.PROBLEM_IN_READING_FILE, e.type);
        }
    }
    @Test
    public void givenCensusDataCSVFile_whenSortedWithRespectToStateName_shouldReturnTheCorrectFirstStateName(){
        CensusAnalyser censusAnalyser=new CensusAnalyser(CensusAnalyser.Country.INDIA);
        try {
            censusAnalyser.loadCensusData(INDIA_CENSUS_CSV_FILE_PATH,INDIA_STATE_CODE_CSV_FILE_PATH);
            String sortedCensusData=censusAnalyser.getSortedCensusDataWithSortWithRespectTo(CensusAnalyser.SortingOption.STATE_NAME);
            IndiaCensusCSV[] indiaCensusCSVData= new Gson().fromJson(sortedCensusData,IndiaCensusCSV[].class);
            Assert.assertEquals("Andhra Pradesh",indiaCensusCSVData[0].state);
        } catch (CensusAnalyserException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void givenCensusDataCSVFile_whenSortedWithRespectToStateName_shouldReturnTheCorrectLastStateName()  {
        CensusAnalyser censusAnalyser=new CensusAnalyser(CensusAnalyser.Country.INDIA);
        try {
            censusAnalyser.loadCensusData(INDIA_CENSUS_CSV_FILE_PATH,INDIA_STATE_CODE_CSV_FILE_PATH);
            String sortedCensusData=censusAnalyser.getSortedCensusDataWithSortWithRespectTo(CensusAnalyser.SortingOption.STATE_NAME);
            IndiaCensusCSV[] indiaCensusCSVData= new Gson().fromJson(sortedCensusData,IndiaCensusCSV[].class);
            Assert.assertEquals("West Bengal",indiaCensusCSVData[28].state);
        } catch (CensusAnalyserException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void givenCensusDataCSVFile_whenHaveNoDataToSort_shouldThrowException(){
        CensusAnalyser censusAnalyser=new CensusAnalyser(CensusAnalyser.Country.INDIA);
        try {
            censusAnalyser.loadCensusData(EMPTY_CENSUS_FILE,INDIA_STATE_CODE_CSV_FILE_PATH);
            censusAnalyser.getSortedCensusDataWithSortWithRespectTo(CensusAnalyser.SortingOption.POPULATION);
        } catch (CensusAnalyserException e) {
            Assert.assertEquals(CensusAnalyserException.ExceptionType.NO_DATA_FOUND,e.type);
        }
    }
    @Test
    public void givenCensusDataCSVFile_whenSortedWithRespectToStatePopulation_shouldReturnTheMostPopulatedStateName() {
        try {
            CensusAnalyser censusAnalyser=new CensusAnalyser(CensusAnalyser.Country.INDIA);
            censusAnalyser.loadCensusData(INDIA_CENSUS_CSV_FILE_PATH,INDIA_STATE_CODE_CSV_FILE_PATH);
            String sortedCensusData=censusAnalyser.getSortedCensusDataWithSortWithRespectTo(CensusAnalyser.SortingOption.POPULATION);
            String mostPopulatedState="Uttar Pradesh";
            IndiaCensusCSV[] indiaCensusCSVData= new Gson().fromJson(sortedCensusData,IndiaCensusCSV[].class);
            Assert.assertEquals(mostPopulatedState,indiaCensusCSVData[28].state);
        } catch (CensusAnalyserException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void givenCensusDataCSVFile_whenSortedWithRespectToStatePopulation_shouldReturnTheLeastPopulatedStateName() {
        try{
        CensusAnalyser censusAnalyser=new CensusAnalyser(CensusAnalyser.Country.INDIA);
        censusAnalyser.loadCensusData(INDIA_CENSUS_CSV_FILE_PATH,INDIA_STATE_CODE_CSV_FILE_PATH);
        String sortedCensusData=censusAnalyser.getSortedCensusDataWithSortWithRespectTo(CensusAnalyser.SortingOption.POPULATION);
        String leastPopulatedState="Sikkim";
        IndiaCensusCSV[] indiaCensusCSVData= new Gson().fromJson(sortedCensusData,IndiaCensusCSV[].class);
        Assert.assertEquals(leastPopulatedState,indiaCensusCSVData[0].state);
        } catch (CensusAnalyserException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void givenCensusDataCSVFile_whenSortedWithRespectToStateArea_shouldReturnTheLargestStateName() {
        try{
            CensusAnalyser censusAnalyser=new CensusAnalyser(CensusAnalyser.Country.INDIA);
            censusAnalyser.loadCensusData(INDIA_CENSUS_CSV_FILE_PATH,INDIA_STATE_CODE_CSV_FILE_PATH);
            String sortedCensusData=censusAnalyser.getSortedCensusDataWithSortWithRespectTo(CensusAnalyser.SortingOption.AREA);
            String largestState="Rajasthan";
            IndiaCensusCSV[] indiaCensusCSVData= new Gson().fromJson(sortedCensusData,IndiaCensusCSV[].class);
            Assert.assertEquals(largestState,indiaCensusCSVData[28].state);
        } catch (CensusAnalyserException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void givenCensusDataCSVFile_whenSortedWithRespectToStateArea_shouldReturnTheSmallestStateName(){
        try{
            CensusAnalyser censusAnalyser=new CensusAnalyser(CensusAnalyser.Country.INDIA);
            censusAnalyser.loadCensusData(INDIA_CENSUS_CSV_FILE_PATH,INDIA_STATE_CODE_CSV_FILE_PATH);
            String sortedCensusData=censusAnalyser.getSortedCensusDataWithSortWithRespectTo(CensusAnalyser.SortingOption.AREA);
            String smallestState="Goa";
            IndiaCensusCSV[] indiaCensusCSVData= new Gson().fromJson(sortedCensusData,IndiaCensusCSV[].class);
            Assert.assertEquals(smallestState,indiaCensusCSVData[0].state);
        } catch (CensusAnalyserException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void givenCensusDataCSVFile_whenSortedWithRespectToStatePopulationDensity_shouldReturnTheHighlyDensedStateName(){
        try{
            CensusAnalyser censusAnalyser=new CensusAnalyser(CensusAnalyser.Country.INDIA);
            censusAnalyser.loadCensusData(INDIA_CENSUS_CSV_FILE_PATH,INDIA_STATE_CODE_CSV_FILE_PATH);
            String sortedCensusData=censusAnalyser.getSortedCensusDataWithSortWithRespectTo(CensusAnalyser.SortingOption.POPULATION_DENSITY);
            String stateWithHighPopulationDensity="Bihar";
            IndiaCensusCSV[] indiaCensusCSVData= new Gson().fromJson(sortedCensusData,IndiaCensusCSV[].class);
            Assert.assertEquals(stateWithHighPopulationDensity,indiaCensusCSVData[28].state);
        } catch (CensusAnalyserException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void givenCensusDataCSVFile_whenSortedWithRespectToStatePopulationDensity_shouldReturnTheLessDensedStateName(){
        try{
            CensusAnalyser censusAnalyser=new CensusAnalyser(CensusAnalyser.Country.INDIA);
            censusAnalyser.loadCensusData(INDIA_CENSUS_CSV_FILE_PATH,INDIA_STATE_CODE_CSV_FILE_PATH);
            String sortedCensusData=censusAnalyser.getSortedCensusDataWithSortWithRespectTo(CensusAnalyser.SortingOption.POPULATION_DENSITY);
            String stateWithLowPopulationDensity="Arunachal Pradesh";
            IndiaCensusCSV[] indiaCensusCSVData= new Gson().fromJson(sortedCensusData,IndiaCensusCSV[].class);
            Assert.assertEquals(stateWithLowPopulationDensity,indiaCensusCSVData[0].state);
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
    @Test
    public void givenUSCensusDataCSVFileWithWrongPath_whenLoaded_shouldThrowException(){
        CensusAnalyser censusAnalyser=new CensusAnalyser(CensusAnalyser.Country.US);
        try {
            censusAnalyser.loadCensusData(WRONG_US_CENSUS_FILE_PATH);
        } catch (CensusAnalyserException e) {
            Assert.assertEquals(CensusAnalyserException.ExceptionType.WRONG_FILE_PATH,e.type);
        }
    }
    @Test
    public void givenUSCensusDataCSVFileWithWrongHeaders_whenLoaded_shouldThrowException(){
        CensusAnalyser censusAnalyser=new CensusAnalyser(CensusAnalyser.Country.US);
        try {
            censusAnalyser.loadCensusData(WRONG_HEADER_US_CENSUS_FILE_PATH);
        } catch (CensusAnalyserException e) {
            Assert.assertEquals(CensusAnalyserException.ExceptionType.PROBLEM_IN_READING_FILE,e.type);
        }
    }
    @Test
    public void givenUSCensusDataCSVFileWithWrongDelimeter_whenLoaded_shouldThrowException(){
        CensusAnalyser censusAnalyser=new CensusAnalyser(CensusAnalyser.Country.US);
        try {
            censusAnalyser.loadCensusData(WRONG_DELIMETER_US_CENSUS_FILE_PATH);
        } catch (CensusAnalyserException e) {
            Assert.assertEquals(CensusAnalyserException.ExceptionType.PROBLEM_IN_READING_FILE,e.type);
        }

    }
    @Test
    public void givenUSCensusDataCSVFileWithWrongHeaderType_whenLoaded_shouldThrowException(){
        CensusAnalyser censusAnalyser=new CensusAnalyser(CensusAnalyser.Country.US);
        try {
            censusAnalyser.loadCensusData(WRONG_TYPE_US_CENSUS_FILE_PATH);
        } catch (CensusAnalyserException e){
            Assert.assertEquals(CensusAnalyserException.ExceptionType.PROBLEM_IN_READING_FILE, e.type);
        }
    }
    @Test
    public void givenUSCensusDataCSVFile_whenSortedWithRespectToStateName_shouldReturnTheCorrectFirstStateName(){
        CensusAnalyser censusAnalyser=new CensusAnalyser(CensusAnalyser.Country.US);
        try {
            censusAnalyser.loadCensusData(US_CENSUS_FILE_PATH);
            String sortedCensusData=censusAnalyser.getSortedCensusDataWithSortWithRespectTo(CensusAnalyser.SortingOption.STATE_NAME);
            USCensusCSV[] usCensusCSVData= new Gson().fromJson(sortedCensusData,USCensusCSV[].class);
            Assert.assertEquals("Alabama",usCensusCSVData[0].state);
        } catch (CensusAnalyserException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void givenUSCensusDataCSVFile_whenSortedWithRespectToStateName_shouldReturnTheCorrectLastStateName(){
        try{
            CensusAnalyser censusAnalyser=new CensusAnalyser(CensusAnalyser.Country.US);
            censusAnalyser.loadCensusData(US_CENSUS_FILE_PATH);
            String sortedCensusData=censusAnalyser.getSortedCensusDataWithSortWithRespectTo(CensusAnalyser.SortingOption.STATE_NAME);
            USCensusCSV[] usCensusCSVData= new Gson().fromJson(sortedCensusData,USCensusCSV[].class);
            Assert.assertEquals("Wyoming",usCensusCSVData[50].state);
        } catch (CensusAnalyserException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void givenUSCensusDataCSVFile_whenSortedWithRespectToStatePopulation_shouldReturnTheMostPopulatedStateName(){
        try{
            CensusAnalyser censusAnalyser=new CensusAnalyser(CensusAnalyser.Country.US);
            censusAnalyser.loadCensusData(US_CENSUS_FILE_PATH);
            String sortedCensusData=censusAnalyser.getSortedCensusDataWithSortWithRespectTo(CensusAnalyser.SortingOption.POPULATION);
            String mostPopulatedState="California";
            USCensusCSV[] usCensusCSVData= new Gson().fromJson(sortedCensusData,USCensusCSV[].class);
            Assert.assertEquals(mostPopulatedState,usCensusCSVData[50].state);
        } catch (CensusAnalyserException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void givenUSCensusDataCSVFile_whenSortedWithRespectToStatePopulation_shouldReturnTheLeastPopuatedStateName(){
        CensusAnalyser censusAnalyser=new CensusAnalyser(CensusAnalyser.Country.US);
        try {
            censusAnalyser.loadCensusData(US_CENSUS_FILE_PATH);
            String sortedCensusData=censusAnalyser.getSortedCensusDataWithSortWithRespectTo(CensusAnalyser.SortingOption.POPULATION);
            String leastPopulatedState="Wyoming";
            USCensusCSV[] usCensusCSVData= new Gson().fromJson(sortedCensusData,USCensusCSV[].class);
            Assert.assertEquals(leastPopulatedState,usCensusCSVData[0].state);
        } catch (CensusAnalyserException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void givenUSCensusDataCSVFile_whenSortedWithRespectToStateArea_shouldReturnTheLargestStateName(){
        try{
            CensusAnalyser censusAnalyser=new CensusAnalyser(CensusAnalyser.Country.US);
            censusAnalyser.loadCensusData(US_CENSUS_FILE_PATH);
            String sortedCensusData=censusAnalyser.getSortedCensusDataWithSortWithRespectTo(CensusAnalyser.SortingOption.AREA);
            String largestState="Alaska";
            USCensusCSV[] usCensusCSVData= new Gson().fromJson(sortedCensusData,USCensusCSV[].class);
            Assert.assertEquals(largestState,usCensusCSVData[50].state);
        } catch (CensusAnalyserException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void givenUSCensusDataCSVFile_whenSortedWithRespectToStateArea_shouldReturnTheSmallestStateName() {
        try{
            CensusAnalyser censusAnalyser=new CensusAnalyser(CensusAnalyser.Country.US);
            censusAnalyser.loadCensusData(US_CENSUS_FILE_PATH);
            String sortedCensusData=censusAnalyser.getSortedCensusDataWithSortWithRespectTo(CensusAnalyser.SortingOption.AREA);
            String smallestState="District of Columbia";
            USCensusCSV[] usCensusCSVData= new Gson().fromJson(sortedCensusData,USCensusCSV[].class);
            Assert.assertEquals(smallestState,usCensusCSVData[0].state);
        } catch (CensusAnalyserException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void givenUSCensusDataCSVFile_whenSortedWithRespectToStatePopulationDensity_shouldReturnTheHighlyDensedStateName(){
        try{
            CensusAnalyser censusAnalyser=new CensusAnalyser(CensusAnalyser.Country.US);
            censusAnalyser.loadCensusData(US_CENSUS_FILE_PATH);
            String sortedCensusData=censusAnalyser.getSortedCensusDataWithSortWithRespectTo(CensusAnalyser.SortingOption.POPULATION_DENSITY);
            String stateWithHighPopulationDensity="District of Columbia";
            USCensusCSV[] usCensusCSVData= new Gson().fromJson(sortedCensusData,USCensusCSV[].class);
            Assert.assertEquals(stateWithHighPopulationDensity,usCensusCSVData[50].state);
        } catch (CensusAnalyserException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void givenUSCensusDataCSVFile_whenSortedWithRespectToStatePopulationDensity_shouldReturnTheLooselyDensedStateName(){
        try{
            CensusAnalyser censusAnalyser=new CensusAnalyser(CensusAnalyser.Country.US);
            censusAnalyser.loadCensusData(US_CENSUS_FILE_PATH);
            String sortedCensusData=censusAnalyser.getSortedCensusDataWithSortWithRespectTo(CensusAnalyser.SortingOption.POPULATION_DENSITY);
            String stateWithLowPopulationDensity="Alaska";
            USCensusCSV[] usCensusCSVData= new Gson().fromJson(sortedCensusData,USCensusCSV[].class);
            Assert.assertEquals(stateWithLowPopulationDensity,usCensusCSVData[0].state);
        } catch (CensusAnalyserException e) {
            e.printStackTrace();
        }
    }
}
