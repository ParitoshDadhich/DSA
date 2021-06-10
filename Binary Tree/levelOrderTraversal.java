class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new LinkedList<List<Integer>>();
         
        if(root == null) return ans;
        
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        queue.add(null);
        
        List<Integer> list = new LinkedList<>();
        while(!queue.isEmpty()){    
            TreeNode front; 
            if(queue.peek() != null){
                front = queue.poll();
                list.add(front.val);

                if(front.left != null)
                    queue.add(front.left);
                if(front.right != null)
                    queue.add(front.right);
            } else{
                ans.add(list);
                list = new LinkedList<>();
                queue.remove();
                if(queue.isEmpty())
                    break;
                else
                    queue.add(null);
            }  
        }
        
        return ans;
    }
}
