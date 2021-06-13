// method 1
// using recursion
// time o(n) and space o(h), where h is the height of internal stack which is used during recursion calls;


class GfG
{
    public static boolean isSymmetric(Node root)
    {
        return isMirror(root, root);
    }
    
    
    private static boolean isMirror(Node root1, Node root2){
        if(root1 == null && root2 == null)
            return true;
            
        // Two tree to be symmetric or mirror
        // 1. their root values must be equal;
        // 2. left sub tree of first tree must be symmetric to sub right tree of another tree
        // 3. vice versa of 2 step;
        
        if(root1 != null && root2 != null)
            if(root1.data == root2.data)
                return isMirror(root1.left, root2.right) && isMirror(root1.right, root2.left);
            
        return false;
    }
}


// method 2
// using iterative approach
// time o(n) and space (n)

class Solution {
    public boolean isSymmetric(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        queue.add(root);
        
        while(!queue.isEmpty()){
            TreeNode t1 = queue.poll();
            TreeNode t2 = queue.poll();
            
            if(t1 == null && t2 == null) continue;
            if(t1 == null || t2 == null) return false;
            if(t1.val != t2.val) return false;
            
            queue.add(t1.left);
            queue.add(t2.right);
            queue.add(t1.right);
            queue.add(t2.left);
        }
        
        return true;
    }
}
