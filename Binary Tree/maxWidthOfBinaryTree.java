class Pair{
    TreeNode node;
    int num;
    
    Pair(TreeNode node, int num){
        this.node = node;
        this.num = num;
    }
}


class Solution {
    public int widthOfBinaryTree(TreeNode root) {
        if(root == null)
            return 0;
        
        int ans = 0;
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(root, 0));
        
        
        while(!q.isEmpty()){
            int size = q.size();
            int min = q.peek().num;
            int first = 0, last = 0;
            
            for(int i=0; i<size; i++){
                TreeNode node = q.peek().node;
                int cur_index = q.peek().num - min;
                q.poll();
                
                if(i == 0) first = cur_index;
                if(i == size-1) last = cur_index;
                
                if(node.left != null)
                    q.add(new Pair(node.left, 2*cur_index+1));
                if(node.right != null)
                    q.add(new Pair(node.right, 2*cur_index+2));
                
            }
            
            ans = Math.max(ans, last - first + 1);
        }
        
        return ans;
    }
}
