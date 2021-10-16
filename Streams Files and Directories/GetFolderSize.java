package StreamsFilesAndDirectories;

import java.io.File;

public class GetFolderSize {
    public static void main(String[] args) {
        String pathStr = "C:\\Users\\Boychev\\Downloads\\1. Sum Lines_Resources\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\Exercises Resources";

        File folder = new File(pathStr);

        File [] filesFolder = folder.listFiles();

        int folderSize = 0;
        for (File file : filesFolder) {
            folderSize += file.length();
        }
        System.out.println("Folder size: " + folderSize);

    }
}
