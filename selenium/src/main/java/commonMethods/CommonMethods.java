package commonMethods;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Paths;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.json.JSONObject;
import org.json.JSONTokener;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

import globalVariables.GlobalVariables;

public class CommonMethods {

	public static void takeScreenshot(WebDriver webdriver, String testCaseName) {
		// toma el screenshot de la pagina
		File scrFile = ((TakesScreenshot) webdriver).getScreenshotAs(OutputType.FILE);

		// establecer ruta donde se guarda el screenshot
		String screenshotPath = Paths.get("").toAbsolutePath().toString() + File.separator + "test-output"
				+ File.separator + "ExecutionResult";

		try {
			FileHandler.createDir(new File(screenshotPath)); // crea el folder usando la ruta especificada del string
																// screenshotpath
			FileHandler.copy(scrFile, new File(screenshotPath + File.separator + testCaseName + ".png")); // copiamos el
																											// screenshot
																											// a la ruta
																											// creada
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static String getJSONValue(String jsonFileObj, String jsonKey) {
		try {
			// Json datos
			InputStream inputStream = new FileInputStream(GlobalVariables.PATH_JSON_DATA + jsonFileObj + ".json");

			JSONObject jsonObject = new JSONObject(new JSONTokener(inputStream));

			// Obtener el dato deseado
			String jsonValue = (String) jsonObject.getJSONObject(jsonFileObj).get(jsonKey);
			return jsonValue;
		} catch (FileNotFoundException e) {
			//Assert.fail("JSON File is not found");
			return null;
		}
	}

	public static String getCellData(String excelName, int row, int column) {
		try {
			// ruta excel
			InputStream inputStream = new FileInputStream(GlobalVariables.PATH_EXCEL_DATA + excelName + ".xls");

			// construir un objeto XSSFWorkbook
			Workbook wb = new XSSFWorkbook(inputStream);

			Sheet sheet = wb.getSheetAt(0);
			Row rowObj = sheet.getRow(row);
			Cell cell = rowObj.getCell(column);
			String value = cell.getStringCellValue();

			return value;

		} catch (FileNotFoundException e) {
			return null;
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}

}
