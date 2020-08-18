# Space complexity - O(n)

class MyQueue:

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.pushStack = []
        self.popPeekStack = []

    # Push - append the element to the Push stack.
    # Time complexity - O(1)
    def push(self, x: int) -> None:
        """
        Push element x to the back of queue.
        """
        self.pushStack.append(x)
        
    # Pop - Check if the popPeek stack is empty. pop the elements out of the push stack, and to the popPeek stack. Pop the top element from this stack.
    # Time complexity - O(1) amortized | O(2n) worst case
    def pop(self) -> int:
        """
        Removes the element from in front of queue and returns that element.
        """
        if not self.popPeekStack:
            while self.pushStack:
                self.popPeekStack.append(self.pushStack.pop())
        return self.popPeekStack.pop()

    # Peek - Check if the popPeek stack is empty. pop the elements out of the push stack, and to the popPeek stack. Return the top element from this stack.
    # Time complexity - O(1) amortized | O(2n) worst case
    def peek(self) -> int:
        """
        Get the front element.
        """
        if not self.popPeekStack:
            while self.pushStack:
                self.popPeekStack.append(self.pushStack.pop())
        return self.popPeekStack[-1]

    # Check whether both the popPeek and push Stacks are empty.
    # Time - O(1)
    def empty(self) -> bool:
        """
        Returns whether the queue is empty.
        """
        return not self.popPeekStack and not self.pushStack


# Your MyQueue object will be instantiated and called as such:
# obj = MyQueue()
# obj.push(x)
# param_2 = obj.pop()
# param_3 = obj.peek()
# param_4 = obj.empty()

