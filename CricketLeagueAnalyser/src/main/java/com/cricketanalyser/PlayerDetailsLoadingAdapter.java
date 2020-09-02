package com.cricketanalyser;

import com.opencsvbuilder.CSVBuilderException;
import com.opencsvbuilder.CSVFileBuilderFactory;
import com.opencsvbuilder.ICSVBuilder;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.stream.StreamSupport;

public abstract class PlayerDetailsLoadingAdapter {
    public abstract <E> LinkedHashMap<String, PlayerDetailsDAO> loadPlayerDetails(String... csvFilePath) throws CricketLeagueAnalyserException;
    public  <E> LinkedHashMap<String, PlayerDetailsDAO> loadPlayerDetails(String csvFilePath, Class<E> csvClass, LinkedHashMap<String, PlayerDetailsDAO> playerDetailsMap) throws CricketLeagueAnalyserException {
        try (Reader reader = Files.newBufferedReader(Paths.get(csvFilePath))) {
                ICSVBuilder icsvBuilder = CSVFileBuilderFactory.createOpenCSVBuilder();
                Iterator<E> csvIterator = icsvBuilder.getCSVFileIterator(reader, csvClass);
                Iterable<E> csvIterable = () -> csvIterator;
                if (csvClass.getName().equals("com.cricketanalyser.IPLBatsMenDetailsCSV")) {
                    StreamSupport.stream(csvIterable.spliterator(),false)
                                 .parallel()
                                 .map(IPLBatsMenDetailsCSV.class::cast)
                                 .forEach(player ->{
                                     PlayerDetailsDAO batsMan=playerDetailsMap.get(player.playerName);
                                        if(batsMan==null)
                                            playerDetailsMap.put(player.playerName,new PlayerDetailsDAO(player));
                                        else
                                         batsMan.setBatsManData(player);});
                    return playerDetailsMap;
                }
                if(csvClass.getName().equals("com.cricketanalyser.IPLBowlersDetailsCSV")){
                    StreamSupport.stream(csvIterable.spliterator(), false)
                                 .parallel()
                                 .map(IPLBowlersDetailsCSV.class::cast)
                                 .forEach(player ->{
                                     PlayerDetailsDAO bowler=playerDetailsMap.get(player.name);
                                        if(bowler==null)
                                            playerDetailsMap.put(player.name,new PlayerDetailsDAO(player));
                                        else
                                            bowler.setBowlerDetails(player);
                                 });
                    return playerDetailsMap;
                }
            throw new CricketLeagueAnalyserException(CricketLeagueAnalyserException.ExceptionType.INVALID_FILE_TYPE,"Invalid type of File");
        } catch (IOException e) {
            throw new CricketLeagueAnalyserException(CricketLeagueAnalyserException.ExceptionType.WRONG_FILE_PATH,"file not found");
        } catch (CSVBuilderException e) {
            throw new CricketLeagueAnalyserException(CricketLeagueAnalyserException.ExceptionType.PROBLEM_IN_READING_FILE,"file not found");
        } catch (RuntimeException e){
            throw new CricketLeagueAnalyserException(CricketLeagueAnalyserException.ExceptionType.FILE_CONTAINS_INVALID_DATA,"Invalid Data Found");
        }
    }
}

