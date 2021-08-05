// method1
// time o(n) and space o(n)


class Solution
{
	Node lca(Node root, int n1,int n2)
	{
		ArrayList<Node> path1 = new ArrayList<>();
		ArrayList<Node> path2 = new ArrayList<>();
		
		// if we dont get a path then I simply return false;
		if(!getPath(root, n2, path1) || !getPath(root, n1, path2))
		    return null;
		    
		int l1 = path1.size();
		int l2 = path2.size();
		
		int i=0, j=0;
		while(i<l1 && j<l2){
		    if(path1.get(i) != path2.get(j))
		        break;
		  
		  i++;
		  j++;
		}
		 
		return path1.get(i-1);
	}
	
	
	private static boolean getPath(Node root, int key, ArrayList<Node> path){
	    if(root == null)
	        return false;
	  
	  // initially i am asumming root is a part of the path
	  // thats why i am adding it into the path list
	  // if in case it is not a path of a desirable path 
	  // then i will remove it in the end;
	  
	  path.add(root);
	  
	  if(root.data == key)
	    return true;
	  
	  // if root's data is not equal to key 
	  // then I will search for it in left part of the tree and the right part of tree
	  
	  boolean flag1 = getPath(root.left, key, path);
	  boolean flag2 = getPath(root.right, key, path);
	  
	  // if the root is not a part of path then we remove it from the list and return false;
	  if(!flag1 && !flag2){
	      path.remove(path.size()-1);
	      return false;
	  }
	  
	  return true;
	  
	}
	
}




// method 2
// time o(n) and space o(1)


class Solution
{
    
	Node lca(Node root, int n1,int n2)
	{
		if(root == null)
		    return null;
		if(root.data == n1 || root.data == n2)
		    return root;
		    
		 // if ancestor is present in left or right sub tree
		 Node leftTree = lca(root.left, n1, n2);
		 Node rightTree = lca(root.right, n1, n2);
		 
		 if(leftTree == null && rightTree == null)
		    return null;
		    
		 if(leftTree != null && rightTree == null)
		    return leftTree;
		    
		 else if(leftTree == null && rightTree != null)
		    return rightTree;
		    
		  else
		    return root;
	}
}


