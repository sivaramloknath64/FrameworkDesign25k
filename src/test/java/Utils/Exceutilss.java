package Utils;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Exceutilss {

	public String[][] ExcelReader() throws IOException {

		// String[][] data = null;
		FileInputStream file = new FileInputStream(System.getProperty("user.dir") + "\\testdata\\ReadExcel.xlsx");

		XSSFWorkbook workbook = new XSSFWorkbook(file);

		XSSFSheet sheet = workbook.getSheetAt(1);

		int Totalrows = sheet.getPhysicalNumberOfRows();
		int TotalCells = sheet.getRow(0).getLastCellNum();

		String[][] data = new String[Totalrows - 1][TotalCells];

		for (int row = 1; row < Totalrows; row++) {

			XSSFRow Rows = sheet.getRow(row);

			for (int col = 0; col < TotalCells; col++) {
				DataFormatter d = new DataFormatter();
				XSSFCell cell = Rows.getCell(col);

				data[row-1][col] = d.formatCellValue(cell);

				// System.out.println(d.formatCellValue(cell));

			}

		}

		return data;
	}

}
