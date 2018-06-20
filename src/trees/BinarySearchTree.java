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
	
	public static BinarySearchTree toBinarySearchTree(int[] preorder) {
	    
	    
	    Node root = null;
	    
	    return new BinarySearchTree(root);
	}
	
	private static Node toBinarySearchTreeInternal(int[] preorder, int start, int end) {
	    if (preorder == null || preorder.length == 0) {
	        return null;
	    }
	    
        Node root = null;
	    if (start == 0) {
	        root = new Node(preorder[0]);
	    }
	    
	    if (start >= preorder.length || end >= preorder.length || start < 0 || end < 0) {
	        return null;
	    }
	    
	    if (start == end) {
	        return new Node(preorder[start]);
	    }
	    
	    return root;
	}
	
	public static void main(String[] args) {
	    int[] preorder = {6,2,1,4,3,5,8,7,9};
	    
	    BinarySearchTree bst = toBinarySearchTree(preorder);
	}

}


