#implement queue using stacks#
class MyQueue(object):

    def __init__(self):
        self.inqueue=[]
        self.outqueue=[]

    def push(self, x):
        """
        :type x: int
        :rtype: None
        appends  the element
        """
        self.inqueue.append(x)
        

    def pop(self):
        """
        :rtype: int
        removes the element
        """
        if len(self.outqueue)==0:
            while len(self.inqueue)!=0:
                self.outqueue.append(self.inqueue.pop())
        return self.outqueue.pop()
        

    def peek(self):
        """
        :rtype: int
        shows the top element
        """
        if len(self.outqueue)==0:
            while len(self.inqueue)!=0:
                self.outqueue.append(self.inqueue.pop())
        return self.outqueue[-1]
        

    def empty(self):
        """
        :rtype: bool
        checks if queue is empty or not
        """
        return not self.inqueue and not self.outqueue
        


# Your MyQueue object will be instantiated and called as such:
# obj = MyQueue()
# obj.push(x)
# param_2 = obj.pop()
# param_3 = obj.peek()
# param_4 = obj.empty()