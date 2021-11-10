package JsonToExcelConversion;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

public class JsonFileToExcelFile {
    List<Marks_List> data;

    public void Convert_JsonFile_To_List() {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            data = List.of(objectMapper.readValue(Paths.get("file_Data.json").toFile(),Marks_List[].class));
        } catch (IOException e) {
            System.out.println("Alert !!! File not found in the path");
        }
        data.forEach(System.out::println);
    }
    public void convert_list_To_ExcelFile(){
        String [] columns = {"ID","NAME","AGE","MARKS"};
        XSSFWorkbook xssfWorkbook = new XSSFWorkbook();
        //CreationHelper helper = xssfWorkbook.getCreationHelper();
        XSSFSheet sheet = xssfWorkbook.createSheet("Students_ListData");

        Font font = xssfWorkbook.createFont();
        font.setBold(true);
        font.setItalic(true);
        font.setColor(IndexedColors.AQUA.getIndex());

        XSSFCellStyle CellStyle = xssfWorkbook.createCellStyle();
        CellStyle.setFont(font);
        Row row =sheet.createRow(0);
        for (int col=0;col<columns.length;col++){
           Cell cell = row.createCell(col);
           cell.setCellValue(columns[col]);
           cell.setCellStyle(CellStyle);
        }
       /* CellStyle ageCellStyle = xssfWorkbook.createCellStyle();
        ageCellStyle.setDataFormat(helper.createDataFormat().getFormat("#"));*/
        int rowIndexValue = 1;
        for (Marks_List list:data) {
            XSSFRow xssfRow = sheet.createRow(rowIndexValue++);
            xssfRow.createCell(0).setCellValue(list.getId());
            xssfRow.createCell(1).setCellValue(list.getName());
            xssfRow.createCell(2).setCellValue(list.getAge());
            xssfRow.createCell(3).setCellValue(list.getMarks());
        }

        try {
            FileOutputStream outputStream = new FileOutputStream("C:\\Users\\dhivakar\\Desktop\\Excel File\\StudentsListData.xlsx");
            xssfWorkbook.write(outputStream);
            outputStream.close();
            xssfWorkbook.close();
            System.out.println("Excel sheet is successfully created in the given path");
        }
         catch (IOException e) {
            System.out.println("Alert !!!! File not found");
        }
    }
}