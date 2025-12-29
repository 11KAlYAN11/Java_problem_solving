package com.learning.java.files;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * ==========================================================
 * OLD JAVA FILE SYSTEM DEMO (java.io)
 * ==========================================================
 *
 * This program demonstrates ALL common file operations
 * using OLD Java I/O APIs (before java.nio.file).
 *
 * Covered Topics:
 * 1. Creating directories
 * 2. Creating files
 * 3. Writing text using FileWriter
 * 4. Reading text using FileReader & BufferedReader
 * 5. Writing binary data using FileOutputStream
 * 6. Reading binary data using FileInputStream
 * 7. Copying files using byte streams
 * 8. File properties (exists, size, permissions)
 * 9. Listing files in a directory
 * 10. Deleting files
 *
 * ==========================================================
 */
public class OldJavaFileSystemDemo {

    public static void main(String[] args) {

        // Base directory name
        String dirName = "old_java_fs_demo";

        // File names
        String textFileName = "sample.txt";
        String binaryFileName = "sample.bin";
        String copiedFileName = "sample_copy.bin";

        // ------------------------------------------------------
        // 1. CREATE DIRECTORY
        // ------------------------------------------------------
        File directory = new File(dirName);

        if (!directory.exists()) {
            boolean created = directory.mkdir();
            System.out.println("Directory created: " + created);
        } else {
            System.out.println("Directory already exists");
        }

        // ------------------------------------------------------
        // 2. CREATE TEXT FILE
        // ------------------------------------------------------
        File textFile = new File(directory, textFileName);

        try {
            if (textFile.createNewFile()) {
                System.out.println("Text file created: " + textFile.getName());
            } else {
                System.out.println("Text file already exists");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // ------------------------------------------------------
        // 3. WRITE TEXT TO FILE (Character Stream)
        // ------------------------------------------------------
        try (FileWriter writer = new FileWriter(textFile)) {

            writer.write("Hello Java Old File System!\n");
            writer.write("This is written using FileWriter.\n");
            writer.write("Each character is written one by one internally.\n");

            System.out.println("Text written successfully.");

        } catch (IOException e) {
            e.printStackTrace();
        }

        // ------------------------------------------------------
        // 4. READ TEXT FROM FILE (BufferedReader)
        // ------------------------------------------------------
        System.out.println("\nReading text file:");

        try (BufferedReader reader =
                     new BufferedReader(new FileReader(textFile))) {

            String line;

            // Read file line by line
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        // ------------------------------------------------------
        // 5. WRITE BINARY DATA TO FILE (Byte Stream)
        // ------------------------------------------------------
        File binaryFile = new File(directory, binaryFileName);

        try (FileOutputStream fos = new FileOutputStream(binaryFile)) {

            // Binary data (raw bytes)
            byte[] data = { 10, 20, 30, 40, 50, 65, 66, 67 };

            fos.write(data);

            System.out.println("\nBinary data written to file.");

        } catch (IOException e) {
            e.printStackTrace();
        }

        // ------------------------------------------------------
        // 6. READ BINARY DATA FROM FILE
        // ------------------------------------------------------
        System.out.println("\nReading binary file:");

        try (FileInputStream fis = new FileInputStream(binaryFile)) {

            int byteValue;

            while ((byteValue = fis.read()) != -1) {
                System.out.print(byteValue + " ");
            }

            System.out.println();

        } catch (IOException e) {
            e.printStackTrace();
        }

        // ------------------------------------------------------
        // 7. COPY FILE USING BYTE STREAMS
        // ------------------------------------------------------
        File copiedFile = new File(directory, copiedFileName);

        try (
                BufferedInputStream bis =
                        new BufferedInputStream(new FileInputStream(binaryFile));
                BufferedOutputStream bos =
                        new BufferedOutputStream(new FileOutputStream(copiedFile))
        ) {

            int data;

            while ((data = bis.read()) != -1) {
                bos.write(data);
            }

            System.out.println("\nBinary file copied successfully.");

        } catch (IOException e) {
            e.printStackTrace();
        }

        // ------------------------------------------------------
        // 8. FILE PROPERTIES
        // ------------------------------------------------------
        System.out.println("\nFile Properties:");

        System.out.println("File exists: " + textFile.exists());
        System.out.println("File size: " + textFile.length() + " bytes");
        System.out.println("Readable: " + textFile.canRead());
        System.out.println("Writable: " + textFile.canWrite());
        System.out.println("Absolute path: " + textFile.getAbsolutePath());

        // ------------------------------------------------------
        // 9. LIST FILES IN DIRECTORY
        // ------------------------------------------------------
        System.out.println("\nListing directory contents:");

        File[] files = directory.listFiles();

        if (files != null) {
            for (File file : files) {
                System.out.println(
                        (file.isDirectory() ? "[DIR] " : "[FILE] ") +
                                file.getName()
                );
            }
        }

        // ------------------------------------------------------
        // 10. DELETE FILE (optional cleanup)
        // ------------------------------------------------------
        // Uncomment if you want auto cleanup
        /*
        boolean deleted = copiedFile.delete();
        System.out.println("\nCopied file deleted: " + deleted);
        */
    }
}
