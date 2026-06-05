# Implement QUEUE using STACKS
# Time Complexity : push, peek and empty function is O(1) , 
# pop is O(1) in amortized and O(N) in worst case 
# Space Complexity : O(N) where N is the number of elements stored in the queue
# Did this code successfully run on Leetcode : YES
# Any problem you faced while coding this : NONE


class MyQueue(object):

    def __init__(self):
        self.instack=[]
        self.outstack=[]

    def push(self, x):
        """
        :type x: int
        :rtype: None
        """
        self.instack.append(x)
        

    def pop(self):
        """
        :rtype: int
        """
        if self.empty():
            return -1
        self.peek()
        return self.outstack.pop()
        

    def peek(self):
        """
        :rtype: int
        """
        if not self.outstack:
            while self.instack:
                self.outstack.append(self.instack.pop())
        return self.outstack[-1]
        

    def empty(self):
        """
        :rtype: bool
        """
        return not self.instack and not self.outstack
        


# Your MyQueue object will be instantiated and called as such:
# obj = MyQueue()
# obj.push(x)
# param_2 = obj.pop()
# param_3 = obj.peek()
# param_4 = obj.empty()