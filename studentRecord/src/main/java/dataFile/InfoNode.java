package dataFile;

import java.util.ArrayList;

public class InfoNode {

	private ArrayList<String> contents = new ArrayList<String>();
	
	public InfoNode(){
		
		this(null);
	}
	
	public InfoNode(ArrayList<String> content){
		
		contents = content;
	}
	
	public ArrayList<String> getContents(){
		
		return contents;
	}
	
	public String getContents(int i){
		
		return contents.get(i);
	}
}
