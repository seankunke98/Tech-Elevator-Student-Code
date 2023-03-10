package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class SimpleFileReadAndWrite {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("what is the path to the file you would like to read? ");
        String pathOfFileToRead = input.nextLine();

        //read in the file

        //create file object
        File newFile = new File(pathOfFileToRead);


            try(Scanner scanner = new Scanner(newFile); PrintWriter writer = new PrintWriter("Dracula2.txt")){
                while(scanner.hasNextLine()){
                    writer.println(scanner.nextLine());
                }
            }catch(FileNotFoundException ex){
                System.out.println("Sad day. we couldn't find the file at " + newFile.getAbsolutePath());
            }

    }
}
