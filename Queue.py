class MyQueue:

    # Time Complexity : O(1)
    # Space Complexity : O(1)
    # Did this code successfully run on Leetcode : Yes
    # Any problem you faced while coding this : No

    # Initialize with an empty Stack
    def __init__(self):
        self.queue = []

    # Time Complexity : O(1)
    # Space Complexity : O(n)
    # Did this code successfully run on Leetcode : Yes
    # Any problem you faced while coding this : No

    # Add to the end of the stack
    def push(self, x: int) -> None:
        self.queue.append(x)

    # Time Complexity : O(1)
    # Space Complexity : O(1)
    # Did this code successfully run on Leetcode : Yes
    # Any problem you faced while coding this : No

    # Return the first element and slice the array, pop the first element
    def pop(self) -> int:
        toRet = self.queue[0]
        if len(self.queue) == 1:
            self.queue = []
        else:
            self.queue = self.queue[1:]
        return toRet

    # Time Complexity : O(1)
    # Space Complexity : O(1)
    # Did this code successfully run on Leetcode : Yes
    # Any problem you faced while coding this : No

    # Return the first element
    def peek(self) -> int:
        return self.queue[0]

    # Time Complexity : O(1)
    # Space Complexity : O(1)
    # Did this code successfully run on Leetcode : Yes
    # Any problem you faced while coding this : No

    # Return True is the length of the array is 0, False otherwise
    def empty(self) -> bool:
        if len(self.queue) == 0:
            return True
        return False


# Your MyQueue object will be instantiated and called as such:
# obj = MyQueue()
# obj.push(x)
# param_2 = obj.pop()
# param_3 = obj.peek()
# param_4 = obj.empty()
