package StreamsFilesAndDirectories;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

public class WordCount {
    public static void main(String[] args) throws IOException {
        Path pathToWords = Path.of("C:\\Users\\Boychev\\Downloads\\1. Sum Lines_Resources\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\words.txt");
        LinkedHashMap<String, Integer> wordsCount = new LinkedHashMap<>();

        List<String> textAllWords = Files.readAllLines(pathToWords);

        textAllWords.forEach(line -> Arrays.stream(line.split("\\s+")).forEach(word -> wordsCount.put(word, 0)));

        Path pathText = Path.of("C:\\Users\\Boychev\\Downloads\\1. Sum Lines_Resources\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\text.txt");

        List<String> textAllLines = Files.readAllLines(pathText);

        for (String line : textAllLines) {
            String[] wordLine = line.split("\\s+");
            Arrays.stream(wordLine).forEach(word -> {
                if (wordsCount.containsKey(word)) {
                    int currentCount = wordsCount.get(word);
                    wordsCount.put(word, currentCount + 1);
                }
            });
        }
        wordsCount.entrySet().stream().sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()));

        PrintWriter writer = new PrintWriter("output.txt");

        wordsCount.entrySet().forEach(entry -> writer.println(entry.getKey() + " - " + entry.getValue()));

        writer.close();


    }
}
