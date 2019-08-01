// percentage of table to fill
import java.util.*;
import java.io.*;

public class HashTableDemo{

	public static void main(String [] args){

		Scanner sc = new Scanner(System.in);
		File inputFile = new File("Words200D16.txt");

		double tableContents = 0.00;
		List<String> contents = new ArrayList<String>();

		System.out.println("Hello, the hash table will be of size 128.\nTo what percentage will we load the table (Enter 0.50 for 50%)?");
		double loadFactor = sc.nextDouble();
		HashTable table1 = new HashTable(loadFactor);

		try{
			BufferedReader br = new BufferedReader(new FileReader(inputFile));
			String inputLine = br.readLine();


			while(inputLine != null){
				if(table1.getFullness()< loadFactor){
					table1.insertEntry(inputLine);
					contents.add(inputLine);
				}
				else{
					break;
				}
				inputLine = br.readLine();
			}
		}
		catch(Exception e){
			System.out.println("Error: " + e);
		}


		int min = 1000, max = 0, sum = 0;
		for(int i = 0; i < 30; i++){
			int numOfProbes = table1.findEntry(contents.get(i));

			if(numOfProbes < min)
				min = numOfProbes;
			if(numOfProbes > max)
				max = numOfProbes;
			sum += numOfProbes;
		}
		double mean = (double)sum / 30;
		System.out.println("Statistics for first 30 entries: ");
		System.out.println("Min: " + min + "\nMax: " + max + "\nAverage: " + mean +"\n");

		min = 1000;
		max = 0;
		sum = 0;
		for(int i = 0; i < 30; i++){
			int numOfProbes = table1.findEntry(contents.get(contents.size()-i-1));

			if(numOfProbes < min)
				min = numOfProbes;
			if(numOfProbes > max)
				max = numOfProbes;
			sum += numOfProbes;
		}
		mean = (double)sum / 30;
		System.out.println("Statistics for last 30 entries: ");
		System.out.println("Min: " + min + "\nMax: " + max + "\nAverage: " + mean + "\n");

	table1.printTable();
	}
}
