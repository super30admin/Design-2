class MyQueue(object):

    def __init__(self):
        self.inQueue = []
        self.outQueue = []
        

    def push(self, x):
        self.inQueue.append(x)
        """
        :type x: int
        :rtype: None
        """
        

    def pop(self):
        """
        :rtype: int
        """
        self.peek()
        return self.outQueue.pop()

    def peek(self):
        if not self.outQueue:
            while(self.inQueue):
                self.outQueue.append(self.inQueue.pop())
            else:
                print("main stack is empty")
        return self.outQueue[-1]
        """
        :rtype: int
        """
        

    def empty(self):
        return not self.inQueue and not self.outQueue
        """
        :rtype: bool
        """
        


# Your MyQueue object will be instantiated and called as such:
# obj = MyQueue()
# obj.push(x)
# param_2 = obj.pop()
# param_3 = obj.peek()
# param_4 = obj.empty()