package practice;

import java.util.ArrayList;

public class AddressTree {

	private String address;
	private ArrayList<InfoNode> infoNodePointer = new ArrayList<InfoNode>();
	private int noOfInfos = 0;
	
	public AddressTree(){
		
		this("");
	}
	
	public AddressTree(String location){
		
		address = location;
	}
	
	public String getAddress(){
		
		return address;
	}
	
	public void addInfoNode(ArrayList<String> temp){
		
		InfoNode infoNode = new InfoNode(temp);
		
		infoNodePointer.add(infoNode);
		noOfInfos++;
	}
	
	public InfoNode getInfoNode(int i){
		
		return infoNodePointer.get(i);
	}
	
	public int getNoOfInfos(){
		
		return noOfInfos;
	}
	
}
