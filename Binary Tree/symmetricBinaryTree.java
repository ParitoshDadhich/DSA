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
