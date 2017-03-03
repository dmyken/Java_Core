//написати програму яка отримує з командного рядка число N ( 0 < N < 100000) 
//1) шукає всі прості числа з діапазону від 0 до N 
//2) знаходить суму всіх чисел S 
//3) від 0 до S бере всі числа, умовно конкатенує їх в бінарному вигляді 
//4) послідовність біт яка утворилась треба розбити на шматки по 1024 біти 
//5) записати кожен такий шматок в окремий файл 
//6) в кожному файлику знайти кількість паліндромних під послідовностей 
//7) вивести статистику скільки паліндромних послідовностей в кожному файлику в окремий файл 
//8) базуючись на файлах знайти початкове число S

package pack;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import org.omg.Messaging.SyncScopeHelper;

public class Main {
	public static void main(String[] args) throws IOException {
		
		System.out.println("Enter N");
		int array [] = new int [scanner()];
		for (int i = 0; i < array.length; i++) {
			array[i] = i+1;
		}
		while(true){
			System.out.println();
			System.out.println("enter 1 - to find all prime number \n"
					         + "enter 2 - to find sum prime number \n"
					         + "enter 3 - to write number \n"
					         + "enter 4 - to make statistic polidrom \n"
					         + "enter 5 - to get statistic \n"
					         + "enter 6 - to find last number \n"
					         + "enter 7 - Exit");
			
			PrimeNumber primeNumber = new PrimeNumber();
			FileLoading fileLoading = new FileLoading();
			LastNumber lastNumber = new LastNumber();
			
			switch (scanner()) {
			case 1:
				System.out.println("find all prime number");
				primeNumber.setListPrimeNumber(array);
				Arrays.stream(primeNumber.getListPrimeNumber().toArray()).forEach(e -> System.out.print(e+" "));
				break;
			case 2:	
				primeNumber.setSumS(primeNumber.getListPrimeNumber());
				System.out.println(primeNumber.getSumS());
				System.out.println(Integer.toBinaryString(primeNumber.getSumS()));
				break;
			case 3:
				fileLoading.setFiles(primeNumber.getSumS());
				break;
			case 4:
				fileLoading.setStatisticPolidromCount(fileLoading.getFiles());
				break;
			case 5:
				System.out.println(fileLoading.getStatisticPolidromCount());
				break;
			case 6:
				lastNumber.setLastNumber(fileLoading.getFiles());
				System.out.println(lastNumber.getLastNumber());
				break;
			case 7 :
				System.exit(0);
				break;
			default:
				break;
			}
				
		}
		
	}
	
	public static int scanner(){
		return new Scanner(System.in).nextInt();
	}
}
