package dataFile;

public class InfoNode {

	private String name;
	private String rollNo;
	
	public InfoNode(){
		
		this("", "");
	}
	
	public InfoNode(String nm, String roll){
		
		name = nm;
		rollNo = roll;
	}
	
	public String getName(){
		
		return name;
	}
	
	public String getRollNo(){
		
		return rollNo;
	}
	
}
