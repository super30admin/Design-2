class MyQueue:

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.stack1 = []  # For pushing elements
        self.stack2 = []  # For popping elements

    def push(self, x: int) -> None:
        """
        Push element x to the back of the queue.
        """
        self.stack1.append(x)

    def pop(self) -> int:
        """
        Removes the element from the front of the queue and returns that element.
        """
        # Ensure that stack2 is empty before moving elements
        self.move_elements()
        
        # Pop the front element from stack2 (if available)
        if self.stack2:
            return self.stack2.pop()
        else:
            return None  # Queue is empty

    def peek(self) -> int:
        """
        Get the front element of the queue without removing it.
        """
        # Ensure that stack2 is empty before moving elements
        self.move_elements()
        
        # Return the top element of stack2 (if available)
        if self.stack2:
            return self.stack2[-1]
        else:
            return None  # Queue is empty

    def empty(self) -> bool:
        """
        Returns whether the queue is empty.
        """
        # The queue is empty if both stacks are empty
        return not self.stack1 and not self.stack2

    def move_elements(self):
        """
        Helper function to move elements from stack1 to stack2 if stack2 is empty.
        """
        if not self.stack2:
            while self.stack1:
                self.stack2.append(self.stack1.pop())

# Time Complexity Analysis:
# - Push operation: O(1)
# - Pop and Peek operations (amortized): O(1)
# - Empty operation: O(1)

# Space Complexity Analysis:
# - The space complexity is O(n), where n is the number of elements in the queue.
# - Each element is stored in either stack1 or stack2.

# Note: Although the pop and peek operations have an amortized O(1) time complexity, in the worst case, they can be O(n) if all elements are moved from stack1 to stack2. However, this is an infrequent scenario, and the amortized time complexity is O(1) for practical purposes.
