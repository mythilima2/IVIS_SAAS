package Loginpagefile;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

public class CSVreader {
    public  static CSVParser csvParser;
    public static List<String[]> readCredentialsFromCSV(String filePath) throws IOException {
        List<String[]> credentials = new ArrayList<>();
        Reader reader = new FileReader("C:\\Users\\Mythili Bekkam\\IdeaProjects\\Ivisseleniumpractice\\src\\test\\java\\Ivistestfile\\Credentials.csv");
         csvParser = new CSVParser(reader, CSVFormat.DEFAULT.withHeader());

        for (CSVRecord csvRecord : csvParser) {
            String username = csvRecord.get("username");
            String password = csvRecord.get("password");
            credentials.add(new String[]{username, password});
        }

        csvParser.close();
        reader.close();
        return credentials;
    }
}
