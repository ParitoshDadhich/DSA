// Brute force
// time o(n2)

class Solution {
    public boolean isBalanced(TreeNode root) {
        if(root == null) return true;
        
        int lh = height(root.left);
        int rh = height(root.right);
        
        if(Math.abs(lh-rh) > 1) return false;
        
        boolean lTree = isBalanced(root.left);
        boolean rTree = isBalanced(root.right);
        
        return lTree != rTree ? false : (lTree == false ? false : true);
    }
    
    private int height(TreeNode root){
        if(root == null) return 0;
        
        return 1 + Math.max(height(root.left), height(root.right));
    }
}

// better optimal sol
// time o(n)


class Solution {
    public boolean isBalanced(TreeNode root) {
        return dfsHeight(root) != -1;
    }
    
    private int dfsHeight(TreeNode root){
        if(root == null) return 0;
        
        int leftH = dfsHeight(root.left);
        if(leftH == -1) return -1;
        
        int rightH = dfsHeight(root.right);
        if(rightH == -1) return -1;
        
        if(Math.abs(leftH - rightH) > 1) return -1;
        
        return 1 + Math.max(leftH, rightH);
    }
    
}



// another way of writing sol using pair class
// time o(n)
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
