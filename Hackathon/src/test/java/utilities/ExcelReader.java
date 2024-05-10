package utilities;

import java.io.File;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
 
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.ss.util.NumberToTextConverter;
 
public class ExcelReader {
	public static int totalRow;
 
	public List<Map<String, String>> getData(String excelFilePath, String sheetName) throws IOException,InvalidFormatException{
		Workbook workbook = WorkbookFactory.create(new File(excelFilePath));
		Sheet sheet = workbook.getSheet(sheetName);
		workbook.close();
		return readSheet(sheet);
	}
	public List<Map<String, String>> readSheet(Sheet sheet){
		Row row;
		Cell cell;
		totalRow = sheet.getLastRowNum();
		List<Map<String, String>>  excelRows = new ArrayList<Map<String, String>>();
		for(int curRow = 1; curRow<= totalRow; curRow++) {
			row = sheet.getRow(curRow);
			int totalColumn = row.getLastCellNum();
			LinkedHashMap<String, String> columnMapData = new LinkedHashMap<String, String>();
			for(int curColumn = 0; curColumn < totalColumn; curColumn++) {
				cell = row.getCell(curColumn);
				String columnHeaderName = sheet.getRow(sheet.getFirstRowNum()).getCell(curColumn).getStringCellValue();
				if(cell.getCellType() == CellType.STRING) {
					columnMapData.put(columnHeaderName, cell.getStringCellValue());
				}
				else if(cell.getCellType() == CellType.NUMERIC) {
					columnMapData.put(columnHeaderName, NumberToTextConverter.toText(cell.getNumericCellValue()));
				}
			}
			excelRows.add(columnMapData);
		}
		return excelRows;
	}
	public int countRow() {
		return totalRow;	
	}
}