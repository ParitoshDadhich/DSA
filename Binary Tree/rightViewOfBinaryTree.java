// method 1
// using level order traversal
// Time o(n) and space o(n)

class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        
        if(root == null)
            return new ArrayList<Integer>();
        
        ArrayList<Integer> ans = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        queue.add(null);
        
        boolean flag = true;
        while(!queue.isEmpty()){
            TreeNode front;
            if(queue.peek() != null){
                front = queue.poll();
                
                if(flag){
                    ans.add(front.val);
                    flag = false;
                }
                
                
                if(front.right != null)
                    queue.add(front.right);
                     
                if(front.left != null)
                    queue.add(front.left);
                
            } else{
                queue.poll();
                flag = true;
                if(queue.isEmpty())
                    break;
                else
                    queue.add(null);
            }
        }
        
        return ans;
    }
}


// method 2
// using preorder traversal
// time o(n) and space o(h), h is the height of the binary tree
