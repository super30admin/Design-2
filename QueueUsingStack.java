import java.util.Stack;

//Queue using TWO Stack. referenceStack is used for deleting element from queue and checking first element at queue.
//MainStack is used to add element into queue
//Reference Leetcode Solution approach2

 class QueueUsingStackImplementation {
	Stack<Integer> mainStack = new Stack();
	Stack<Integer>  referenceStack = new Stack();
	
	//Add element in queue
	public  void add(int item) {
		System.out.println("element added to queue = "+item);
		mainStack.push(item);
		
	}
	
	//removed element from queue:- FIFO first in first out
	//to remove element reference stack is used. Element from main stack are popped and pushed into reference stack
	// so that top element in mainstack will be at the bottom of reference stack. 
	//Reference stack contains top element which is first element which was inserted in main stack. this maintain FIFO.
	public int poll() {
		
		//if reference stack is empty
		if(referenceStack.isEmpty()) {
			//iterate over main stack till its empty and pushed element in reference stack from main stack.
			while(!mainStack.isEmpty()) {
				referenceStack.push(mainStack.pop());
			}
		}
		//if reference stack not empty then pop removes top element which is first element which was inserted.
		if(!referenceStack.isEmpty()) return referenceStack.pop();
		//if both stack are  empty the return -1.
		if(referenceStack.isEmpty() && mainStack.isEmpty()) {
			System.out.println("queue is empty");;
			return -1;
		}
		
		return referenceStack.pop();
		
		
	}
	
	//this method returns top element of reference stack which is first element inserted into main stack.
	public int peek() {
		//if both stack are empty return -1
		if(referenceStack.isEmpty() && mainStack.isEmpty()) return -1;
		
		// if reference stack is not empty then return top element
		if(!referenceStack.isEmpty()) return referenceStack.peek();
		//if reference stack is empty then pushed element from main stack into reference stack.
		if(referenceStack.isEmpty()) {
			while(!mainStack.isEmpty()) {
				referenceStack.push(mainStack.pop());
			}
		}
		return referenceStack.peek();
		
	}
	
//if both stacks are empty then return true
	public boolean isEmpty() {
		return referenceStack.isEmpty() && mainStack.isEmpty();
		
	}

}
class QueueUsingStack {
	public static void main(String args[]) {
		QueueUsingStackImplementation queue = new QueueUsingStackImplementation();
		queue.add(10);
		queue.add(20);
		queue.add(30);
		int deleted1 = queue.poll();

		System.out.println("Element removed from queue is = "+deleted1);
		int firstElement = queue.peek();
		
		System.out.println("Element at first of  queue is ="+firstElement);

	}
}

