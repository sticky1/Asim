package btree;

public class Node {

	int rollNo;
	String fName;
	String lName;
	Node left;
	Node right;
	
	public Node(){
		
		this(0, "", "", null, null);
	}
	
	public Node(int roll, String fn, String ln, Node lt, Node rt){
		
		rollNo = roll;
		fName = fn;
		lName = ln;
		left = lt;
		right = rt;
	}
}
