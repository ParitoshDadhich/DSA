// method 1

class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode ans = new ListNode(0);
        int carry = 0;
        ListNode temp = ans;
        
        while(l1 != null && l2 != null){
            int sum = l1.val + l2.val + carry;
            carry = sum/10;
            sum = sum%10;
            
            ListNode newNode = new ListNode(sum);
            temp.next = newNode;
            temp = newNode;
            
            l1 = l1.next;
            l2 = l2.next;
        }
        
        int sum = 0;
        while(l1 != null){
            sum = l1.val + carry;
            carry = sum/10;
            sum = sum%10;
            
            ListNode newNode = new ListNode(sum);
            temp.next = newNode;
            temp = newNode;
            
            l1 = l1.next;
        }
        
         sum = 0;
         while(l2 != null){
            sum = l2.val + carry;
            carry = sum/10;
            sum = sum%10;
            
            ListNode newNode = new ListNode(sum);
            temp.next = newNode;
            temp = newNode;
             
            l2 = l2.next;
            
        }
        
        if(carry > 0)
            temp.next = new ListNode(carry);
        
        return ans.next;
    }
}



// method 2

class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode ans = new ListNode(0);
        int carry = 0;
        ListNode temp = ans;
        
        while(l1 != null || l2 != null){
            int x = l1 != null ? l1.val : 0;
            int y = l2 != null ? l2.val : 0;
            int sum = x + y + carry;
            carry = sum/10;
            sum = sum%10;
            
            ListNode newNode = new ListNode(sum);
            temp.next = newNode;
            temp = newNode;
            
            if(l1 != null)
                l1 = l1.next;
            if(l2 != null)
                l2 = l2.next;
        }
    
        if(carry > 0)
            temp.next = new ListNode(carry);
        
        return ans.next;
    }
}

 
