// Recursive solution; 


class Solution {
    public int maxDepth(TreeNode root) {
        if(root == null)
            return 0;
        
        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }
}


// Iterative sol

class Solution {
    public int maxDepth(TreeNode root) {
        if(root == null)
            return 0;
        int height = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        
        while(!queue.isEmpty()){
            height++;
            int len = queue.size();
            for(int i=0; i<len; i++){
                TreeNode node = queue.poll();
                if(node.left != null)
                    queue.offer(node.left);
                if(node.right != null)
                queue.offer(node.right);
            }
        }
        
        return height;
    }
}
