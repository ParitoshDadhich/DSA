// method 1 (Using 2 queues)
// push O(1) && pop O(n), Space o(n). for extra queue;

class MyStack {
    
    private Queue<Integer> queue = new LinkedList<>();
    private Queue<Integer> tempQueue = new LinkedList<>();
    private int top;
    
    public void push(int x) {
        queue.add(x);
        top = x;
    }

    public int top() {
        return top;
    }
 
    public int pop() {
        while(queue.size() != 1){
            top = queue.poll();
            tempQueue.add(top);
        }
        int ans = queue.poll();
        Queue<Integer> temp = queue;
        queue = tempQueue;
        tempQueue = temp;
        
        return ans;
    }
 
    public boolean empty() {
        return queue.size() == 0;
    }
}
 



// method 2 (Using 1 queue)
// Pop O(1), push O(n) && O(1), Space o(1)



class Queues
{
    Queue<Integer> q1 = new LinkedList<Integer>();
    
    
    void push(int a)
    {
	    q1.add(a);
	    int size = q1.size();
	    
	    while(size != 1){
	        q1.add(q1.poll());
	        size--;
        }
    }
    
    
    int pop()
    {
        if(q1.size() == 0)
            return -1;
	    return q1.remove();
    }
	
}


