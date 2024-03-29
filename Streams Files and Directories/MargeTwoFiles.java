package StreamsFilesAndDirectories;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class MargeTwoFiles {
    public static void main(String[] args) throws IOException {

        Path pathFileOne = Path.of("C:\\Users\\Boychev\\Downloads\\1. Sum Lines_Resources\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\inputOne.txt");

        List<String> allLinesFirstFile = Files.readAllLines(pathFileOne);

        Path pathFileTwo = Path.of("C:\\Users\\Boychev\\Downloads\\1. Sum Lines_Resources\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\inputTwo.txt");

        List<String> allLinesSecondFile = Files.readAllLines(pathFileTwo);

        PrintWriter writer = new PrintWriter("output.txt");

        allLinesFirstFile.forEach(writer::println);
        allLinesSecondFile.forEach(writer::println);

        writer.close();

    }
}
