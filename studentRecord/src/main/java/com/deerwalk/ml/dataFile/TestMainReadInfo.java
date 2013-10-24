package com.deerwalk.ml.dataFile;

public class TestMainReadInfo {

	public static void main(String[] args) {

		ReadInfo read = new ReadInfo();
		
		read.readLayout();
		read.readFile();
		read.displayContent();
	}
}
