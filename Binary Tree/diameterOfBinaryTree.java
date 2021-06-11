// method 1
// without using pair class
// time O(n2) && space o(1)



class Solution {
    int diameter(Node root) {
        if(root == null)
            return 0;
        
        int op1 = 1 + height(root.left) + height(root.right);
        int op2 = diameter(root.left) ;
        int op3 = diameter(root.right);
        
        return Math.max(op1, Math.max(op2, op3));
    }
    
    private static int height(Node root){
        if(root == null)
            return 0;
            
        return 1 + Math.max(height(root.left), height(root.right));
    }
    
}


// method 2
// using pair class
// time o(n) and space o(1)

class Solution {
    int diameter(Node root) {
        if(root == null) return 0;
        
        return helper(root).diameter;
    }
    
    private Pair helper(Node root){
        if(root == null)
            return new Pair();
            
        
        Pair leftTree = helper(root.left);
        Pair rightTree = helper(root.right);
        
        Pair ans = new Pair();
        
        int op1 = 1 + leftTree.height + rightTree.height;
        int op2 = leftTree.diameter;
        int op3 = rightTree.diameter;
        
        ans.height = 1 + Math.max(leftTree.height, rightTree.height);
        ans.diameter = Math.max(op1, Math.max(op2, op3));
        
        return ans;
    }
    
}


class Pair{
    int diameter;
    int height;
    
    Pair(){
        diameter = 0;
        height = 0;
    }
    
}
