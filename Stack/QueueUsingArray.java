package queue;

public class QueueUsingArray {
	private int data[];
	private int front;
	private int rear;
	private int size;
	
	QueueUsingArray() {
		data = new int[10];
		front = -1;
		rear = -1;
		size = 0;
	}
	
	QueueUsingArray(int capacity){
		data = new int[capacity];
		front = -1;
		rear = -1;
		size = 0;
	}
	
	public int size() {
		return size;
	}
	
	public boolean isEmpty() {
		return size == 0;
	}
	public int front() {
		if(size == 0)
			return -1;
		return data[front];
	}
	
	public int rear() {
		if(size() == 0)
			return -1;
		
		return data[rear];
	}
	
	public void enqueue(int val) {
		if(size == 0)
			front = 0;
		
		rear = (rear+1)%data.length;
		size++;
		data[rear] = val;
	}
	
	public int dequeue() {
		if(size == 0)
			return -1;
		
		int temp = data[front];
		
		front = (front+1)%data.length;
		size--;
		if(size == 0) {
			rear = -1;
			front = -1;
		}
		
		return temp;
	}
}

class QueueUse{
	public static void main(String args[]) {
		QueueUsingArray q = new QueueUsingArray();
		for(int i=0; i<10; i++)
			q.enqueue(i);
		
		while(!q.isEmpty())
			System.out.println(q.dequeue());
	}
}
