package com.learning.java.files;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class ByteStreamsExample {
    public static void main(String[] args) {
        String inputFilePath = "inputFile.bin";
        String outputFilePath = "outputFile.bin";
        
        // 1. Write binary data to a file
        writeBinaryDate(inputFilePath);

        // 2. Read binary data from the file
        readBinaryDate(inputFilePath);

        // 3. Copy binary data from inputFile to outputFile
        copyBinaryFile(inputFilePath, outputFilePath);
    }
   /**
     * Writes binary data to a file using FileOutputStream.
     */
    private static void writeBinaryDate(String filePath) {
        try(FileOutputStream fos = new FileOutputStream(filePath)) {
            //Example binary data
            byte[] binaryData = {65, 66, 67, 68, 69};  //Represents ABCDE
            fos.write(binaryData); //writing the data to the file
            System.out.println("Binary data written to: "+filePath);
        } catch(IOException e) {
            System.out.println("Error Occured while writing binary data: "+e.getMessage());
        }
    } 
    /**
     * Reads binary data from a file using FileInputStream.
     */
    private static void readBinaryDate(String filePath) {
        try(FileInputStream fis = new FileInputStream(filePath)) {
            System.out.println("Reading the Binary data from: "+filePath);
            int byteData;
            while((byteData = fis.read()) != -1) {
                System.out.println((char) byteData + " "); // Print as characters
            }
            System.out.println();
        } catch(IOException e) {
            System.out.println("An error occured: "+e.getMessage());
        }
    }
    /**
     * Copies binary data from one file to another using Buffered Streams.
     */
    private static void copyBinaryFile(String srcPath, String desPath) {
        try(BufferedInputStream bis = new BufferedInputStream( new FileInputStream(srcPath));
        BufferedOutputStream bos = new BufferedOutputStream( new FileOutputStream(desPath))) {
            int byteData;
            while((byteData = bis.read()) != -1) {
                bos.write(byteData);
            }
            System.out.println("Binary file copied from "+srcPath+" to "+desPath);
        } catch(IOException e) {
            System.out.println("An error occured: "+e.getMessage());
        }
    }
}
