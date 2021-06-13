// method 1
// time O(N) and space O(N)

class Solution {
    public void flatten(TreeNode root) {
        if(root == null) return;
        
        ArrayList<TreeNode> list = new ArrayList<>();
        preorder(root, list);
        root.left = null;
        root.right = null;
        TreeNode curr = root;
        
        int len = list.size();
        for(int i=1; i<len; i++){
            TreeNode node = list.get(i);
            curr.right = node;
            curr.left = null;
            curr = node;
        }
        
        return;
    }
    
    private void preorder(TreeNode root, ArrayList<TreeNode> list){
        if(root == null)    return;
        
        list.add(root);
        preorder(root.left, list);
        preorder(root.right, list);
    }
    
}


// method 2
// time O(N) and space O(h), h is the height of the recursive stack;

class Solution {
    TreeNode prev = null;
    public void flatten(TreeNode root) {
        if(root == null) return;
        flatter(root);
    }
    
    private void flatter(TreeNode root){
        if(root == null) return;
        
        flatter(root.right);
        flatter(root.left);
        
        root.right = prev;
        root.left = null;
        prev = root;
    }
    
}


// method 3
// using stack 
// time o(n) and space o(n)

class Solution {
    public void flatten(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        
        while(!stack.isEmpty()){
            TreeNode currNode = stack.pop();
            
            if(currNode.right!= null)
                stack.push(currNode.right);
            if(currNode.left != null)
                stack.push(currNode.left);
            
            if(!stack.isEmpty())
                currNode.right = stack.peek();
            
            currNode.left = null;
        }
    }
}
