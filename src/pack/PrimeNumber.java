package pack;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class PrimeNumber {
	
	private static List<Integer> listPrimeNumber;
	
	private static int sumS;

	public List<Integer> getListPrimeNumber() {
		return listPrimeNumber;
	}
	
	//sieve of Eratosthenes
	public void setListPrimeNumber(int[] array) {
		System.out.println();
		List<Integer> list = new LinkedList<Integer>();
		list.add(array[0]); 
		list.add(array[1]);
		int [] a = array;
		for (int i = 2; i < array.length/2+1; i++) {
		a = Arrays.stream(a).filter((p) -> p%list.get(list.size()-1) != 0 && (double)p/list.get(list.size()-1) > 1 ).toArray();

		if(a.length != 0){
		list.add(a[0]);
		} else{
			break;
		}
		}
		list.stream().forEach(System.out::println);
		System.out.println(list.stream().count());
		
		this.listPrimeNumber = list;
	}

	public int getSumS() {
		return sumS;
	}

	//Sum
	public void setSumS(List<Integer> list) {
		this.sumS = list.stream().reduce((a,b) -> a+b).orElse(0);
	}

}
