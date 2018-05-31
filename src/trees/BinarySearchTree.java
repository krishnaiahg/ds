package trees;

public class BinarySearchTree extends BinaryTree {
	
	BinarySearchTree(Node root) {
		super(root);
	}
	
	
	public BinarySearchTree toBinarySearchTree(int[] a, boolean sorted) {
	    
	    if (!sorted) {
	        java.util.Arrays.sort(a);
	    }
	    
	    Node root = toBinaryTree(a, 0 /*start */, a.length-1 /* end */);
	    
	    return new BinarySearchTree(root);
	    
	}

}


