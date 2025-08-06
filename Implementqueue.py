class MyQueue(object):

    def __init__(self):
        self.inbound = []
        self.outbound = []

    def push(self, x):
        """
        :type x: int
        :rtype: None
        """
        self.inbound.append(x)
        

    def pop(self):
        """
        :rtype: int
        """
        self.peek()
        return self.outbound.pop()
        

    def peek(self):
        """
        :rtype: int
        """
        if not self.outbound:
            while self.inbound:
                self.outbound.append(self.inbound.pop())
        return self.outbound[-1]
        

    def empty(self):
        """
        :rtype: bool
        """
        return not self.outbound and not self.inbound
        


# Your MyQueue object will be instantiated and called as such:
# obj = MyQueue()
# obj.push(x)
# param_2 = obj.pop()
# param_3 = obj.peek()
# param_4 = obj.empty()