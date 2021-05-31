// method 1 (Brute force)
// use two loops
// time o(n2) || space o(1)


class Intersect
{
	int intersectPoint(Node l1, Node l2)
	{
         while(l1 != null && l2 != null){
             Node temp = l2;
             while(temp != null){
                 if(l1 != temp){
                     temp = temp.next;
                 } else{
                     return temp.data;
                 }
             }
             l1 = l1.next;
         }
         
         return -1;
	}
}
  
// method 2
// used hasSet
// time o(n) && space o(n)


class Intersect
{
	int intersectPoint(Node l1, Node l2)
	{
         HashSet<Node> hs = new HashSet<>();
         while(l1 != null){
             hs.add(l1);
             l1 = l1.next;
         }
         
         while(l2 != null){
             if(hs.contains(l2))
                return l2.data;
            
            l2 = l2.next;
         }
         
         return -1;
	}
}


// method 3;
// taking difference of lengths
// time o(n) && space o(1)

public class Solution {
    public ListNode getIntersectionNode(ListNode l1, ListNode l2) {
        int len1 = length(l1);
        int len2 = length(l2);
        
        // move l1 and l2 to the same starting point
        while(len1 > len2){
            l1 = l1.next;
            len1--;
        }
        
        while(len1 < len2){
            l2 = l2.next;
            len2--;
        }
        
        // finding the intersection point
        while(l1 != l2){
            l1 = l1.next;
            l2 = l2.next;
        }
        
        return l1;
    }
    
    private int length(ListNode node){
        int count = 0;
        while(node != null){
            node = node.next;
            count++;
        }
        return count;
    }
    
}

// method 4
// time o(n) space (1)

public class Solution {
    public ListNode getIntersectionNode(ListNode l1, ListNode l2) {
         ListNode a = l1;
         ListNode b = l2;
         
        // if a and b have different len, then we will stop the loop after second iteration;
         while(a != b){
             // for the end of first iteration, we reset a to l2 and b to l1
             // The intuation behind this approach, we are trying to cover up the difference of the length of l1 and l2 linkedlist
             a = a == null ? l2 : a.next;
             b = b == null ? l1 : b.next;
         }
         
         return a;
    }
}

