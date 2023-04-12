#Time Complexity:O(n)
#Space Complexity:O(1)
class MyQueue(object):

    def __init__(self):
        self.stackIn=[]
        self.stackOut=[]

    def push(self, x):
        """
        :type x: int
        :rtype: None
        """
        self.stackIn.append(x)


    def pop(self):
        """
        :rtype: int
        """ 
        if not self.stackOut:
            while(self.stackIn):
                self.stackOut.append(self.stackIn.pop())
        return self.stackOut.pop()
        

    def peek(self):
        """
        :rtype: int
        """
        if self.stackOut: 
            return self.stackOut[len(self.stackOut)-1]
        return self.stackIn[0]

    def empty(self):
        """
        :rtype: bool
        """
        if self.stackIn or self.stackOut:
            return False
        return True
        


# Your MyQueue object will be instantiated and called as such:
# obj = MyQueue()
# obj.push(x)
# param_2 = obj.pop()
# param_3 = obj.peek()
# param_4 = obj.empty()