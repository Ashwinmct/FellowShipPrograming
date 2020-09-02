package com.csvfile;

import com.linkedlist.LinkedList;
import com.linkedlist.WrongIndexErrorException;
import com.opencsv.CSVWriter;
import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

public class CSVManager {
    public String readFile(String filePath) throws FileNotFoundException {
        String delimeter=",";
        return readFile(filePath,delimeter);
    }
    public String readFile(String filePath,String delimeter) throws FileNotFoundException {
        Scanner sc=new Scanner(new File(filePath));
        String file="";
        sc.useDelimiter(delimeter);
        while (sc.hasNext()){
            file+=sc.next()+delimeter;
        }
        sc.close();
        return file;
    }
    public void writeToCSVFile(String filePath, String delimeter, LinkedList<?> linkedList) throws IOException, WrongIndexErrorException, CsvDataTypeMismatchException, CsvRequiredFieldEmptyException {
        try {
            CSVWriter writer=new CSVWriter(new FileWriter(filePath),CSVWriter.DEFAULT_SEPARATOR);
            String[] file=new String[linkedList.size()];
            for(int i=0;i<linkedList.size();i++)
                file[i]= String.valueOf(linkedList.getElement(i));
            writer.writeNext(file);
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
