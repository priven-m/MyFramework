package takeAlotTests;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import frameWorkClasses.ReadExcel;
import frameWorkClasses.Utilities;

public class ReadFromExcelPLay {

	ReadExcel rExcel = new ReadExcel();
	Utilities uts = new Utilities();

	String OutputDirectory = uts.getDataConfigPropeties("OutputDir");
	String outputFile = OutputDirectory + "newFile1.txt";

	@BeforeTest
	public void setup() {
		uts.resetOutPutFile(outputFile);
	}

	@DataProvider(name = "Brand and Quantity")
	public Object[][] getDataFromExcel() {
		String exceDirectory = rExcel.getDataConfigPropeties("excelTestData");
		Object[][] errObj = rExcel.getExcelData(exceDirectory + "myTestData.xlsx", "Sheet1");
		return errObj;
	}

	@Test(dataProvider = "Brand and Quantity")
	public void BrandAndQuantityString(String brand, String quantity) {
		System.out.println(brand + " " + quantity);
	}

	@Test(dataProvider = "Brand and Quantity")
	public void BrandQuantityString(String brand, String quantity) {
		boolean bool = true;

		String result;
		if (bool) {
			result = "";
		} else {
			result = "";
		}

		String content = brand + "," + quantity + "," + result;

		try {
			Files.write(Paths.get(outputFile), (content + System.lineSeparator()).getBytes(), StandardOpenOption.CREATE,
					StandardOpenOption.APPEND);
		} catch (IOException e) {
			System.out.println("the error is: " + e.getMessage());
		}
	}
}