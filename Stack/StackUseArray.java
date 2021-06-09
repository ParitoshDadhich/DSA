package stacks;

public class StackUseArray {
	private int data[];
	private int top;
	
	public StackUseArray() {
		data = new int[10];
		top = -1;
	}
	
	public StackUseArray(int capacity) {
		data = new int[capacity];
		top = -1;
	}
	
	public int size() {
		return top + 1;
	}
	
	public int top() {
		if(top == -1)
			return -1;
		
		return data[top];
	}
	
	public boolean isEmpty() {
		return top == -1;
	}
	
	public int pop() {
		if(size() == 0)
			return -1;
		
		return data[top--];
	}
	
	public void push(int val) {
		if(size() == data.length)
			doubleSize();
		
		data[++top] = val;
	}

	private void doubleSize() {
		int temp[] = data;
		data = new int[2*data.length];
		for(int i=0; i<temp.length; i++)
			data[i] = temp[i];
		
	}
}

class StackArray{
	 public static void main(String args[]) {
		 StackUseArray s = new StackUseArray();
			for(int i=0; i<=10; i++)
				s.push(i);
			
			while(!s.isEmpty())
				System.out.println(s.pop());
	 }
		
}
