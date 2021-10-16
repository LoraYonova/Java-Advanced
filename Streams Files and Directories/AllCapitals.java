package StreamsFilesAndDirectories;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Locale;

public class AllCapitals {
    public static void main(String[] args) throws IOException {


        String pathStr = "C:\\Users\\Boychev\\Downloads\\1. Sum Lines_Resources\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\input.txt";

        BufferedWriter writer = new BufferedWriter(new FileWriter("output.txt"));

        Files.readAllLines(Path.of(pathStr)).forEach(
                line -> {
                    try {
                        writer.write(line.toUpperCase(Locale.ROOT));
                        writer.newLine();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
        );
        writer.close();


    }
}
