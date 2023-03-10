package com.techelevator.scanner;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Locale;
import java.util.Scanner;

public class FileReaderExample {

    public static void main(String[] args) {

        //get path from user
        System.out.println("Please tell us the path of the file you want to read.");
        // set up a scanner to get input from user
        Scanner input = new Scanner(System.in);
        String path = input.nextLine();

        File file = new File(path);

        try(Scanner fileScanner = new Scanner(file)){
            int lineCount = 1;
            while(fileScanner.hasNextLine()){
                String lineFromFile = fileScanner.nextLine();
                System.out.println(lineCount + " ) " + lineFromFile.replace("a", "XXXXXX"));
                lineCount++;
            }
        } catch (FileNotFoundException ex){
            System.out.println("File " + file.getAbsolutePath() + " was not found.");
        }finally {
            System.out.println("We had an idea for something here");
        }
    }
}
