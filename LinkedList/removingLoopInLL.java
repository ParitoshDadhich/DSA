class Solution
{
    //Function to remove a loop in the linked list.
    public static void removeLoop(Node head){
        Node slow = head, fast = head;
        
        // finding the position where fast and slow pointers meet
        // using floyd cycle detection
        do{
            slow = slow.next;
            if(fast.next != null)
                fast = fast.next.next;
        } while(fast != null && slow != fast);
        
        
        Node prev = null;
        slow = head;
        
        
        if(fast == head){
            Node temp = head;
            do{
                temp = temp.next;
            } while(temp.next != head);
            
            temp.next = null;
            return;
                   
        }
        
        // removing loop
        while(fast != null && slow != fast){
            prev = fast;
            fast = fast.next;
            slow = slow.next;
        }
        if(prev != null)
            prev.next = null;
        
    }
}
