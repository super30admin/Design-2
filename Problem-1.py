# Time Complexity : Amortized O(1) per operation
# Space Complexity :on)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : NA


# Your code here along with comments explaining your approach

class MyQueue:
    def __init__(self):
        # Initialize two stacks:
        # instk  -> used for enqueue (push) operations
        # outstk -> used for dequeue (pop) operations
        self.instk = []
        self.outstk = []

    def push(self, x: int) -> None:
        # Push an element onto the input stack (enqueue)
        self.instk.append(x)

    def pop(self) -> int:
        # Remove and return the element at the front of the queue (dequeue)
        if self.empty():
            # If both stacks are empty, the queue has no elements
            return -1
        self.peek()  # Ensure outstk has the correct order for popping
        return self.outstk.pop()

    def peek(self) -> int:
        # Get the element at the front of the queue without removing it
        # If outstk is empty, transfer all elements from instk to outstk
        # This reverses the order to maintain queue (FIFO) behavior
        if not self.outstk:
            while self.instk:
                self.outstk.append(self.instk.pop())
        return self.outstk[-1]

    def empty(self) -> bool:
        # Return True if both stacks are empty (i.e., queue is empty)
        return not self.instk and not self.outstk


# Example usage:
# obj = MyQueue()
# obj.push(x)       -> enqueue x
# obj.pop()         -> dequeue and return front element
# obj.peek()        -> return front element without removing it
# obj.empty()       -> check if queue is empty
