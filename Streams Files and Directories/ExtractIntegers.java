package StreamsFilesAndDirectories;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

public class ExtractIntegers {
    public static void main(String[] args) throws FileNotFoundException {

    String path = "C:\\Users\\Boychev\\Desktop\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\input.txt";

        FileInputStream inputStream = new FileInputStream(path);

        FileOutputStream outputStream = new FileOutputStream("output.txt");

        PrintStream printStream = new PrintStream(outputStream);

        Scanner scan = new Scanner(inputStream);

        while (scan.hasNext()) {
            if (scan.hasNextInt()) {
                printStream.println(scan.nextInt());
            }


            scan.next();
        }


    }
}
