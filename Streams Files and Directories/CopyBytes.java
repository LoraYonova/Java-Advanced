package StreamsFilesAndDirectories;

import java.io.*;

public class CopyBytes {
    public static void main(String[] args) throws IOException {

        String path = "C:\\Users\\Boychev\\Desktop\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\input.txt";

        FileInputStream inputStream = new FileInputStream(path);

        FileOutputStream outputStream = new FileOutputStream("output.txt");

        PrintStream out = new PrintStream(outputStream);

        int value = inputStream.read();

        while (value != -1) {
            if (value != 32 && value != 10) {
                out.print(value);
            } else {
                out.print((char) value);
            }

            value = inputStream.read();
        }
        outputStream.flush();


    }
}
