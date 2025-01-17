package Exceptions;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class CheckedExceptionExample {
    public static void main(String[] args) {
        // Checked Exception
        try {
            /*
             * IOException
                SQLException
                ClassNotFoundException
                InterruptedException
             */
            File file = new File("NonExistant.txt");
            Scanner scanner = new Scanner(file);
        }
        catch (FileNotFoundException e) {
            System.out.println("Hai File Not Found Exception");
            System.out.println(e.getMessage());
        }
    }
}
