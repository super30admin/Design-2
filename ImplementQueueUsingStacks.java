//Approach: The idea is to hold elements in one stack, until a pop() or peek() happens and copy the elements from first stack to another and then pop() or peek()

// Time Complexity for Pop() and Peek() is O(n) (as linear traversal is involved)
// Time Complexity for Push() and empty() is O(1)

// Space Complexity: O(n), as we have to maintain another stack to temporarily hold elements for pop() and peek() operations

class MyQueue {

    Stack<Integer> firstStack;
    Stack<Integer> secondStack;

    public MyQueue() {
        firstStack = new Stack<>();
        secondStack = new Stack<>();
    }

    public void push(int x) {
        firstStack.push(x);
    }

    public int pop() {
        peek();
        return secondStack.pop();
    }

    public int peek() {
        if(secondStack.size() == 0){
            while(firstStack.size() != 0)
            {
                secondStack.push(firstStack.pop());
            }
        }

        return secondStack.peek();
    }

    public boolean empty() {
        return firstStack.size() == 0 && secondStack.size() == 0;
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */