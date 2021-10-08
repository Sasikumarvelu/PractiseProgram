package com.company;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

public class FindRandomNumber {
 void RandomNumberCreation(){
    int randomnum,guessnum;
    int rangenum;
     Scanner scanner = new Scanner(System.in);
     System.out.println("Enter the Range value for guessing");
     rangenum = scanner.nextInt();
     Random random = new Random();
     randomnum = random.nextInt(rangenum);
     for (int num=1;num<=rangenum; num++){
     System.out.println("Guess the number between the range value");
     guessnum = scanner.nextInt();
     if(guessnum == randomnum){
         System.out.println("Hurray!!! You guessed the correct number");
         try {
             FileWriter fileWriter = new FileWriter("RandomNumberFile.txt");
             fileWriter.write("Guessed Random Number is : "+ guessnum);
             fileWriter.close();
         } catch (IOException e) {
             System.out.println(" Message = RandomNumberFile is not Created ");
         }
         break;
     }else if(guessnum > randomnum){
         System.out.println("Guessed number is too high , please try again");
     }else if (guessnum  < randomnum){
         System.out.println("Guessed number is too low , please try again");
     }
}
}

    public static void main(String[] args) {
        FindRandomNumber randomNumber = new FindRandomNumber();
        randomNumber.RandomNumberCreation();
    }
}
