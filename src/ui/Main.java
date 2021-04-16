package ui;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 * @author ALEX JR
 *
 */
public class Main {
	
	static BufferedReader br;
	static BufferedWriter bw;
	
	static ArrayList<Integer> first = new ArrayList<Integer>();
	static ArrayList<Integer> mid = new ArrayList<Integer>();
	static ArrayList<Integer> last = new ArrayList<Integer>();
	
	
	/**
	 * @param disk
	 * @param start
	 * @param temp
	 * @param end
	 * @throws IOException
	 */
	public static void solveHanoi (int disk, ArrayList<Integer> start, ArrayList<Integer> temp, ArrayList<Integer> end) throws IOException {
		if (disk > 0) {
			solveHanoi(disk - 1, start, end, temp);
			end.add(start.remove(start.size()-1));
			bw.write("\n" + first.size() + " " + mid.size() + " " + last.size());
			solveHanoi(disk - 1, temp, start, end);
		}
		
	}	
	

	/**
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		br = new BufferedReader (new FileReader("data/Hanoi_input.txt"));
		bw = new BufferedWriter (new FileWriter("data/Hanoi_output.txt"));

		
		String breakLine = "";
		String line = br.readLine();
		int casesNumber = Integer.parseInt(line);
		
		for (int i = 0; i <casesNumber; i++) {
			line = br.readLine();
			int disk = Integer.parseInt(line);
			first.clear();
			mid.clear();
			last.clear();
			for (int j = disk; j > 0; j--) {
				first.add(j);
			}
			bw.write(breakLine + disk + " " + 0 + " " + 0);
			solveHanoi(disk, first, mid, last);
			breakLine = "\n\n";
		}
		
		br.close();
		bw.close();
		

	}

}
