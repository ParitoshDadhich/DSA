// method1
// using recursion

class Solution {
    List<Integer> list = new ArrayList<>();
    public List<Integer> preorderTraversal(TreeNode root) {
        if(root == null)
            return list;
        
        list.add(root.val);
        if(root.left != null)
            preorderTraversal(root.left);
        if(root.right != null)
            preorderTraversal(root.right);
        
        return list;
    }
}


// method 2
// iterative approach
// time o(n) and space o(n)

class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        if(root == null)
            return new ArrayList<Integer>();
        
        List<Integer> ans = new ArrayList<>();
        Stack<TreeNode> st = new Stack<>();
        
        st.add(root);
        
        while(!st.isEmpty()){
            TreeNode node = st.pop();
            
            if(node.right != null)
                st.add(node.right);
            if(node.left != null)
                st.add(node.left);
            
            ans.add(node.val);
        }
        
        return ans;
    }
}
