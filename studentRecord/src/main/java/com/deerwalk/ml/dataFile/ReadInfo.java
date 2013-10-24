package com.deerwalk.ml.dataFile;

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
	private ArrayList<String> temp = new ArrayList<String>();
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
		TreeInsert tree = this.new TreeInsert();
		
		try {
			input = new Scanner(new File("file.txt"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		while(input.hasNext()){
			
			str = input.nextLine();
			content = str.split("/");
			
			tree.insert();
		}
	}
	
	public void displayContent(){
		
		Display displayObject = this.new Display();
		
		if(root.getNoOfLocations() == 1){
			
			System.out.println("\nThere is 1 location:");
			displayObject.displayAddresses();
		}
		else{
		
			System.out.printf("\nThere are %d different locations: ", root.getNoOfLocations());
			displayObject.displayAddresses();
		}
		
		//Display different people under different locations
		displayObject.displayInfo();
	}
	
	class TreeInsert{
		
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
			
			temp = new ArrayList<String>();
			for(int i = 0; i < content.length; i++){
				
				if(content[i] == "address"){
					
					continue;
				}
				temp.add(content[i]);
			}
		
			addressNode.addInfoNode(temp);
		}
	}
	
	class Display{
		
		public void displayAddresses(){
			
			for(int i = 0; i < root.getNoOfLocations(); i++){
				
				System.out.printf("\n%s", root.getAddressNode(i).getAddress());
			}
		}
		
		public void displayInfo(){
			
			for(int i = 0; i < root.getNoOfLocations(); i++){
				
				if(root.getAddressNode(i).getNoOfInfos() == 1){
				
					System.out.printf("\n%d. Person living in %s is: ", i + 1, root.getAddressNode(i).getAddress());
					
					System.out.printf("\n%s: %s", field.get(0), root.getAddressNode(i).getInfoNode(0).getContents(0));
					for(int k = 1; k < field.size(); k++){
					
						if(field.get(k).contentEquals("address")){
							
							continue;
						}
						
						System.out.printf(", %s: %s", field.get(k), root.getAddressNode(i).getInfoNode(0).getContents(k));
					}
				}else if(root.getAddressNode(i).getNoOfInfos() > 1){
					
					System.out.printf("\n%d. People living in %s are: ", i + 1, root.getAddressNode(i).getAddress());
					for(int j = 0; j < root.getAddressNode(i).getNoOfInfos(); j++){
						
						System.out.printf("\n%s: %s", field.get(0), root.getAddressNode(i).getInfoNode(j).getContents(0));
						for(int k = 1; k < field.size(); k++){
						
							System.out.printf(", %s: %s", field.get(k), root.getAddressNode(i).getInfoNode(j).getContents(k));
						}
					}
				}
			}
		}
	}
	
}
