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
	private RootOfTree root;
	
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
		
		log.info("Records' Layout is read.");
	}
	
	public void readFile(){
		
		input = new Scanner(System.in);
		
		System.out.println("\nEnter the name of the file to read: ");
		String fileName = input.next();
		
		try {
			input = new Scanner(new File(fileName));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		while(input.hasNext()){
			
			str = input.nextLine();
			
			content = str.split("|");
			
			for(int i = 0; i < content.length; i++){
				
				insert();
			}
		}
	}
	
	public void insert(){
		
		AddressTree addressNode;
		
		if(root.getNoOfLocations() == 0){
			
			addressNode = new AddressTree(content[0]);
			root.addAddress(addressNode);
		}
		else{
			
			int i = 0;
			addressNode = root.getAddressNode(i);
			
			while(addressNode.getAddress() != content[0]){
				
				i++;
				addressNode = root.getAddressNode(i);
			}
		}
		
		InfoNode infoNode = new InfoNode(content[1], content[2]);
		addressNode.addInfoNode(infoNode);
	}
	
	public void displayContent(){
		
		System.out.printf("\nThere are %d different locations: ", root.getNoOfLocations());
		displayAddresses();
		
		//Display different people under different locations
		
		displayInfo();
	}
	
	public void displayAddresses(){
		
		for(int i = 0; i < root.getNoOfLocations(); i++){
			
			root.getAddressNode(i).getAddress();
		}
	}
	
	public void displayInfo(){
		
		for(int i = 0; i < root.getNoOfLocations(); i++){
			
			if(root.getAddressNode(i).getNoOfInfos() == 1){
			
				System.out.printf("\n%d. Person living in %s is: ", i + 1, root.getAddressNode(i).getAddress());
				System.out.printf("\n%s, roll number: %s", root.getAddressNode(i).getInfoNode(i).getName(), root.getAddressNode(i).getInfoNode(i).getRollNo());
			}else if(root.getAddressNode(i).getNoOfInfos() > 1){
				
				System.out.printf("\n%d. People living in %s are: ", i + 1, root.getAddressNode(i).getAddress());
				for(int j = 0; j < root.getAddressNode(i).getNoOfInfos(); j++){
					
					System.out.printf("\n%s, roll number: %s", root.getAddressNode(i).getInfoNode(i).getName(), root.getAddressNode(i).getInfoNode(i).getRollNo());
				}
			}
		}
	}
	
}
