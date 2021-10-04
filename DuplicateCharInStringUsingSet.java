package ProjectExample2;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class DuplicateCharInStringUsingSet {
    void  FindDuplicate (){
        String str;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the string value to find duplicate");
        str = scanner.nextLine().replaceAll(" ","");
        char [] array = str.toCharArray();
        Set<Character> ch = new HashSet<Character>();
        for (char characters:array) {
            if (!ch.add(characters)){
                System.out.println("The duplicate value is  "+characters);
            }

        }
    }

    public static void main(String[] args) {
        DuplicateCharInStringUsingSet usingSet = new DuplicateCharInStringUsingSet();
        usingSet.FindDuplicate();
    }
}
