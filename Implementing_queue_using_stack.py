# Time Complexity : O(n)
# Space Complexity : O(n) as we are using 2 stacks
# Did this code successfully run on Leetcode : yea
# Any problem you faced while coding this :
''' faced while writing the empty condition understanding the conditions like empty and not empty, 
 how to write in python understandong those terms'''

#Your code here along with comments explaining your approach
class MyQueue(object):

    def __init__(self):
        self.instack = []
        self.outstack = []
        
    def checking_if_outstackempty(self):
        if not self.outstack: #checking if stack empty
            while(self.instack):
                self.outstack.append(self.instack.pop())

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
        self.checking_if_outstackempty()
        if self.outstack:
            return self.outstack.pop() #deleting the top element from the outstack
        else:
            return None
       
    def peek(self):
        """
        :rtype: int
        """
        self.checking_if_outstackempty()
        if self.outstack:
            return self.outstack[-1] #searching the top element in the queue
        else:
            return None



    def empty(self):
        """
        :rtype: bool
        """
        if not self.instack and not self.outstack: #if the both stacks are empty then there are no elements in queue
            return True
        else:
            return False
        


# Your MyQueue object will be instantiated and called as such:
# obj = MyQueue()
# obj.push(x)
# param_2 = obj.pop()
# param_3 = obj.peek()
# param_4 = obj.empty()