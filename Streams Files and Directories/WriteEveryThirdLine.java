package StreamsFilesAndDirectories;

import java.io.*;

public class WriteEveryThirdLine{
    public static void main(String[] args) throws IOException {

        String path = "C:\\Users\\Boychev\\Desktop\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\input.txt";

        FileInputStream inputStream = new FileInputStream(path);

        InputStreamReader inputStreamReader = new InputStreamReader(inputStream);

        BufferedReader reader = new BufferedReader(inputStreamReader);



        String line = reader.readLine();

        int count = 1;

        while (line != null) {
            if (count % 3 == 0) {
                System.out.println(line);
            }
            count++;


            line = reader.readLine();
        }




    }
}
