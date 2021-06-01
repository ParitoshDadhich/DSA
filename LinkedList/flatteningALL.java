class GfG
{
    Node flatten(Node root)
    {
	    // base case - when root is null or when we are standing on the last pointer
	    if(root == null || root.next == null)
	        return root;
	    
	    // traversing in order to move to last pointer i.e. moving right
	    root.next = flatten(root.next);
	    
	    // merging
	    root = mergeTwoLL(root, root.next);
	    
	    
	    return root;
    }
    
    private Node mergeTwoLL(Node a, Node b){
        Node temp = new Node(0);
        Node res = temp;
        
        while(a != null && b != null){
            if(a.data < b.data){
                temp.bottom = a;
                temp = a;
                a = a.bottom;
            } else{
                temp.bottom = b;
                temp = b;
                b = b.bottom;
            }
        }
        
        if(a != null)
            temp.bottom = a;
        
        if(b != null)
            temp.bottom = b;
            
        return res.bottom;
    }
}
