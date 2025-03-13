package Utils;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Exclpract {

	public static String[][] esx() throws IOException {

		FileInputStream fs = new FileInputStream(System.getProperty("user.dir") + "\\testdata\\ReadExcel.xlsx");

		XSSFWorkbook workbook = new XSSFWorkbook(fs);

		XSSFSheet sheet = workbook.getSheetAt(1);

		int totalrows = sheet.getPhysicalNumberOfRows();
		int Totalcells = sheet.getRow(0).getLastCellNum();

		
		String[][] data = new String[totalrows - 1][Totalcells];

		for (int Row = 1; Row < totalrows; Row++) {

			XSSFRow r = sheet.getRow(Row);

			for (int col = 0; col < Totalcells; col++) {

				XSSFCell c = r.getCell(col);

				DataFormatter d = new DataFormatter();

				data[Row-1][col] = d.formatCellValue(c);

			}

		}

		return data;
	}

}
