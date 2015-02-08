import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class DataParser {
	static String inputFileName;
	static String outputFileName;
	
	public static void main(String[] args) throws IOException {
		inputFileName = args[0];
		outputFileName = args[1];
		System.out.println("Beginning Data Parsing...");
		processFile();
		System.out.println("Data Parsing Complete!");
	}
	
	public static void processFile() throws IOException {
		File inputFile = new File(inputFileName);
		File outputFile = new File(outputFileName);
		if(!outputFile.exists()) {
			outputFile.createNewFile();
		}
		
		FileWriter fw = new FileWriter(outputFile.getAbsoluteFile());
		BufferedWriter bw = new BufferedWriter(fw);
		
		FileReader fr = new FileReader(inputFile.getAbsoluteFile());
		BufferedReader br = new BufferedReader(fr);
		
		String currentLine;
		
		currentLine = br.readLine();
		currentLine += ",Ft1,Ft2,Ft3,Ft4,Ft5,Ft6,Ft7,Ft8";
		bw.write(currentLine);
		bw.newLine();
		
		while((currentLine = br.readLine()) != null) {
			List<String> dataRow = Arrays.asList(currentLine.split(","));
			Board board = new Board(6, 7, 4, dataRow);
			currentLine += "," + Eval.ef1(board) + "," + Eval.ef2(board) + "," + Eval.ef3(board) + "," + Eval.ef4(board) + "," + Eval.ef5(board) + "," + Eval.ef6(board) + "," + Eval.ef7(board) + "," + Eval.ef8(board);
			bw.write(currentLine);
			bw.newLine();
		}
		
		br.close();
		bw.close();
	}

	private static int ftr() {
		return (int)(Math.random() * 100);
	}
}
