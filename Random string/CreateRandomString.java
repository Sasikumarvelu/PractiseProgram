package GetRandomString;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import static java.lang.StrictMath.random;

public class CreateRandomString {
    File file;
    Scanner scanner;
    StringBuilder stringBuilder;
    BufferedWriter bufferedWriter;
    String GetString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"+"abcdefghijklmnopqrstuvwxyz"+"1234567890"+"!@#$%&*";
    int line;
    void ToGetFilename(){
        scanner = new Scanner(System.in);
        System.out.println("Enter the file name "+" .txt");
        String filename = scanner.nextLine();
        String directory = System.getProperty("user.dir");
        String path = directory + File.separator + filename;
        file = new File(path);
        boolean created;
        try {
            created = file.createNewFile();
            if(created){
                System.out.println("File is created successfully" +file.getCanonicalPath());
            }
        } catch (IOException e) {
            System.out.println("Message = File not created on this path "+ path );
        }
    }
    void ToGetRandomString(){
        System.out.println("Enter the Number of line to get random string");
        line = scanner.nextInt();
        try {
            bufferedWriter = new BufferedWriter(new FileWriter(file));
        } catch (IOException e) {
            System.out.println("Alert !!!! File not Found ");
        }
        for (int numOfLines =1; numOfLines<=line; numOfLines++) {
            stringBuilder = new StringBuilder();
            for (int Char = 0; Char < 100; Char++) {
               int index = (int) (GetString.length() * random());
                stringBuilder.append(GetString.charAt(index));
            }
            String random = stringBuilder.toString();
            System.out.println(random +" "+ random.length());
            try {
                bufferedWriter.write(String.valueOf( numOfLines  +" "+ random));
                bufferedWriter.newLine();
                bufferedWriter.flush();
            } catch (IOException e) {
                System.out.println("Alert !!!! File not Found ");
            }
        }
        if(bufferedWriter!=null){
            try {
                bufferedWriter.close();
                System.out.println("Random String File is created");
            } catch (IOException e) {
                System.out.println("Alert !!!! File not Found ");
            }
        }
    }
}
