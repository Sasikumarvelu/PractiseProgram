package ExcelFileConversion;

import ExampleWork.Details;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.json.simple.JSONObject;

import java.io.*;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class ExcelFileToJsonFile {
    String file_Path = "C:\\Users\\dhivakar\\Desktop\\Excel File\\Details.xlsx";
    List list_Data ;
    public void Reading_ExcelFile() {

        FileInputStream inputStream = null;
        try {
            inputStream = new FileInputStream(new File(file_Path));
            XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
            XSSFSheet sheet = workbook.getSheetAt(0);
            Iterator rows = sheet.iterator();
            list_Data = new LinkedList();
            int rowNum = 0;
            while (rows.hasNext()) {
                XSSFRow row = (XSSFRow) rows.next();
                if (rowNum == 0) {
                    rowNum++;
                    continue;
                }
                Iterator cells = row.iterator();
               StudentsList studentsList = new StudentsList();
                int cellIndex = 0;
                while(cells.hasNext()){
                    XSSFCell cell= (XSSFCell) cells.next();
                    if (cellIndex ==0){
                        studentsList.setId((int) cell.getNumericCellValue());
                    }else if(cellIndex == 1){
                        studentsList.setName(cell.getStringCellValue());
                    }else if(cellIndex == 2){
                        studentsList.setAge((int) cell.getNumericCellValue());
                    }else if (cellIndex == 3){
                        studentsList.setMarks((int) cell.getNumericCellValue());
                    }
                    cellIndex ++;
                }
            list_Data.add(studentsList);
            }
      workbook.close();
        }catch (IOException e){
            System.out.println("Alert !!!! File not found in the given path");
        }
    }

public void Create_JsonFile_JsonObject(){
    try {
        JSONObject object = new JSONObject();
        object.put("Personal details",list_Data);
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("Excel_Data.json"));
        bufferedWriter.write(object.toJSONString());
        bufferedWriter.close();
        System.out.println("Json File is created successfully");
    } catch (IOException e) {
        System.out.println("Alert !!!! File is not created");
    }}

    public void Create_JsonFile_objectMapper(){

        try {
            ObjectMapper mapper = new ObjectMapper();
            File file = new File("file_Data.json");
            mapper.writerWithDefaultPrettyPrinter().writeValue(file,list_Data);
            System.out.println("Json File is created successfully");
        } catch (IOException e) {
            System.out.println("Alert !!!! File is not created");
        }
        System.out.println(list_Data);
    }

}







