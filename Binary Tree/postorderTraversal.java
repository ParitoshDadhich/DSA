// method 1
// recursive approach
// time O(n)



class Solution {
    List<Integer> list = new ArrayList<>();
    public List<Integer> postorderTraversal(TreeNode root) {
        if(root == null) return list;
        
        postorderTraversal(root.left);
        postorderTraversal(root.right);
        list.add(root.val);
        
        return list;
    }
}



// method 2
// iterative approach
// time o(n) && space o(n)


class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        if(root == null) return new ArrayList<>();
        
        Stack<TreeNode> s1 = new Stack<>();
        Stack<TreeNode> s2 = new Stack<>();
        
        s1.add(root);
        while(!s1.isEmpty()){
            TreeNode node = s1.pop();
            
            if(node.left != null)
                s1.add(node.left);
            if(node.right != null)
                s1.add(node.right);
            
            s2.add(node);
        }
        
        List<Integer> list = new ArrayList<>();
        while(!s2.isEmpty())
            list.add(s2.pop().val);
        
        return list;
    }
}
