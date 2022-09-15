// m1

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


// m2

class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        boolean leftToRight = true;
        
        if(root == null)
            return ans;
        
        queue.offer(root);
        while(!queue.isEmpty()){
            int len = queue.size();
            Integer arr[] = new Integer[len];
            // traversing a perticular level
            for(int i=0; i<len; i++){
                TreeNode node = queue.poll();
                
                // finding index to insert into the arr;
                // if index -> i, then inserting from front
                // if index -> size-1-i then inserting from back
                int index = leftToRight ? i : (len - 1 - i);
                 
                if(node.left != null)
                    queue.offer(node.left);
                if(node.right != null)
                    queue.offer(node.right);
                
                arr[index] = node.val;
            }
            
            leftToRight = !leftToRight;
            List<Integer> list = Arrays.asList(arr);
            ans.add(list);
            
        }
        
        return ans;
    }
}
