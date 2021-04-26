"""
Space Complexity: O(n)
Runtime Complexity:
push --> O(1)
pop --> O(1)
peek --> O(1)
empty --> O(1)

Yes it ran successfully run on LeetCode
No problems faced other than the ones already discussed in class.
"""

class MyQueue:

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.arr = list()

    def push(self, x: int) -> None:
        """
        Push element x to the back of queue.
        """
        self.arr.append(x)

    def pop(self) -> int:
        """
        Removes the element from in front of queue and returns that element.
        """
        element = self.arr[0]
        self.arr.remove(self.arr[0])
        return element

    def peek(self) -> int:
        """
        Get the front element.
        """
        return self.arr[0]

    def empty(self) -> bool:
        """
        Returns whether the queue is empty.
        """
        if len(self.arr) == 0:
            return True
        else:
            return False

# Your MyQueue object will be instantiated and called as such:
# obj = MyQueue()
# obj.push(x)
# param_2 = obj.pop()
# param_3 = obj.peek()
# param_4 = obj.empty()
