"""
Time Complexity:
Push: O(1)
Pop: O(1)[Amortised average complexity]
Space Complexity : O(n)
"""
class MyQueue:

    def __init__(self):
        self.IN = []
        self.OUT = []
        """
        Initialize your data structure here.
        """

    def push(self, x: int) -> None:
        self.IN.append(x)
        """
        Push element x to the back of queue.
        """

    def pop(self) -> int:
        if len(self.OUT) == 0:
            while len(self.IN) != 0:
                self.OUT.append(self.IN.pop())

        return self.OUT.pop()

        """
        Removes the element from in front of queue and returns that element.
        """

    def peek(self) -> int:
        if len(self.OUT) == 0:
            while len(self.IN) != 0:
                self.OUT.append(self.IN.pop())

        return self.OUT[-1]
        """
        Get the front element.
        """

    def empty(self) -> bool:
        if len(self.IN) == 0 and len(self.OUT) == 0:
            return True
        return False