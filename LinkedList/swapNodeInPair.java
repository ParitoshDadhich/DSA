 
class Solution {
    public ListNode swapPairs(ListNode head) {
        ListNode prev = null;
        ListNode cur = head;
        ListNode next = null;
        
        int count = 0;
        // swap pairs
        while(cur != null && count < 2){
            next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
            
            count++;
        }
        
        if(next != null)
            head.next = swapPairs(next);
        
        return prev;
    }
}

