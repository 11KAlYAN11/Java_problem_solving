package com.learning.java.files;

import java.io.IOException;
import java.nio.file.*;
import java.util.List;

/**
 * ==========================================================
 * NEW JAVA FILE SYSTEM DEMO (java.nio.file)
 * ==========================================================
 *
 * This program demonstrates modern Java file handling
 * using NIO (introduced in Java 7).
 *
 * Covers:
 * 1. Creating directories
 * 2. Creating files
 * 3. Writing text to file
 * 4. Reading text from file
 * 5. Writing binary data
 * 6. Reading binary data
 * 7. Copying files
 * 8. File properties
 * 9. Listing directory contents
 * 10. Deleting files
 *
 * ==========================================================
 */
public class NewJavaFileSystemDemo {

    public static void main(String[] args) {

        // ------------------------------------------------------
        // 1. DEFINE PATHS (Path replaces java.io.File)
        // ------------------------------------------------------

        // Base directory path
        Path baseDir = Paths.get("new_java_fs_demo");

        // File paths inside the directory
        Path textFile = baseDir.resolve("sample.txt");
        Path binaryFile = baseDir.resolve("sample.bin");
        Path copiedFile = baseDir.resolve("sample_copy.bin");

        try {

            // --------------------------------------------------
            // 2. CREATE DIRECTORY
            // --------------------------------------------------

            // Creates directory ONLY if it does not exist
            if (Files.notExists(baseDir)) {
                Files.createDirectory(baseDir);
                System.out.println("Directory created: " + baseDir);
            } else {
                System.out.println("Directory already exists");
            }

            // --------------------------------------------------
            // 3. CREATE FILE
            // --------------------------------------------------

            // Create file only if it does not exist
            if (Files.notExists(textFile)) {
                Files.createFile(textFile);
                System.out.println("Text file created: " + textFile.getFileName());
            }

            // --------------------------------------------------
            // 4. WRITE TEXT TO FILE (Character data)
            // --------------------------------------------------

            // List of lines to write
            List<String> lines = List.of(
                    "Hello from NEW Java File System!",
                    "This file is written using java.nio.file.Files",
                    "NIO is safer, cleaner, and more powerful"
            );

            // Writes text to file (handles encoding internally)
            Files.write(textFile, lines);
            System.out.println("Text written to file");

            // --------------------------------------------------
            // 5. READ TEXT FROM FILE
            // --------------------------------------------------

            System.out.println("\nReading text file:");

            // Reads all lines from file into memory
            List<String> readLines = Files.readAllLines(textFile);

            for (String line : readLines) {
                System.out.println(line);
            }

            // --------------------------------------------------
            // 6. WRITE BINARY DATA TO FILE
            // --------------------------------------------------

            // Raw binary data (bytes)
            byte[] binaryData = { 65, 66, 67, 68, 69 }; // ABCDE

            // Writes binary data directly
            Files.write(binaryFile, binaryData);
            System.out.println("\nBinary data written");

            // --------------------------------------------------
            // 7. READ BINARY DATA FROM FILE
            // --------------------------------------------------

            System.out.println("\nReading binary file:");

            byte[] readBinary = Files.readAllBytes(binaryFile);

            for (byte b : readBinary) {
                System.out.print(b + " ");
            }
            System.out.println();

            // --------------------------------------------------
            // 8. COPY FILE
            // --------------------------------------------------

            Files.copy(
                    binaryFile,
                    copiedFile,
                    StandardCopyOption.REPLACE_EXISTING
            );

            System.out.println("\nBinary file copied");

            // --------------------------------------------------
            // 9. FILE PROPERTIES
            // --------------------------------------------------

            System.out.println("\nFile Properties:");

            System.out.println("File exists: " + Files.exists(textFile));
            System.out.println("File size: " + Files.size(textFile) + " bytes");
            System.out.println("Readable: " + Files.isReadable(textFile));
            System.out.println("Writable: " + Files.isWritable(textFile));
            System.out.println("Absolute path: " + textFile.toAbsolutePath());

            // --------------------------------------------------
            // 10. LIST DIRECTORY CONTENTS
            // --------------------------------------------------

            System.out.println("\nListing directory contents:");

            try (DirectoryStream<Path> stream = Files.newDirectoryStream(baseDir)) {
                for (Path path : stream) {
                    if (Files.isDirectory(path)) {
                        System.out.println("[DIR ] " + path.getFileName());
                    } else {
                        System.out.println("[FILE] " + path.getFileName());
                    }
                }
            }

            // --------------------------------------------------
            // 11. DELETE FILE (Optional cleanup)
            // --------------------------------------------------

            // Uncomment if you want cleanup
            /*
            Files.deleteIfExists(copiedFile);
            Files.deleteIfExists(binaryFile);
            Files.deleteIfExists(textFile);
            Files.deleteIfExists(baseDir);
            */

        } catch (IOException e) {
            // NIO gives very clear error messages
            e.printStackTrace();
        }
    }
}
