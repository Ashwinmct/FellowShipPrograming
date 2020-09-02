package censusanalyser;

import com.opencsv.bean.CsvBindByName;

public class IndiaStateCodeCSV {
    @CsvBindByName(column = "StateName", required = true)
    public String stateName;
    @CsvBindByName(column = "StateCode", required = true)
    public String stateCode;
    @CsvBindByName(column = "SrNo")
    public int serialNumber;
    @CsvBindByName(column = "TIN")
    public int TIN;
    @Override
    public String toString() {
        return "IndiaStateCodeCsv{" +
                "stateName='" + stateName + '\'' +
                ", stateCode='" + stateCode + '\'' +
                ", serialNumber='" + serialNumber + '\'' +
                ", TIN='" + TIN + '\'' +
                '}';
    }
}
