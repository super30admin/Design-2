# Time complexity :- Push O(n), pop, top O(1)
# Space compexity :- O(n)

# Runs on Leetcode :- Yes

# problems :- None. Need to figure how to do push in O(1)


class MyQueue:

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.stack1 = []
        self.stack2 = []

    def push(self, x: int) -> None:
        """
        Push element x to the back of queue.
        """
        
        while self.stack1:
            self.stack2.append(self.stack1.pop())
        self.stack2.append(x)
        
        while self.stack2:
            self.stack1.append(self.stack2.pop())
        

    def pop(self) -> int:
        """
        Removes the element from in front of queue and returns that element.
        """
        return self.stack1.pop()
        

    def peek(self) -> int:
        """
        Get the front element.
        """
        return self.stack1[-1]
        

    def empty(self) -> bool:
        """
        Returns whether the queue is empty.
        """
        return len(self.stack1) == 0


# Your MyQueue object will be instantiated and called as such:
# obj = MyQueue()
# obj.push(x)
# param_2 = obj.pop()
# param_3 = obj.peek()
# param_4 = obj.empty()