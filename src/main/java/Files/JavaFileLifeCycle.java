package Files;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class JavaFileLifeCycle {
    public static void main(String[] args) {
        // File name
        String fileName = "demoKalyan.txt";

        // 1. Create a file
        createFile(fileName);

        // 2. Write data to the file (overwriting existing content)
        writeToFile(fileName, "This is the initial content of the file.\n");

        // 3. Append data to the file without overwriting
        appendToFile(fileName, "Appending this line to the existing file content.\n");

        // 4. Read and display file content
        readFromFile(fileName);

        // 5. Display file metadata (info about the file)
        displayFileMetadata(fileName);

        // 6. Try to delete the file safely
        deleteFileSafely(fileName);
    }

    /**
     * Creates a file if it does not exist.
     */
    private static void createFile(String fileName) {
        try {
            File myFile = new File(fileName);
            if (myFile.createNewFile()) {
                System.out.println("File created: " + myFile.getName());
            } else {
                System.out.println("File already exists: " + myFile.getName());
            }
        } catch (IOException e) {
            System.out.println("An error occurred during file creation: " + e.getMessage());
        }
    }

    /**
     * Writes content to a file (overwrites existing content).
     */
    private static void writeToFile(String fileName, String content) {
        try (FileWriter writer = new FileWriter(fileName)) { // Use try-with-resources to auto-close the writer
            writer.write(content);
            System.out.println("File written successfully.");
        } catch (IOException e) {
            System.out.println("An error occurred while writing to the file: " + e.getMessage());
        }
    }

    /**
     * Appends content to a file without overwriting the existing content.
     */
    private static void appendToFile(String fileName, String content) {
        try (FileWriter writer = new FileWriter(fileName, true)) { // Pass 'true' to enable appending
            writer.write(content);
            System.out.println("Content appended successfully.");
        } catch (IOException e) {
            System.out.println("An error occurred while appending to the file: " + e.getMessage());
        }
    }

    /**
     * Reads and displays the content of a file line by line.
     */
    private static void readFromFile(String fileName) {
        try {
            File myFile = new File(fileName);
            Scanner reader = new Scanner(myFile);
            System.out.println("File content:");
            while (reader.hasNextLine()) {
                System.out.println(reader.nextLine());
            }
            reader.close();
        } catch (IOException e) {
            System.out.println("An error occurred while reading the file: " + e.getMessage());
        }
    }

    /**
     * Displays metadata about the file.
     */
    private static void displayFileMetadata(String fileName) {
        File myFile = new File(fileName);
        if (myFile.exists()) {
            System.out.println("File Name: " + myFile.getName());
            System.out.println("Absolute Path: " + myFile.getAbsolutePath());
            System.out.println("Writable: " + myFile.canWrite());
            System.out.println("Readable: " + myFile.canRead());
            System.out.println("File Size (bytes): " + myFile.length());
        } else {
            System.out.println("The file does not exist.");
        }
    }

    /**
     * Safely deletes a file, but prevents deletion if the file has content.
     */
    private static void deleteFileSafely(String fileName) {
        File myFile = new File(fileName);
        if (myFile.exists()) {
            if (myFile.length() > 0) { // Check if the file has content
                System.out.println("The file cannot be deleted because it contains content.");
            } else {
                if (myFile.delete()) {
                    System.out.println("The file has been deleted successfully.");
                } else {
                    System.out.println("Failed to delete the file.");
                }
            }
        } else {
            System.out.println("The file does not exist, so it cannot be deleted.");
        }
    }
}
