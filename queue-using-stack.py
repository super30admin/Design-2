# // Time Complexity : O(1) push, O(n) pop, peek
# // Space Complexity : O(n) auxillary stacks
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this : No


# // Your code here along with comments explaining your approach
# Using 2 stacks - one input and one output
# For all push operations, push into input stack
# For pop and peek - if output stack is not empty, return the last element, 
# else pop all elements from input stack and push to output stack and return the last element from output stack

class MyQueue:
    
    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.input = []
        self.output = []

    def push(self, x: int) -> None:
        """
        Push element x to the back of queue.
        """
        self.input.append(x)

    def pop(self) -> int:
        """
        Removes the element from in front of queue and returns that element.
        """
        self.peek()
        return self.output.pop()

    def peek(self) -> int:
        """
        Get the front element.
        """
        if(self.output == []):
            while(self.input != []):
                self.output.append(self.input.pop())
        return self.output[-1]

    def empty(self) -> bool:
        """
        Returns whether the queue is empty.
        """
        return self.input == [] and self.output == []


# Your MyQueue object will be instantiated and called as such:
# obj = MyQueue()
# obj.push(x)
# param_2 = obj.pop()
# param_3 = obj.peek()
# param_4 = obj.empty()