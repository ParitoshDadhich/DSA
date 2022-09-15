class Solution {
    int maxi = -1000;
    public int maxPathSum(TreeNode root) {
        helper(root);
        return maxi;
    }
    
    private int helper(TreeNode root){
        if(root == null)
            return 0;
        
        int leftSum = Math.max(0, helper(root.left));
        int rightSum = Math.max(0, helper(root.right));
        
        // calculating the path sum;
        maxi = Math.max(maxi, leftSum + rightSum + root.val);
        
        // returning max path sum either left one would be max or right one;
        return root.val + Math.max(leftSum, rightSum);
    }
    
}
