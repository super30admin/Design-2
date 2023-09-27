class MyQueue(object):

    def __init__(self):
        self.stk1 = []
        self.stk2 = []

    def push(self, x):
        """
        :type x: int
        :rtype: None
        """
        if self.stk2:
            while self.stk2:
                self.stk1.append(self.stk2.pop())
        self.stk1.append(x)
        while self.stk1:
            self.stk2.append(self.stk1.pop())

    def pop(self):
        """
        :rtype: int
        """
        if self.stk2:
            return self.stk2.pop()

    def peek(self):
        """
        :rtype: int
        """
        return self.stk2[-1]

    def empty(self):
        """
        :rtype: bool
        """
        return len(self.stk2) == 0

# Your MyQueue object will be instantiated and called as such:
# obj = MyQueue()
# obj.push(x)
# param_2 = obj.pop()
# param_3 = obj.peek()
# param_4 = obj.empty()