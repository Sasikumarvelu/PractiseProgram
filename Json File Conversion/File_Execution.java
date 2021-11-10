package JsonToExcelConversion;

public class File_Execution {
    public static void main(String[] args) {
        JsonFileToExcelFile jsonFileToExcelFile = new JsonFileToExcelFile();
        jsonFileToExcelFile.Convert_JsonFile_To_List();
        jsonFileToExcelFile.convert_list_To_ExcelFile();
    }
}
