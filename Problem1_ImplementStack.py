# // Space Complexity : O(n)
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this : None

class MyQueue(object):

    def __init__(self):
        self.main = []
        self.aux=[]
        
    # // Time Complexity : O(1)
    def push(self, x):
        """
        :type x: int
        :rtype: None
        """
        self.main.append(x)
        
    # // Time Complexity : O(n)
    def pop(self):
        """
        :rtype: int
        """
        self.transfer(self.main, self.aux)
        element = self.aux.pop()
        self.transfer(self.aux, self.main)
        return element
        
# // Time Complexity : O(n)
    def peek(self):
        """
        :rtype: int
        """
        self.transfer(self.main, self.aux)
        element = self.aux[-1]
        self.transfer(self.aux, self.main)
        return element
        
# // Time Complexity : O(1)
    def empty(self):
        """
        :rtype: bool
        """
        return len(self.main) == 0
    
    # // Time Complexity : O(n)
    def transfer(self, list1, list2):
        while list1:
            list2.append(list1.pop())
        


# Your MyQueue object will be instantiated and called as such:
# obj = MyQueue()
# obj.push(x)
# param_2 = obj.pop()
# param_3 = obj.peek()
# param_4 = obj.empty()
