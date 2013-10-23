package dataFile;

import java.util.Scanner;
import java.util.ArrayList;
import java.io.File;
import java.io.FileNotFoundException;
import org.apache.log4j.Logger;

public class ReadInfo {

	private Scanner input;
	private ArrayList<String> field = new ArrayList<String>();
	private ArrayList<Integer> position = new ArrayList<Integer>();
	private ArrayList<String> type = new ArrayList<String>();
	private String[] content;
	private String str;
	private Logger log = Logger.getLogger(ReadInfo.class.getName());
	private RootOfTree root = new RootOfTree();
	
	public void readLayout(){
		
		try {
			input = new Scanner(new File("LayoutFormat"));
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		}
		
		while(input.hasNext()){
			
			str = input.nextLine();
			content = str.split("/");
			field.add(content[0]);
			position.add(Integer.parseInt(content[1]));
			type.add(content[2]);
		}
		
		log.info("Records' Layout is read.\n");
	}
	
	public void readFile(){
		
		input = new Scanner(System.in);
		
		//System.out.println("\nEnter the name of the file to read: ");
		//String fileName = input.next();
		
		try {
			input = new Scanner(new File("file.txt"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		while(input.hasNext()){
			
			str = input.nextLine();
			System.out.println(str);
			content = str.split("/");
			
			insert();
		}
	}
	
	public void insert(){
		
		AddressTree addressNode;
		
		if(root.getNoOfLocations() == 0){
			
			addressNode = new AddressTree(content[2]);
			root.addAddress(addressNode);
		}
		else{
			
			int i = 0;
			addressNode = root.getAddressNode(0);
			
			while(!addressNode.getAddress().contentEquals(content[2]) && i < root.getNoOfLocations() - 1){
				
				i++;
				addressNode = root.getAddressNode(i);
			}
			
			if(!addressNode.getAddress().contentEquals(content[2])){
				
				addressNode = new AddressTree(content[2]);
				root.addAddress(addressNode);
				
			}
		}
		
		InfoNode infoNode = new InfoNode(content[0], content[1]);
		addressNode.addInfoNode(infoNode);
	}
	
	public void displayContent(){
		
		if(root.getNoOfLocations() == 1){
			
			System.out.println("\nThere is 1 location:");
			displayAddresses();
		}
		else{
		
			System.out.printf("\nThere are %d different locations: ", root.getNoOfLocations());
			displayAddresses();
		}
		
		//Display different people under different locations
		displayInfo();
	}
	
	public void displayAddresses(){
		
		for(int i = 0; i < root.getNoOfLocations(); i++){
			
			System.out.printf("\n%s", root.getAddressNode(i).getAddress());
		}
	}
	
	public void displayInfo(){
		
		for(int i = 0; i < root.getNoOfLocations(); i++){
			
			if(root.getAddressNode(i).getNoOfInfos() == 1){
			
				System.out.printf("\n%d. Person living in %s is: ", i + 1, root.getAddressNode(i).getAddress());
				System.out.printf("\n%s, roll number: %s", root.getAddressNode(i).getInfoNode(0).getName(), root.getAddressNode(i).getInfoNode(0).getRollNo());
			}else if(root.getAddressNode(i).getNoOfInfos() > 1){
				
				System.out.printf("\n%d. People living in %s are: ", i + 1, root.getAddressNode(i).getAddress());
				for(int j = 0; j < root.getAddressNode(i).getNoOfInfos(); j++){
					
					System.out.printf("\n%s, roll number: %s", root.getAddressNode(i).getInfoNode(j).getName(), root.getAddressNode(i).getInfoNode(j).getRollNo());
				}
			}
		}
	}
	
}
