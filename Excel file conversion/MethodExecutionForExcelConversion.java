package ExcelFileConversion;

public class MethodExecutionForExcelConversion {
    public static void main(String[] args) {
        ExcelFileToJsonFile excelFileToJsonFile = new ExcelFileToJsonFile();
        excelFileToJsonFile.Reading_ExcelFile();
        excelFileToJsonFile.Create_JsonFile_JsonObject();
        excelFileToJsonFile.Create_JsonFile_objectMapper();
    }
}
