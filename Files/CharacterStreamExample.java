package Files;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class CharacterStreamExample {
    public static void main(String[] args) {
        String inputFilePath = "inputFilePath1.txt";
        String outputFilePath = "outputFilePath1.txt";

        // Write text to a file
        writeTextToFile(inputFilePath, "Hello, this is sample data inserting to Java character stream \n Hello kalyan \n Hi how are you all");

        // Read data from a file
        readTextFromFile(inputFilePath);

        // Copy text from one file to another
        copyTextFile(inputFilePath, outputFilePath);

        // To count no.of lines, characters, words in a file
        countFileContent(inputFilePath);

    }
    /**
     * Writes text to a file using FileWriter.
     */
    private static void writeTextToFile(String filePath, String content) {
        try(FileWriter writer = new FileWriter(filePath)) {
            writer.write(content);
            System.out.println("Text Written to: "+filePath);
        } catch(IOException e) {
            System.out.println("Error while writing a file: "+e.getMessage());
        }
    }
     /**
     * Reads text from a file using FileReader.
     */
    private static void readTextFromFile(String filePath) {
        try(FileReader reader = new FileReader(filePath)) {
            //char c;
            int character;
            while((character = reader.read()) != -1) {
                System.out.print((char)character); // no \n cuz each character will print in new line (Not good view)
            }
        } catch(IOException e) {
            System.out.println("Error while reading the data: "+e.getMessage());
        }
    }
    /**
     * Copies text from one file to another using Buffered Streams.
     */
    private static void copyTextFile(String srcPath, String desPath) {
        try(BufferedReader br = new BufferedReader( new FileReader(srcPath));
        BufferedWriter bw = new BufferedWriter( new FileWriter(desPath))) {
            String line;
            while ((line = br.readLine()) != null) { //as bufferedReader is String type no -1 only null
                bw.write(line);
                bw.newLine(); // Write a new line afyer each line
            }
            System.out.println("\nSuccessfully copied content from: "+srcPath+ " to "+desPath);
        } catch(IOException e) {
            System.out.println("An Error occured while copying content: "+e.getMessage());
        }
    }
    /**
     * Counts lines, words, and characters in a file.
     */
    private static void countFileContent(String filePath) {
        try(BufferedReader br = new BufferedReader( new FileReader(filePath))) {
            int lineCount=0, wordCount = 0, charCount = 0;
            String line;
            while((line = br.readLine()) != null) {
                lineCount++;
                charCount += line.length();  // Count characters in the line
                wordCount += line.split("\\s+").length; // Split by spaces to count words why length whynot length() bcz when splitted it forms an array as array, so to find array length length only;
            }
            System.out.println("File Content Statistics for " + filePath + ":");
            System.out.println("Lines: " + lineCount);
            System.out.println("Words: " + wordCount);
            System.out.println("Characters: " + charCount);
        } catch(IOException e) {
            System.out.println("An error occured while counting: "+e.getMessage());
        }
    }

}
