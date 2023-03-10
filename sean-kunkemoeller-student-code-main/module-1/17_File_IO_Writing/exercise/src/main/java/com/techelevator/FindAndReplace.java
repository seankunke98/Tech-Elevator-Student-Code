package com.techelevator;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class FindAndReplace {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("What word would you like to replace? ");

        String wordToReplace = scanner.nextLine();

        System.out.println("What word would you like to replace it with? ");

        String replacementWord = scanner.nextLine();


        File baconFile = new File("src/test/resources/bacon.txt");
        File newBaconFile = new File("src/test/resources/bacon-emoji.txt");
        try(PrintWriter printWriter = new PrintWriter(baconFile); FileWriter fileWriter = new FileWriter(newBaconFile)){
            FileInputStream fileInputStream = new FileInputStream(baconFile);
            fileInputStream.close();

        } catch (IOException e) {
            e.printStackTrace();
        }



    }

}
