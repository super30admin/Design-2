class MyQueue(object):

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.stack = []
        self.size = 0

    def push(self, x):
        """
        Push element x to the back of queue.
        :type x: int
        :rtype: None
        """
        # O(1) Time Complexity | O(1) Space Complexity
        self.stack.append(x)
        self.size += 1

    def pop(self):
        """
        Removes the element from in front of queue and returns that element.
        :rtype: int
        """
        # O(n) Time Complexity | O(n) Space Complexity
        if self.empty():
            return None

        temp_stack = []
        while (self.size > 0):
            temp_stack.append(self.stack.pop())
            self.size -= 1

        popped_elem = temp_stack.pop()
        while (len(temp_stack) > 0):
            x = temp_stack.pop()
            self.push(x)

        return popped_elem

    def peek(self):
        """
        Get the front element.
        :rtype: int
        """
        # O(1) Time Complexity | O(1) Space Complexity
        if self.empty():
            return None
        return self.stack[0]

    def empty(self):
        """
        Returns whether the queue is empty.
        :rtype: bool
        """
        # O(1) Time Complexity | O(1) Space Complexity
        return (self.size == 0)

# Your MyQueue object will be instantiated and called as such:
# obj = MyQueue()
# obj.push(x)
# param_2 = obj.pop()
# param_3 = obj.peek()
# param_4 = obj.empty()