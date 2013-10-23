package dataFile;

public class TestReadInfo {

	public static void main(String[] args) {

		ReadInfo read = new ReadInfo();
		
		read.readLayout();
		read.readFile();
		read.displayContent();
	}

}
