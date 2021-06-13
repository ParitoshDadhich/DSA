// method 1
// using preorder traversal(DFS)
// time o(n) and space o(h), h is the height of the binary tree

class Tree
{
    static boolean check[];
    ArrayList<Integer> leftView(Node root)
    { 
        if(root == null)
            return new ArrayList<>();
        
     
      int height = depth(root);
      check = new boolean[height];
      
      ArrayList<Integer> list = new ArrayList<>();
      leftView(root, list, 0);
      
      return list;
    }
    
    private static void leftView(Node root, ArrayList<Integer> list, int level){
        if(root == null) return;
        
        if(check[level] == false){
            list.add(root.data);
            check[level] = true;
        }
        
        leftView(root.left, list, level+1);
        leftView(root.right, list, level+1);
        
        return;
    }
    
    private static int depth(Node root){
        if(root == null)
            return 0;
        
        return 1 + Math.max(depth(root.left), depth(root.right));
    }
    
}


// method 2
// using level order traversal
// time o(n) and space o(n)

class Tree
{
    //Function to return list containing elements of left view of binary tree.
    ArrayList<Integer> leftView(Node root)
    {
          if(root == null)
            return new ArrayList<Integer>();
        
        ArrayList<Integer> ans = new ArrayList<>();
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        queue.add(null);
        
        boolean flag = true;
        while(!queue.isEmpty()){
            Node front;
            if(queue.peek() != null){
                front = queue.poll();
                
                if(flag){
                    ans.add(front.data);
                    flag = false;
                }
                
                if(front.left != null)
                    queue.add(front.left);
                
                if(front.right != null)
                    queue.add(front.right);
                     
                
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
