package knapsackproblem;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import knapsackproblem.item.Items;

public class BookLoader {

    public static Items read(String fileName) {
        Items items = new Items();
        Path pathToFile = Paths.get(fileName);
        try (BufferedReader br = Files.newBufferedReader(pathToFile, StandardCharsets.US_ASCII)) {
            String row = br.readLine();
            while (row != null) {
                String[] columns = row.split(";");
                items.add(new Book(Integer.parseInt(columns[0]), Integer.parseInt(columns[1])));
                row = br.readLine();
            }
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
        return items;
    }
}
