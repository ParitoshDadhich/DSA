class Solution {
    private int sumNumbers(TreeNode root, int res) {
        if(root == null)
            return 0;
        
        if(root.left == null && root.right == null)
            return res *10 + root.val;
        
        res = res *10 + root.val;
        
        int left = sumNumbers(root.left, res);
        int right = sumNumbers(root.right, res);
        
        return left + right;
    }
    
    public int sumNumbers(TreeNode root){
        return sumNumbers(root, 0);
    }
}
