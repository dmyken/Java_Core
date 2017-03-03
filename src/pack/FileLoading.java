package pack;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutput;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStream;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;
import java.util.stream.Stream;

public class FileLoading {

	private static List<File> files;
	
	private static Map<File,Integer> statisticPolidromCount;

	public  List<File> getFiles() {
		return files;
	}

	public  void setFiles(int S) throws IOException {
		int [] array = new int [S];
		for (int i = 0; i < array.length; i++) {
			array[i]=i+1;
		}
		List<File> files = new ArrayList<>();
		int count = getCountFiles(array);
		for (int i = 0; i < count; i++) {
			System.out.println("Enter file name");
			File file = new File(scanner());
			DataOutputStream dataOutput = new DataOutputStream(new FileOutputStream(file));
			Arrays.stream(array).skip(i*32).limit(32).forEach(e -> {
				try {System.out.println(e);
					dataOutput.writeBytes(String.format("%32s", Integer.toBinaryString(e)).replace(' ', '0'));
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			});
			dataOutput.close();
			files.add(file);
		}
		FileLoading.files = files;
	}
	
	
	public static Map<File, Integer> getStatisticPolidromCount() {
		return statisticPolidromCount;
	}

	public static void setStatisticPolidromCount(List<File> files) throws IOException {
		Map<File, Integer> map = new LinkedHashMap<>();
		for (File file : files) {
			BufferedReader reader = new BufferedReader(new FileReader(file));
			String line = null;
			int countPolidrom = 0;
			StringBuilder stringBuilder = new StringBuilder();
			while((line = reader.readLine())!= null){
				stringBuilder.append(line);
			}
			int count =0;
			for (int i = 5; i < stringBuilder.length(); i++) {
				int countdigitMax = i;
				String [] strArray = new  String [stringBuilder.length()-i];
				for (int j = 0; j < stringBuilder.length()-i; j++) {
					int countdigitMin = j;
					strArray[j]=stringBuilder.toString().substring(countdigitMin,countdigitMax+countdigitMin);
				}
				count=(int) Arrays.stream(strArray).filter(str -> str.equals(new StringBuilder(str).reverse().toString())).count();
				countPolidrom =countPolidrom + count;
			}
			map.put(file, countPolidrom);
		}
		FileLoading.statisticPolidromCount = map;
	}

	public int getCountFiles(int [] array){
		int count =0;
		if(array.length%32 ==0){
			count = array.length/32;
		}else{
			count = array.length/32+1;
		}
		return count;
	}
	
	public String scanner(){
		return new Scanner(System.in).next();
	}
	
}
