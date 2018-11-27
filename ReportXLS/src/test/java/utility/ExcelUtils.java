package utility;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {
	private static XSSFSheet ExcelWSheet;	 
    private static XSSFWorkbook ExcelWBook;
    private static XSSFCell Cell;
    private static XSSFRow Row;

    /**
     * This method is used to set the File path and to open the Excel file
     * @param Path --Path to xls file
     * @param SheetName --Sheet name
     * @throws Exception
     */
    public static void setExcelFile(String Path,String SheetName) throws Exception {
    	try {
    		// Open the Excel file
    		FileInputStream ExcelFile = new FileInputStream(Path);

    		// Access the required test data sheet
    		ExcelWBook = new XSSFWorkbook(ExcelFile);
    		ExcelWSheet = ExcelWBook.getSheet(SheetName);

    	} catch (Exception e){
    		throw (e);
    	}
    }

    /**
     * This method is used to read the test data from the Excel cell
     * @param RowNum -- Row number
     * @param ColNum -- Column number
     * @return -- returns Cell data
     * @throws Exception
     */
    public static String getCellData(int RowNum, int ColNum) throws Exception{
    	try{
    		Cell = ExcelWSheet.getRow(RowNum).getCell(ColNum);
    		String CellData = Cell.getStringCellValue();
    		return CellData;

    	}catch (Exception e){
    		return"";
    	}
    }

    /**
     * This method is used to write in the Excel cell
     * @param Result -- String to write in the xl file
     * @param RowNum -- Row number
     * @param ColNum -- Column number
     * @throws Exception
     */
    public static void setCellData(String Result,  int RowNum, int ColNum) throws Exception {
    	try{
    		Row  = ExcelWSheet.getRow(RowNum);
    		Cell = Row.getCell(ColNum);
    		if (Cell == null) {
    			Cell = Row.createCell(ColNum);
    			Cell.setCellValue(Result);
    		} else {
    			Cell.setCellValue(Result);
    		}

    		// Constant variables Test Data path and Test Data file name
    		FileOutputStream fileOut = new FileOutputStream(XLPath.Path_TestData + XLPath.File_TestData);
    		
    		ExcelWBook.write(fileOut);
    		fileOut.flush();
    		fileOut.close();
    	}catch(Exception e){
    		throw (e);
    	}
    }
}
