package btree;

import static org.junit.Assert.*;

import org.junit.Test;

public class BstJTest {

	Bst BinaryTree = new Bst();
	
	@Test
	public void testInit() {
		
		BinaryTree.init();
		assertNotNull(BinaryTree.getRoot());
	}

	@Test
	public void testInsert() {
		
		BinaryTree.setNewNode(9999999, "osjfasldfj", "asdfasdfl");
		BinaryTree.insert(BinaryTree.getNewNode());
		assertNotNull(BinaryTree.search(BinaryTree.getNewNode().rollNo));
	}

	@Test
	public void testDestroy() {
		
		BinaryTree.destroy();
	}

}
