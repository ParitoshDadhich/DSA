// method 1
// time O(n*h), h is the height of the binary tree

// APPROACH
// if a binary tree is BST then 
// 1. Maximum of left sub tree must be less then the root
// 2. Minimum of right sub tree must be greater then the root
// 3. Every sub tree in the binary tree must satisfy the above two conditios only then the binary tree will be called as BST

class Solution {
    public boolean isValidBST(TreeNode root) {
        if(root == null)
            return true;
        
        int maxLeft = maximum(root.left);
        int minRight = minimum(root.right);
        
        if(minRight <= root.val || maxLeft >= root.val)
            return false;
        
        boolean flag1 = isValidBST(root.left);
        boolean flag2 = isValidBST(root.right);
        
        return flag1 && flag2;
    }
    
    private int maximum(TreeNode root){
        if(root == null)
            return Integer.MIN_VALUE;
        
        return Math.max(root.val, (Math.max(maximum(root.left), maximum(root.right))));
    }
                
     private int minimum(TreeNode root){
        if(root == null)
            return Integer.MAX_VALUE;
        
        return Math.min(root.val, (Math.min(minimum(root.left), minimum(root.right))));
    }
    
}


// method 2
// time o(n)
// the idea is to make a triplet class which contains leftMax, rightMax and isBST
// and perform all the operations which we did in first method;

class Triplet{
    Integer min = Integer.MAX_VALUE;
    Integer max = Integer.MIN_VALUE;
    boolean isBST = true;
}
class Solution {
    public boolean isValidBST(TreeNode root) {
        return helper(root).isBST;
    }
    
    private Triplet helper(TreeNode root){
        if(root == null)
            return new Triplet();
        
        Triplet a = helper(root.left);
        Triplet b = helper(root.right);
        
        Triplet ans = new Triplet();
        ans.min = Math.min(root.val, Math.min(a.min, b.min));
        ans.max = Math.max(root.val, Math.max(a.max, b.max));
        ans.isBST = a.isBST && b.isBST && (a.max < root.val) && (b.min > root.val);          
        
        return ans;
    }
    
}

// method 3
// time o(n)
// idea is element should be lie in a range, if it is not then we simply return false


class Solution {
    public boolean isValidBST(TreeNode root) {
        return isBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }
    
    private boolean isBST(TreeNode root, long min, long max){
        if(root == null)
            return true;
        
        // if the element does not lie in the range then we return false
        if(min >= root.val || max <= root.val)
            return false;
        
        boolean flag1 = isBST(root.left, min, root.val);
        boolean flag2 = isBST(root.right, root.val, max);
        
        return flag1 && flag2;
    }
    
}
