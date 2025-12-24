// Time Complexity :
// Push() - Amortized O(1), Pop - , Peek - Amortized O(1), Peek - Amortized O(1)
// Space Complexity : O(N), using extra stack to keep elements
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
import java.util.Stack;


public class Queue {
    private final Stack<Integer> allElements = new Stack<>();
    private final Stack<Integer> remainingElements = new Stack<>();

    public Queue() {

    }

    // Push to all elements stack if no elements in the queue - O(1)
    // If there are remaining elements, push them to all elements stack and push new element - O(N)
    // So amortized O(1) time complexity
    public void push(int x) {
        if(empty()){
            allElements.push(x);
            return;
        }

        while (!remainingElements.isEmpty()) {
            allElements.push(remainingElements.pop());
        }

        allElements.push(x);
    }

    // If queue is empty return -1
    // If the remaining elements is not empty, pop value from that and return - O(1)
    // If no remaining elements, check if all elements is empty, if not pop all elements and move them to
    // remaining elements stack and pop the topmost - O(N)
    // So amortized O(1) time complexity
    public int pop() {
        if(empty()){
            return -1;
        }

        if(!remainingElements.isEmpty()){
            return remainingElements.pop();
        }
        int lastElement = -1;
        while(!allElements.isEmpty()){
            remainingElements.push(allElements.pop());
        }
        lastElement = remainingElements.pop();
        return lastElement;
    }

    // If queue is empty return -1
    // If the remaining elements is not empty, peek the top value from that and return- O(1)
    // If no remaining elements, check if all elements is empty, if not pop all elements and move them to
    // remaining elements stack and peek the topmost - O(N)
    // So amortized O(1) time complexity
    public int peek() {
        if(empty()){
            return -1;
        }
        if(!remainingElements.isEmpty()){
            return remainingElements.peek();
        }
        int lastElement = -1;
        while(!allElements.isEmpty()){
            lastElement = allElements.pop();
            remainingElements.push(lastElement);
        }
        return lastElement;
    }

    public boolean empty() {
        return allElements.isEmpty() && remainingElements.isEmpty();
    }
}
