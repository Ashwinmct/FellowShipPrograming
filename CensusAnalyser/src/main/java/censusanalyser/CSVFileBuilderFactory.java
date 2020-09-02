package censusanalyser;

public class CSVFileBuilderFactory<E> {
    public static<E> ICSVBuilder createOpenCSVBuilder() {
        return new OpenCSVBuilder<>();
    }
}
