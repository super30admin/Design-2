class MinStack(object):

    def __init__(self):
        self.mystack = []
        self.minstack = []
        

    def push(self, val):
        """
        :type val: int
        :rtype: None
        """
        self.mystack.append(val)
        if self.minstack:
            last = self.minstack[-1]
        else: last = val
        if val < last:
            self.minstack.append(val)
        else:
            self.minstack.append(last)
        

    def pop(self):
        """
        :rtype: None
        """
        self.mystack.pop()
        self.minstack.pop()
        

    def top(self):
        """
        :rtype: int
        """
        return self.mystack[-1]
        

    def getMin(self):
        """
        :rtype: int
        """
        return self.minstack[-1]
        


# Your MinStack object will be instantiated and called as such:
# obj = MinStack()
# obj.push(val)
# obj.pop()
# param_3 = obj.top()
# param_4 = obj.getMin()
