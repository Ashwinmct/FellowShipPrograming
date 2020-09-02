import com.csvfile.CSVManager;
import com.linkedlist.LinkedList;
import com.linkedlist.WrongIndexErrorException;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class CSVProblem {
    static CSVManager csvManager=new CSVManager();
    static String filePath="C:\\Users\\VIGNESH\\IdeaProjects\\GenericsLinkedList\\src\\main\\resources\\number.csv";
    public static void main(String[] args) throws IOException, WrongIndexErrorException, CsvRequiredFieldEmptyException, CsvDataTypeMismatchException {
        LinkedList<String> linkedList=getList(filePath);
        Scanner in=new Scanner(System.in);
        System.out.println("Enter any number you want ");
        String number=String.valueOf(in.nextInt());
        if(linkedList.search(number)) {
            linkedList.remove(number);
        }else{
            linkedList.append(number);
        }
        writeListToFile(filePath,linkedList);
    }

    private static LinkedList<String> getList(String filePath) throws FileNotFoundException {
        String delimeter=",";
        String file=csvManager.readFile(filePath,delimeter);
        String[] list=file.split(delimeter);
        return toList(list);
    }

    private static LinkedList<String> toList(String[] file) {
       LinkedList<String> list=new LinkedList<>();
        for(String word:file)
            list.append(word);
        return list;
    }
    private static void writeListToFile(String filePath, LinkedList<String> linkedList) throws WrongIndexErrorException, CsvRequiredFieldEmptyException, IOException, CsvDataTypeMismatchException {
        String delimeter=",";
        csvManager.writeToCSVFile(filePath,delimeter,linkedList);
    }
}
