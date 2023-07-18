import java.util.Stack;

public class Problem_1 {
    
    static class Queue{

        /* class of Queue with 2 stacks */
        Stack<Integer> stack1;
        Stack<Integer> stack2;

    }
    /* Function to push an item to stack */
    static void push (Stack<Integer> top, int new_data){
        top.push(new_data);

    }

    /* Function to pop an item from stack */
    static int pop (Stack<Integer> top)
    {
        if(top.isEmpty())
        {
            return -1;
        }
        return top.pop();
    }
    
    /* Function to enqueue an item to the queue */
    static void enqueue(Queue q, int x)
    {
        push(q.stack1,x);
    }

    /* Function to dequeue an item from the queue */
    static int deQueue (Queue q)
    {
        int x;
        
        /* If both stacks are empty return error */
        if(q.stack1.isEmpty() && q.stack2.isEmpty())
        {
            return -1;
        }

        /* Move elements from stack1 to stack2 only if stack2 is empty */
        if(q.stack2.isEmpty())
        {
            while(!q.stack1.isEmpty())
            {
                x = pop(q.stack1);
                push(q.stack2, x);
            }
        }

        x = pop(q.stack2);
        return x;

    }

    public static void main(String[] args) {
        
        /* create a queue with items 1 2 3 4 */
        Queue q = new Queue();
        q.stack1 =new Stack<>();
        q.stack2 = new Stack<>();
        enqueue(q, 1);
        enqueue(q, 2);
        enqueue(q, 3);
        
        System.out.print(deQueue(q) + " " );
        System.out.print(deQueue(q) + " " );
        System.out.println(deQueue(q) + " " );

    }

}
