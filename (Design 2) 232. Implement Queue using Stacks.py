"""
Implement the following operations of a queue using stacks.

push(x) -- Push element x to the back of queue.
pop() -- Removes the element from in front of queue.
peek() -- Get the front element.
empty() -- Return whether the queue is empty.
Example:

MyQueue queue = new MyQueue();

queue.push(1);
queue.push(2);  
queue.peek();  // returns 1
queue.pop();   // returns 1
queue.empty(); // returns false
"""
class MyQueue:

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.push_stack = []
        self.pop_stack = []

    def push(self, x: int) -> None:
        """
        Push element x to the back of queue.
        """
        self.push_stack.append(x)
        

    def pop(self) -> int:
        """
        Removes the element from in front of queue and returns that element.
        """
        if (self.pop_stack):
            return self.pop_stack.pop()
        
        while(self.push_stack):
            self.pop_stack.append(self.push_stack.pop())
        return self.pop_stack.pop()
        

    def peek(self) -> int:
        """
        Get the front element.
        """
        if (self.pop_stack):
            return self.pop_stack[-1]
        while(self.push_stack):
            self.pop_stack.append(self.push_stack.pop())
        return self.pop_stack[-1]
        

    def empty(self) -> bool:
        """
        Returns whether the queue is empty.
        """
        if (not self.push_stack and not self.pop_stack):
            return True
        return False


# Your MyQueue object will be instantiated and called as such:
# obj = MyQueue()
# obj.push(x)
# param_2 = obj.pop()
# param_3 = obj.peek()
# param_4 = obj.empty()