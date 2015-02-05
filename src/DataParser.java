import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
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
		processFile();
	}
	
	public static void processFile() throws IOException {
		File inputFile = new File(inputFileName);
		File outputFile = new File(outputFileName);
		if(!outputFile.exists()) {
			outputFile.createNewFile();
		}
		
		FileWriter fw = new FileWriter(outputFile.getAbsoluteFile());
		BufferedWriter bw = new BufferedWriter(fw);
		
		
		
		
		bw.close();
	}
}
