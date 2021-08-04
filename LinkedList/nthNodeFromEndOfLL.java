
class GfG
{

    int getNthFromLast(Node head, int n)
    {
        int len = length(head);
        if(len < n)
            return -1;
            
        n = len-n;
        
        Node temp = head;
        for(int i=0; i<n; i++)
            head = head.next;
            
        return head.data;
    }
    
    private static int length(Node head){
        int count = 0;
        Node temp = head;
        while(temp != null){
            temp = temp.next;
            count++;
        }
        return count;
    }
}
