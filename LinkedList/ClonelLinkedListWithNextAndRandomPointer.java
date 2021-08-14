// method 1
// using hashMap
// time o(n) && space o(n)



class Clone {
    //Function to clone a linked list with next and random pointer.
    Node copyList(Node head) {
        if(head == null)
            return null;
        
        HashMap<Node, Node> map = new HashMap<>();
        Node currNode = head;
        
        // creating another list and copying original list's data;
        while(currNode != null){
            map.put(currNode, new Node(currNode.data));
            currNode = currNode.next;
        }
        
        // copying and linking next and random pointer
        for(Map.Entry<Node, Node> entry: map.entrySet()){
            Node node = entry.getValue();
            
            node.next = map.get(entry.getKey().next);
            node.arb = map.get(entry.getKey().arb);
        }
        
        return map.get(head);
    }
}



// method 2
// two pointer approach
// time o(n) && space o(1)


class Solution {
    public Node copyRandomList(Node head) {
        Node iter = head;
        Node front = head;
        
        // connecting copy nodes just after to respective original nodes;
        while(iter != null){
            front = iter.next;
            Node copyNode = new Node(iter.val);
            iter.next = copyNode;
            copyNode.next = front;
            iter = front;
        }
        
        
        // delaing with random pointer
        iter = head;
        while(iter != null){
            if(iter.random != null)
                iter.next.random = iter.random.next;
            
            iter = iter.next.next;
        }
        
        
        // separating copy linked list and orignial linked list;
        iter = head;
        Node pseudoHead = new Node(0);
        Node copy = pseudoHead;
        while(iter != null){
            front = iter.next.next;
            copy.next = iter.next;
            
            iter.next = front;
            iter = iter.next;
            copy = copy.next;
        }
        
        
        return pseudoHead.next;
    }
}
