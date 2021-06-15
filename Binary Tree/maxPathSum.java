class Solution {
    
    private int result = Integer.MIN_VALUE;
    
     public int maxPathSum(TreeNode root) {
         helper(root);
         return result;
     }
    
    public int helper(TreeNode root) {
        if(root == null)
            return 0;
        
        int leftValue = helper(root.left);
        int rightValue = helper(root.right);
        
        // Think root as a currNode, when currNode is in the path of maxSum or itself the path
        int case1 = Math.max(Math.max(leftValue, rightValue) + root.val, root.val);
        
        // Think root as a currNode, when currNode is itself the the root of the max sum path
        int case2 = Math.max(case1, leftValue + rightValue + root.val);
        
        // Think, root as a currNode, when currNode is not a part of the the max sum path
        result = Math.max(case2, result);
        
        return case1;
    }
}
