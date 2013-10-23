package stringBuffer;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ReadFile {

	private StringBuffer str;
	private Scanner input;
	
	public void read(){
		
		try {
			input = new Scanner(new File("Asim.txt"));
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		}
		
		while(input.hasNext()){
			
			str = new StringBuffer(input.nextLine());
			System.out.println(str);
		}
	}
}
