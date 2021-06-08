// method 1
// push O(1) , pop O(n) && space O(n)

class StackQueue
{
    Stack<Integer> s1 = new Stack<Integer>();
    Stack<Integer> s2 = new Stack<Integer>();


    void Push(int x)
    {
	   s1.push(x);
    }
	
	
    int Pop()
    {
        if(s1.size() == 0)
            return -1;
        
	   while(s1.size() != 0)
	        s2.add(s1.pop());
	   
	   int ans = s2.pop();
	   
	    while(s2.size() != 0)
	        s1.add(s2.pop());
	   
	   return ans;
    }
}



// methdo 2
// (Two Stacks) Push - O(n)O(n) per operation, Pop - O(1)O(1) per operation.

class MyQueue {
 
    Stack<Integer> s1 = new Stack<>();
    Stack<Integer> s2 = new Stack<>();
    private int front;

    public void push(int x) {
        if(s1.isEmpty())
            front = x;
        
        while(!s1.isEmpty())
            s2.add(s1.pop());
        
        s1.add(x);
        
        while(!s2.isEmpty())
            s1.add(s2.pop());
    }
    
 
    public int pop() {
        return s1.pop();
    }
    
 
    public int peek() {
        return s1.peek();
    }
     
    
    public boolean empty() {
        return s1.size() == 0;
    }
}
 

// method 3
// (Two Stacks) Push - O(1)O(1) per operation, Pop - Amortized O(1)O(1) per operation.

class MyQueue {
 
    Stack<Integer> s1 = new Stack<>();
    Stack<Integer> s2 = new Stack<>();
    private int front;

    public void push(int x) {
        if(s1.size() == 0)
            front = x;
         s1.add(x);
    }
    
    public int pop() {
        if(s2.isEmpty()){
            while(!s1.isEmpty())
                s2.add(s1.pop());
        }
        
        return s2.pop();
    }
    
 
    public int peek() {
        if(s2.size() != 0)
            return s2.peek();
        return front;
    }
     
    
    public boolean empty() {
        return s1.isEmpty() && s2.isEmpty();
    }
}
 
