package StreamsFilesAndDirectories;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class LineNumber {
    public static void main(String[] args) throws IOException {

        String pathStr = "C:\\Users\\Boychev\\Downloads\\1. Sum Lines_Resources\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\inputLineNumbers.txt";

        List<String> allLines = Files.readAllLines(Path.of(pathStr));

        PrintWriter writer = new PrintWriter("output.txt");

        int countRow = 1;

        for (String allLine : allLines) {
            writer.println(countRow + ". " + allLine);
            countRow++;
        }
        writer.close();




    }
}
