class GfG {
    int findDist(Node root, int a, int b) {
        if(root == null)
            return -1;
            
        Node lca = findLCA(root, a, b);
        
        int d1 = pathDistance(lca, a, 0);
        int d2 = pathDistance(lca, b, 0);
        
        return d1+d2;
    }
    
    
    private static Node findLCA(Node root, int a, int b){
        if(root == null)
            return null;
            
        if(root.data == a || root.data == b)
            return root;
        
        Node leftTree = findLCA(root.left, a, b);
        Node rightTree = findLCA(root.right, a, b);
        
        if(leftTree == null && rightTree == null)   
            return null;
        else if(leftTree == null && rightTree != null)
            return rightTree;
        else if(leftTree != null && rightTree == null)
            return leftTree;
        else 
            return root;
    }
    
    
    private static int pathDistance(Node root, int key, int len){
        if(root == null)
            return 0;
        if(root.data == key)
            return len;
        
        return pathDistance(root.left, key, len+1) + pathDistance(root.right, key, len+1);
    }
    
}
