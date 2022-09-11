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
// iterative approach using 2 stacks
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

// method 3
// iterative approach using 1 stack
// time o(n) && space o(n)

class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        Stack<TreeNode> st = new Stack<>();
        List<Integer> list = new ArrayList<>();
        
        if(root == null)
            return list;
        
        TreeNode curr = root;
        while(curr != null || !st.isEmpty()){
            if(curr != null){
                st.push(curr);
                curr = curr.left;
            } else{
                TreeNode temp = st.peek().right;
                if(temp != null)
                    curr = temp;
                else{
                    temp = st.pop();
                    list.add(temp.val);
                    while(!st.isEmpty() && temp == st.peek().right){
                        temp = st.pop();
                        list.add(temp.val);
                    }
                }
            }
        }
        
        return list;
    }
}
