
class Solution
{
    
	Node lca(Node root, int n1,int n2)
	{
	    if(root == null) return null;
	    
		if(root.data == n1 || root.data == n2) return root;
		
		// search lca in the left tree
		Node leftNode = lca(root.left, n1, n2);
		Node rightNode = lca(root.right, n1, n2);
		
		if(leftNode == null && rightNode == null) return null;
		
		else if(leftNode == null && rightNode != null)  return rightNode;
		
		else if(leftNode != null && rightNode == null)  return leftNode;
		
		else
		    return root;
	}
}
