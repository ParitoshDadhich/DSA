// method 1
// used hashing
// time o(n) && space o(n)

public class Solution {
    public boolean hasCycle(ListNode head) {
        HashSet<ListNode> hs = new HashSet<>();
        
        while(head!= null){
            if(hs.contains(null))
                break;
            else if(hs.contains(head))
                return true;
            else
                hs.add(head);
            
            head = head.next;
        }
        
        return false;
    }
}


// method 2
// using two pointers
// time o(n) && space o(1)


public class Solution {
    public boolean hasCycle(ListNode head) {
        if(head == null || head.next == null)
            return false;
        
        ListNode slow = head;
        ListNode fast = head;
        
        while(fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
            
            if(slow == fast)
                return true;
        }
        
        return false;
    }
}
