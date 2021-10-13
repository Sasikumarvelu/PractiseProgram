package RandomNumberExample;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.*;
import java.util.Random;
import java.util.Scanner;

public class FindRandomNum implements TargetMethods{
      int RangeValue, GuessValue;
      int RandomValue;
      Scanner scanner;
      Random random;
      File file;

    @Override
    public void RandomNumberCreation() {
        scanner = new Scanner(System.in);
        System.out.println("Enter the Range value for guessing");
        RangeValue = scanner.nextInt();
        random = new Random();
        RandomValue = random.nextInt(RangeValue);
        if(RangeValue >= 2){
        for (int num=1;num<=RangeValue; num++){
            System.out.println("Guess the correct random number");
            GuessValue = scanner.nextInt();
            if(GuessValue == RandomValue){
                System.out.println("Hurray!!! You guessed the correct number");
                break;
            }else if(GuessValue > RandomValue){
                System.out.println("Guessed number is too high , please try again");
            }else if (GuessValue < RandomValue){
                System.out.println("Guessed number is too low , please try again");
            }
        }
    }else{
            System.out.println("Please enter the Range value greater than 1");
            System.out.println("Please restart the execution");
        }
    }

    @Override
    public void FilePathCreation() {
        System.out.println("Json File Format will be support");
        scanner = new Scanner(System.in);
        System.out.println("Enter the File Name  "+".json");
        String filename = scanner.nextLine();
        String directory = System.getProperty("user.dir");
        String path = directory + File.separator + filename;
        file = new File(path);
        boolean created;
        try {
            created = file.createNewFile();
            if(created){
                System.out.println("File is created successfully   "+file.getCanonicalPath());
            }
        } catch (IOException e) {
            System.out.println("Alert!!!!  File not created on this path "+ path );
        }
    }

    @Override
    public void JsonFileCreation() {
        JSONObject object = new JSONObject();
        object.put("Guessed Number", GuessValue);
        try {
            FileWriter writer = new FileWriter(file);
            writer.write(object.toJSONString());
            writer.close();
            System.out.println("Json File is Created");
        } catch (IOException e) {
            System.out.println("Alert!!!! No File found");
        }

    }

    @Override
    public void FileReading() {
        try {
            JSONParser jsonParser = new JSONParser();
            FileReader reader = new FileReader(file);
            Object parsedObject= jsonParser.parse(reader);
           JSONObject object= (JSONObject) parsedObject;
            Long guessNumber= (Long) object.get("Guessed Number");
            System.out.println("Actual Guessed number is "+guessNumber);

        } catch (FileNotFoundException e) {
            System.out.println("Alert!!!! File not Found");
        } catch (IOException e) {
            System.out.println("Alert!!!! File not Found");
        } catch (ParseException e) {
            System.out.println("Alert!!!! File not Found");
        }
    }


}
