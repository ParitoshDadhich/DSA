class Solution {
    public boolean isPalindrome(ListNode head) {
        ListNode temp = midPoint(head);
        
        ListNode head2 = temp.next;
        temp.next = null;
        
        head2 = reverse(head2);
        
        while(head != null && head2 != null){
            if(head.val != head2.val)
                return false;
            
            head = head.next;
            head2 = head2.next;
        }
        
        return true;
    }
    
    private ListNode midPoint(ListNode head){
        ListNode slow = head;
        ListNode fast = head.next;
        
        while(fast!= null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        
        return slow;
    }
    
    private ListNode reverse(ListNode head){
        ListNode p = head, q = null, r = null;
        while(p!= null){
            r = q;
            q = p;
            p = p.next;
            q.next = r;
        }
        
        return q;
    }
    
}
