package dataFile;

import java.util.Scanner;
import java.util.ArrayList;
import java.io.File;
import java.io.FileNotFoundException;

public class ReadInfo {

	private Scanner input;
	private ArrayList<String> field = new ArrayList<String>();
	private ArrayList<Integer> position = new ArrayList<Integer>();
	private ArrayList<String> type = new ArrayList<String>();
	private String[] content;
	private String str;
	
	public void readLayout(){
		
		try {
			input = new Scanner(new File("LayoutFormat.txt"));
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		}
		
		while(input.hasNext()){
			
			str = input.nextLine();
			
			content = str.split("|");
			field.add(content[0]);
			position.add(Integer.parseInt(content[1]));
			type.add(content[2]);
		}
	}
	
	public void logInfo(){
		
		
	}
	
	public void readFile(){
		
		try {
			input = new Scanner(new File("records.txt"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		for(int i = 0; i < field.size(); i++){
			
			str = input.nextLine();
			
			content = str.split("|");
			
		}
	}
	
	public void displayContent(){
		
		
	}
	
}
