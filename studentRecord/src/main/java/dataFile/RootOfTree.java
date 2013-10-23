package dataFile;

import java.util.ArrayList;

public class RootOfTree {

	private ArrayList<AddressTree> addressPointer = new ArrayList<AddressTree>();
	private int noOfLocations = 0;
	
	public void addAddress(AddressTree node){
		
		addressPointer.add(node);
		noOfLocations++;
	}
	
	public int getNoOfLocations(){
		
		return noOfLocations;
	}
	
	public AddressTree getAddressNode(int i){
		
		return addressPointer.get(i);
	}
}
