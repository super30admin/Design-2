"""
Time Complexity-Push-O(1)
Pop-O(n)
Peek-O(n)
Empty-O(1)

Space Complexity-
Push-O(n)
Pop-O(1)
Peek-O(1)
empty-O(1)

Approach-
We take two stacks and inintialzie them. We append elements to stack1 as and when we encounter them.
For popping element we first see if the stack 2 is empty, if it is we begin popping elements from stack 1 to stack2
so that the last inserted element in stack 1 becomes the first or top element in stack 2, and we pop that elemnt.
For peeking also we do the same and return the top element. For isempty we just check if both the stacks are empty or not and return boolean.

"""

class MyQueue:

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.stack1=[]
        self.stack2=[]


    def push(self, x: int) -> None:
        """
        Push element x to the back of queue.
        """
        self.stack1.append(x)

    def pop(self) -> int:
        """
        Removes the element from in front of queue and returns that element.
        """
        if not self.stack2:
            while self.stack1:
                self.stack2.append(self.stack1.pop())
        return self.stack2.pop()

    def peek(self) -> int:
        """
        Get the front element.
        """
        if not self.stack2:
            while self.stack1:
                self.stack2.append(self.stack1.pop())
        return self.stack2[-1]

    def empty(self) -> bool:
        """
        Returns whether the queue is empty.
        """
        return (not self.stack1) and (not self.stack2)

# Your MyQueue object will be instantiated and called as such:
# obj = MyQueue()
# obj.push(x)
# param_2 = obj.pop()
# param_3 = obj.peek()
# param_4 = obj.empty()