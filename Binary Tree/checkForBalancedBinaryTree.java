class Pair{
    int height = 0;
    boolean isBalance = true;
}

class Tree
{
    
    boolean isBalanced(Node root)
    {
	    return helper(root).isBalance;
    }
    private Pair helper(Node root){
        if(root == null)    
            return new Pair();
            
        Pair l = helper(root.left);
        Pair r = helper(root.right);
        
        Pair ans = new Pair();
        // for binary tree to be balanced we need to make sure every node of the 
        // binary tree must be balance
        if(Math.abs(l.height-r.height) > 1 || l.isBalance == false || r.isBalance == false) 
            ans.isBalance = false;
        ans.height = 1 + Math.max(l.height, r.height); 
        
        return ans;
    }
    
    
}
