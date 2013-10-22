package btree;

import java.util.Scanner;

public class BstTestMain {

	private static Bst Btree;
	private static Scanner input;
	
	public static void main(String[] args) {

		Btree = new Bst();
		input = new Scanner(System.in);
		
		System.out.println("Enter 1 for first run and 2 for next run");
		int ans = input.nextInt();
		
		if(ans == 1){
			firstRun();
		}else if(ans == 2){
			nextRun();
		}
	}
	
	public static void firstRun(){
		
		Btree.setNewNode(20, "Ashim", "Regmi");
		Btree.insert(Btree.getNewNode());
		Btree.setNewNode(19, "Bimal", "Gharti");
		Btree.insert(Btree.getNewNode());
		Btree.setNewNode(21, "Sujan", "Budha");
		Btree.insert(Btree.getNewNode());
		Btree.destroy();
		Btree.closeFiles();
	}
	
	public static void nextRun(){
		
		Btree.init();
		Btree.readFromUser();
		Btree.destroy();
		Btree.closeFiles();
	}
	
}