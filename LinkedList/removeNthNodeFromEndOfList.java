class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode temp = head;
        int len = 0;
        while(temp != null){
            len++;
            temp = temp.next;
        }
        
        n = len-n+1;
        
        temp = head;
        int count = 0;
        while(temp != null && count < n-2){
            count ++;
            temp = temp.next;
        }
        if(n == 1)
            return head.next;
        
        if(temp.next != null)
            temp.next = temp.next.next;
        
        return  head;
    }
}
