lass Solution
{
  
    static int countNodesinLoop(Node head)
    {
        Node slow = head, fast = head;
        while(fast!= null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast)
                break;
        }
        
        if(fast == null || fast.next == null)
            return 0;
        
        Node temp = slow;
        int len = 1;
        while(temp != null && temp.next != slow){
            temp = temp.next;
            len++;
        }
        return len;
    }
}
