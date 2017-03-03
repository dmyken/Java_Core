package pack;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class LastNumber {

	private  static int lastNumber;
	
	public static int getLastNumber() {
		return lastNumber;
	}

	public static void setLastNumber(List<File> files) throws NumberFormatException, IOException {
		File file = files.stream().reduce((a,b) -> b).orElse(new File("default_file"));
		BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
		String strLine;
		int lastNumber =0 ;
		while((strLine = bufferedReader.readLine())!= null){
			lastNumber =Integer.parseInt(strLine.substring(strLine.length()-32), 2);
		}
		LastNumber.lastNumber = lastNumber;
	}

}
