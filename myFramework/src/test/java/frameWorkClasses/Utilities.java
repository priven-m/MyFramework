package frameWorkClasses;

import java.io.FileWriter;
import java.io.IOException;

public class Utilities extends BasePage{
	
	public void resetOutPutFile (String OutputFileName) {
		try {
			FileWriter myObj = new FileWriter(OutputFileName,false);
			}
		catch (IOException e) {
			System.out.println("An error occured");
			e.printStackTrace();
		}
	}

}
