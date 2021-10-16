package StreamsFilesAndDirectories;

import java.io.FileInputStream;

import java.io.FileOutputStream;
import java.io.IOException;
;
import java.io.OutputStream;
import java.util.Set;

public class WriteToFile {
    public static void main(String[] args) throws IOException {

        String path = "C:\\Users\\Boychev\\Desktop\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\input.txt";

        FileInputStream inputStream = new FileInputStream(path);
        FileOutputStream outputStream = new FileOutputStream("output.txt");

        int value = inputStream.read();

        Set<Character> punctuations = Set.of(',', '.', '!', '?');

        while (value != -1) {
            char current = (char) value;
            if (!punctuations.contains(current)) {
                outputStream.write(current);
                //System.out.print(current);

            }
            value = inputStream.read();

        }
        outputStream.close();


    }
}
