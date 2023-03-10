package com.techelevator;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileSplitterExample {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.println("what is the path to the file you would like to split? ");
        String pathOfFileToSplit = input.nextLine();

        //ask user how many lines per file they would like
        System.out.println("How many lines per file would you like to write?");
        String numberOfLinePerFile = input.nextLine();

        int maxNumOfLines = Integer.parseInt(numberOfLinePerFile);

        //read in the file
        //create a new File object
        File fileToSplit = new File(pathOfFileToSplit);
        //use scanner to read the file
        try(Scanner fileScanner = new Scanner(fileToSplit)){

            String lineFromScanner = "";
            int numberOfTheFile = 1;
            int lineCount = 1;
            while(fileScanner.hasNextLine()){

                //this is the stuff I want to keep repeating:
                List<String> readFileStrings = new ArrayList<String>();

                while(lineCount <= maxNumOfLines && fileScanner.hasNextLine()){

                    lineFromScanner = lineCount + ") " + fileScanner.nextLine();
                    readFileStrings.add(lineFromScanner);
                    lineCount++;
                }

                //we can add multiple resources in try-with-resource
                String pathName = "dracula" + numberOfTheFile + ".txt";

                try(PrintWriter writer = new PrintWriter(pathName); BufferedWriter buffed = new BufferedWriter(writer)){
                    //use the buffered writer to write to our current file
                    //the string we printed before that we are reading with scanner
                    for(String line : readFileStrings){
                        buffed.write(line);  //writing line from above list to the file
                        buffed.newLine();    //had to manually call carriage return to move to the next line in file
                    }
                    // buffed.write(lineFromScanner);
                } catch (IOException e) {
                    System.out.println("Unexpected error while accessing file");
                }
                //before we check if there are more lines to be read from the file, we increment the numberOfTheFile variable
                numberOfTheFile++;
                maxNumOfLines += maxNumOfLines;
            }

        } catch (FileNotFoundException e) {
            System.out.println("File not found when reading in from: " + fileToSplit.getAbsolutePath());
        }
    }
}
