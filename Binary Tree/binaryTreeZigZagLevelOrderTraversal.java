class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if(root == null) return new LinkedList<>();
        
        Stack<TreeNode> cs = new Stack<>();
        Stack<TreeNode> ms = new Stack<>();
        
        ms.push(root);
        int level = 1;
        List<List<Integer>> ans = new LinkedList<>();
        List<Integer> list = new LinkedList<>();
        
        while(ms.size() > 0){
            TreeNode node = ms.pop();
            list.add(node.val);
            
            if(level%2 != 0){
                if(node.left != null)
                    cs.push(node.left);
                if(node.right != null)
                    cs.push(node.right);
            } else{
                if(node.right != null)
                    cs.push(node.right);
                if(node.left != null)
                    cs.push(node.left);
            }
            
            if(ms.size() == 0){
                ms = cs;
                cs = new Stack<>();
                ans.add(list);
                list = new LinkedList<>();
                level++;
            }
            
        }
        
        return ans;
    }
}
