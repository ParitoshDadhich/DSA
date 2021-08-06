class GfG{
	public Stack<Integer> sort(Stack<Integer> s)
	{
	    if(s.size() == 1)
	        return s;
	   
	   int val = s.pop();
	   s = sort(s);
	   s = insert(s, val);
	   
	   return s;
	}
	
 
	
	
	private static Stack<Integer> insert(Stack<Integer> s, int val){
	    if(s.isEmpty() || s.peek() <= val){
	        s.push(val);
	        return s;
	    }
	   
	   int element = s.pop();
	   s = insert(s, val);
	   s.push(element);
	   
	   return s;
	}
	
}
