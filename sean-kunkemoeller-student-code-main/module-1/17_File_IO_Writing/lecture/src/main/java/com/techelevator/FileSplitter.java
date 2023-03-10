package com.techelevator;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileSplitter {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.println("what is the path to the file you would like to split? ");
        String pathOfFileToSplit = input.nextLine();

        //ask user how many lines per file they would like
        System.out.println("How many lines per file would you like to write? ");

        String numberOfLinesPerFile = input.nextLine();

        int numOfLines = Integer.parseInt(numberOfLinesPerFile);

        //read in the file
        //create new File object
        File fileToSplit = new File(pathOfFileToSplit);
        //use scanner object to read the file
        try(Scanner fileScanner = new Scanner(fileToSplit)){
            int lineCount = 1;
            String lineFromScanner = "";
            int numberOfTheFile = 1;
            while(fileScanner.hasNextLine()){
                //this is the stuff I want to keep repeating
                List<String> readFileStrings = new ArrayList<String>();
                while(fileScanner.hasNextLine() && lineCount <= numOfLines) {
                    lineFromScanner = lineCount + ") " + fileScanner.nextLine();
                    readFileStrings.add(lineFromScanner);
                    lineCount++;
                }
                String pathName = "dracula" + numberOfTheFile + ".txt";
                try(PrintWriter writer = new PrintWriter("dracula2.txt"); BufferedWriter buffed = new BufferedWriter(writer)){
                    for(String line : readFileStrings) {
                        buffed.write(line);
                        buffed.newLine();
                    }
                } catch (IOException e){
                    System.out.println();
                }
                numberOfTheFile++;
            }
        } catch (FileNotFoundException e) {
            System.out.println("FIle not found when reading in from: " + fileToSplit.getAbsolutePath());
        }
    }
}
