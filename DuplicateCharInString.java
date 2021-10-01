package com.company;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class DuplicateCharInString {

   public void CharInString() {
       String line;
       Scanner scanner = new Scanner(System.in);
       System.out.println("Enter the string line");
       line = scanner.nextLine();
       HashMap<Character, Integer> map = new HashMap<Character, Integer>();
       char[] array = line.toCharArray();
       for (char character : array) {
           if (map.containsKey(character)) {
               map.put(character, map.get(character) + 1);
           } else {
               map.put(character, 1);
           }
       }
       for (Map.Entry<Character,Integer> entry:map.entrySet()) {
           if(entry.getValue() >= 1){
               System.out.println(entry.getKey() + "=" +  entry.getValue());
           }
       }
   }
       public static void main (String[]args){
           DuplicateCharInString duplicateCharInString = new DuplicateCharInString();
           duplicateCharInString.CharInString();
       }
}
