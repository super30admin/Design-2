# Use two stacks (stack1 and stack2) to implement a FIFO queue.
# Elements are pushed onto stack1 and popped/peeked from stack2, with elements being transferred between the two stacks as needed to maintain the correct order.
class Queue:
    def __init__(self):
        """
        Time complexity: O(1)
        Space complexity: O(n)
        """
        self.stack1 = []
        self.stack2 = []

    def push(self, x: int) -> None:
        """
        Time complexity: O(1)
        Space complexity: O(1)
        """
        self.stack1.append(x)

    def pop(self) -> int:
        """
        Time complexity: Amortized O(1), Worst-case O(n)
        Space complexity: O(1)
        """
        self.peek()
        return self.stack2.pop()

    def peek(self) -> int:
        """
        Time complexity: Amortized O(1), Worst-case O(n)
        Space complexity: O(1)
        """
        if not self.stack2:
            while self.stack1:
                self.stack2.append(self.stack1.pop())
        return self.stack2[-1]

    def empty(self) -> bool:
        """
        Time complexity: O(1)
        Space complexity: O(1)
        """
        return not (self.stack1 or self.stack2)
