package btree;

import java.io.IOException;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.Formatter;
import java.util.FormatterClosedException;
import java.lang.IllegalStateException;

public class Bst {

	private Node root = null;
	private Node newNode;
	private Scanner read;
	private Formatter write;
	private Scanner input;
	private String fileName;
	private boolean change = false;
	
	public void openFileForRead(String nameOfFile){
		
		try{
			
			read = new Scanner(new File(nameOfFile));
		}catch(FileNotFoundException fileNotFoundException){
			
			System.err.println("\nFile Not Found.");
			System.exit(1);
		}
		
		readRecords();
	}
	
	public void openFileForWrite(String nameOfFile){
		
		try{
			
			write = new Formatter(nameOfFile);
			
		}catch(IOException ioException){
			
			System.err.println("\nError opening file.");
			System.exit(1);
		}
	}

	public void init(){
		
		try{
			
			input  = new Scanner(new File("config.ini"));
		}catch(FileNotFoundException e){

			e.printStackTrace();
		}

		fileName = input.nextLine();
		
		openFileForRead(fileName);
	}
	
	public void readRecords(){
		
		try{
			while(read.hasNext()){
				
				newNode = new Node(read.nextInt(), read.next(), read.next(), null, null);
				insert(newNode);
			}
		}catch(NoSuchElementException elementException){
			
			System.err.println("File Improperly formed.");
			read.close();
			System.exit(1);
			return;
		}catch(IllegalStateException stateException){
			
			System.err.println("Error reading from file.");
			System.exit(1);
		}
		
	}
	
	public void readFromUser(){
		
		int roll;
		input  = new Scanner(System.in);
		
		try{
			do{
				System.out.println("\nEnter record: (-1 to stop)");
				roll = input.nextInt();
				
				if(roll < 0)
					break;
				
				newNode = new Node(roll, input.next(), input.next(), null, null);
				
				insert(newNode);
			}while(true);
		}catch(NoSuchElementException elementException){
			
			System.err.println("\nInvalid Input.Please try again.");
			return;
		}
		
	}
	
	public void insert(Node newNode) {

		change = true;
		Node temp = root;
		
		if(root == null){
			root = newNode;
			System.out.printf("\ninserted %d at root.", newNode.rollNo);
		}else{
			while(true){
				if(temp.rollNo < newNode.rollNo){
					if(temp.right != null){
						temp = temp.right;
					}
					else{
						temp.right = newNode;
						System.out.printf("\ninserted %d at %d right.", newNode.rollNo, temp.rollNo);
						break;
					}
				}else if(temp.rollNo > newNode.rollNo){
					if(temp.left != null){
						temp = temp.left;
					}
					else{
						temp.left = newNode;
						System.out.printf("\ninserted %d at %d left.", newNode.rollNo, temp.rollNo);
						break;
					}
				}else{
					
					System.err.println("The roll no already exists. Please enter again.");
					break;
				}
			}
		}
	}	
	
	public Node search(int roll){
		
		Node temp = root;
		if(temp == null){
			return null;
		}else{
			while(true){
				if(temp.rollNo == roll){
					
					return temp;
				}else if(temp.rollNo < roll){
					if(temp.right != null){
						temp = temp.right;
					}
					else{
						break;
					}
				}else if(temp.rollNo >= roll){
					if(temp.left != null){
						temp = temp.left;
					}
					else{
						break;
					}
				}
			}
		}
		return temp;
	}

	public void writeInConfig(){
		
		openFileForWrite("config.ini");
		
		try{

			write.format(fileName);
		}catch(FormatterClosedException e){
			
			System.err.println("Error writing to config file.");
			System.exit(1);
		}
		write.close();
	}
	
	public void destroy(){

		if(change == true){
			
			input  = new Scanner(System.in);
			
			System.out.println("\nEnter the name of the file to write to.");
			fileName = input.next();
			
			writeInConfig();
			openFileForWrite(fileName);
			writeRecord(root);
		}
	
	}
	
	public void writeRecord(Node temp){
		
		if(temp != null){
			
			try{
				
				write.format("%n%-7s %-15s %-15s", temp.rollNo, temp.fName, temp.lName);
			}catch(FormatterClosedException e){
				
				System.exit(1);
			}
			writeRecord(temp.left);
			writeRecord(temp.right);
		}
	}
	
	public void closeFiles(){
		
		if(read != null){
			
			read.close();
		}
		
		if(write != null){
			
			write.close();
		}
		
	}

	public void setNewNode(int roll, String fn, String ln){
		
		newNode = new Node(roll, fn, ln, null, null);
	}
	
	public Node getNewNode(){
		
		return newNode;
	}

	public Node getRoot(){
		
		return root;
	}
	
}
