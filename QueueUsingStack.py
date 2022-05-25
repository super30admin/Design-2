from collections import deque
class MyQueue(object):

    def __init__(self):
        self.stack1=deque()
        self.stack2=deque()

    def push(self, x):
        """
        :type x: int
        :rtype: None
        """
        self.stack1.append(x)
        

    def pop(self):
        """
        :rtype: int
        """
        if self.empty():
            print("Queue is empty")
        elif len(self.stack2) ==0:
            while len(self.stack1) != 0:
                self.stack2.append(self.stack1.pop())
        return self.stack2.pop()
    
    def peek(self):
        """
        :rtype: int
        """
        if len(self.stack1) == 0 and len(self.stack2) ==0:
            print("Queue is empty")
        elif len(self.stack2) ==0:
            while len(self.stack1) != 0:
                self.stack2.append(self.stack1.pop())
        return self.stack2[-1]
        

    def empty(self):
        """
        :rtype: bool
        """
        return (len(self.stack1)==0 and len(self.stack2)==0)
        


# Your MyQueue object will be instantiated and called as such:
# obj = MyQueue()
# obj.push(x)
# param_2 = obj.pop()
# param_3 = obj.peek()
# param_4 = obj.empty()
