// method 1
// time push and pop o(1) && space o(n)

class GfG{
    Stack<Integer> min = new Stack<>();
	public void push(int a,Stack<Integer> s)
	{
	    if(min.isEmpty())
	        min.add(a);
	    
	    if(min.peek() > a)
	        min.add(a);
	   
	   s.add(a);
	}
	public int pop(Stack<Integer> s)
    {
        if(s.peek() == min.peek())
            s.pop();
        
        return s.pop();
	}
	public int min(Stack<Integer> s)
    {
        return min.peek();       
	}
	public boolean isFull(Stack<Integer>s, int n)
    {
        return s.size() == n;
	}
	public boolean isEmpty(Stack<Integer>s)
    {
        return s.isEmpty();
	}
}




// method 2
// push and pop time O(1) && space O(1)


class GfG{
    
    private int min = Integer.MAX_VALUE;
	public void push(int a,Stack<Integer> s)
	{
	    if(s.size() == 0){
	        s.add(a);
	        min = a;
	    }else{
	        if(min <= a)
	            s.add(a);
	        else{
	            s.push(2*a-min);
	            min = a;
	        }
	    }
	}
	public int pop(Stack<Integer> s)
    {
        if(s.size() == 0) return -1;
        
        if(s.peek() >= min){
            return s.pop();
        }else{
            min = 2*min - s.peek();
            return s.pop();
        }
	}
	public int min(Stack<Integer> s)
    {
           return min;
	}
	public boolean isFull(Stack<Integer>s, int n)
        {
           return s.size() == n;
	}
	public boolean isEmpty(Stack<Integer>s)
        {
           return s.isEmpty();
	}
}
