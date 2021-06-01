// method 1
// used hashing
// time o(n) && space o(n)


public class Solution {
    public ListNode detectCycle(ListNode head) {
        HashSet<ListNode> hs = new HashSet<>();
        
        while(head != null){
            if(hs.contains(head))
                return head;
            
            hs.add(head);
            head = head.next;
        }
        return null;
    }
}


// method 2
// using two pointers
// time 0(n ) && space o(1)

public class Solution {
    public ListNode detectCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        ListNode entry = head;
        
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            
            if(fast == slow){
                while(slow != entry){
                    slow = slow.next;
                    entry = entry.next;
                }
                return entry;
            }
        }
        
        return null;
    }
}
