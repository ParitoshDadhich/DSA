// method 1
// time o(n) and space o(n)
// Idea is to use BFS traversal to connect all the nodes at the same level

class Solution {
    public Node connect(Node root) {
        if(root == null) return null;
        
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        
        while(!queue.isEmpty()){
            int size = queue.size();
            Node dummy = new Node(0);
            while(size > 0){
                Node node = queue.poll();
                dummy.next = node;
                dummy = node;
                
                if(node.left != null)
                    queue.add(node.left);
                if(node.right != null)
                    queue.add(node.right);
                
                size--;
            }
        }
        return root;
    }
}




// method 2
// time o(n) & space o(1)
// In this question we have next pointer, so we can use the concept of level order traversal
// without using an queue data structure
/*  
    steps:
    1. Here I used a dummy node and a temp variable for traversing 
    2. Inner loop will deal with the nodes of each level
    3. We can continue the process for every single level using step1 and step2.
*/



class Solution {
    public Node connect(Node root) {
        if(root == null) return null;
        
        Node head = root;
        
        while(head != null){
            Node dummy = new Node(0);
            Node temp = dummy;
            
            // this will take care of all the nodes of each level
            while(head != null){
                if(head.left != null){
                    temp.next = head.left;
                    temp = temp.next;
                }
                
                if(head.right != null){
                    temp.next = head.right;
                    temp = temp.next;
                }
                
                head = head.next;
            }
            head = dummy.next;
        }
        
        return root;
    }
}





// method 3
// use recursion
// time o(n) and space o(n), here internal stack is used as an extra space


class Solution {
    public Node connect(Node root) {
        if(root == null)
            return null;
        
        connect(root.left);
        connect(root.right);
        
        connect(root.left, root.right);
        return root;
    }
    
    private void connect(Node left, Node right){
        while(left != null){
            left.next = right;
            left = left.right;
            right = right.left;
        }
    }
    
}


