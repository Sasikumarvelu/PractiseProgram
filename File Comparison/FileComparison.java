package ComparisonOfFile;

import org.json.simple.JSONObject;
import java.io.*;

public class FileComparison  {
    String firstFilePath = "C:\\Users\\dhivakar\\Desktop\\FileOne\\FileOne.txt";
    String secondFilePath = "C:\\Users\\dhivakar\\Desktop\\FileOne\\FileTwo.txt ";
    boolean fileAreEqual;
    int lineNumber,WordCount;
    String lineOne,lineTwo;
    protected void compareFile(){
        try {
            BufferedReader readerOne = new BufferedReader(new FileReader(firstFilePath));
            BufferedReader readerTwo = new BufferedReader(new FileReader(secondFilePath));
             lineOne = readerOne.readLine();
             lineTwo = readerTwo.readLine();
            fileAreEqual= true;
            lineNumber = 1;
            while (lineOne != null || lineTwo != null) {
                if(lineOne == null || lineTwo == null) {
                    fileAreEqual = false;
                    break;
                }
                else if(! lineOne.equalsIgnoreCase(lineTwo)) {
                    fileAreEqual = false;
                    break;
                }
                lineOne = readerOne.readLine();
                lineTwo = readerTwo.readLine();
                lineNumber++;
            }
            readerOne.close();
            readerTwo.close();
        } catch (FileNotFoundException e) {
            System.out.println("Alert!!!! File not Found");
        } catch (IOException e) {
            System.out.println("Alert!!!! File not Found");
        }
    }
     protected void ToFindTotalNumOfWords(){
        if(fileAreEqual){
            System.out.println("The Content in file are same");
            WordCount=0;
            try {
                BufferedReader readerOne = new BufferedReader(new FileReader(firstFilePath));
                while((lineOne = readerOne.readLine()) != null) {
                    String NumOfWords[] = lineOne.split(" ");
                    WordCount = WordCount + NumOfWords.length;
                }
                System.out.println("Total Words in given file is : "+WordCount);

                System.out.println("Word Count is Successfully Executed");

                readerOne.close();
            } catch (FileNotFoundException e) {
                System.out.println("Alert!!!! File not Found");
            } catch (IOException e) {
                System.out.println("Alert!!!! File not Found");}
        }else {
            System.out.println("Two files have different content. They differ at line "+lineNumber);

            System.out.println("FirstFile has "+lineOne+" and SecondFile has "+lineTwo+" at line "+lineNumber);
        }
    }
    protected void JsonFileCreation(){
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("Total Number of words",WordCount);
        try {
            FileWriter writer = new FileWriter("File.json");
            writer.write(jsonObject.toJSONString());
            writer.close();
            System.out.println("JSON File is Created");
        } catch (IOException e) {
            System.out.println("Alert!!!! File not Found");
        }
    }
}
