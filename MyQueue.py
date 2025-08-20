# Time Complexity : O(1)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


# Your code here along with comments explaining your approach
    # - using two stacks to mimic queues FIFO with Stacks LIFO
class MyQueue:

    def __init__(self):
        self.inStack = [] # using this for push operations
        self.outStack = [] # using this for pop or peep operations

    # A helper method as will be called in for both pop and peek
    def move(self) -> None:
        # We have to move elements to outstack if it is empty
        if not self.outStack:
            while self.inStack:
                self.outStack.append(self.inStack.pop())
    
    def push(self, x: int) -> None:
        self.inStack.append(x) # a normal insert

    def pop(self) -> int:
        self.move()
        return self.outStack.pop() # return the popped element

    def peek(self) -> int:
        self.move()
        return self.outStack[-1] # show the last value

    def empty(self) -> bool:
        return not self.inStack and not self.outStack # check if the queue is empty or not
        

# Your MyQueue object will be instantiated and called as such:
# obj = MyQueue()
# obj.push(x)
# param_2 = obj.pop()
# param_3 = obj.peek()
# param_4 = obj.empty()