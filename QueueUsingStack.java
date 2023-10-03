import java.util.Stack;

//step 1: stack if LIFO and queue is FIFO
//step 2: queue has 3 operations, enqueue, dequeue and peek
//step 3: when enqueue : push into the stack
//step 4: when dequeue : if stack 2 empty -> stack 1 push to stack 2 (check if stack 1 not empty), remove from stack 2
//step 5: peek, stack 2 peek 

//Time Complexity for all: O(1) amortized time complexity   
//Space Complexity : O(n)
// Solution runs on leetcode

class QueueUsingStack {

    private Stack<Integer> stack1;
    private Stack<Integer> stack2;

    public QueueUsingStack(){
        stack1 = new Stack<Integer>();
        stack2 = new Stack<Integer>();
    }
    
    public static void main(String[] args)
    {
        QueueUsingStack stackQueue = new QueueUsingStack();
        stackQueue.enqueue(4);
        stackQueue.enqueue(5);
        stackQueue.enqueue(6);
        stackQueue.enqueue(4);
        stackQueue.enqueue(5);
        stackQueue.enqueue(6);
        stackQueue.enqueue(4);
        stackQueue.enqueue(5);

        stackQueue.dequeue();
        stackQueue.dequeue();
        stackQueue.dequeue();

        stackQueue.peek();

    }

    public void enqueue(int value)
    {
        stack1.push(value);
    }

    public void dequeue()
    {
        if(stack2.isEmpty())
        {
            while(!stack1.isEmpty()){
                stack2.push(stack1.pop());
            }
        }else if(stack1.isEmpty()){
            System.out.println("queue is empty");
        }

        System.out.println("Element removed from queue: " + stack2.pop());
    }

    public void peek()
    {
        if(stack2.isEmpty())
        {
            while(!stack1.isEmpty()){
                stack2.push(stack1.pop());
            }
        }
        else if(stack1.isEmpty()){
            System.out.println("no elements in queue");
        }

        System.out.println("Element in queue:" + stack2.peek());
    }


}