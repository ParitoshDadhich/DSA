
class Solution
{
	boolean isIdentical(Node root1, Node root2)
	{
	    if(root1 == null && root2 == null)
	        return true;
	    else if(root1 == null || root2 == null || root1.data != root2.data)
	        return false;
	        
// 	    int h1 = height(root1);
// 	    int h2 = height(root2);
	   
// 	    if(h1 != h2)
// 	        return false;
	     
	    
	    boolean flag1 = isIdentical(root1.left, root2.left);
	    boolean flag2 = isIdentical(root1.right, root2.right);
	    
	    return flag1 && flag2;
	    
	}
	
	private static int height(Node root){
	    if(root == null)
	        return 0;
	        
	   return 1 + Math.max(height(root.left), height(root.right));
	}
	
}
