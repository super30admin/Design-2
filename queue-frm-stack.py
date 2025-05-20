# Time Complexity :O(1)
# Space Complexity :O(N)
# Did this code successfully run on Leetcode :yes
# Any problem you faced while coding this :
#Initially was not checking wether s2 was empty

# Your code here along with comments explaining your approach

#Algo
#Take two stacks
# when elements are pushed from one stack to other, they form a queue (Invertion of FIFO)



class MyQueue(object):

    def __init__(self):
        self.s1 = []
        self.s2 = []

    def push(self, x):
        """
        :type x: int
        :rtype: None
        """
        self.s1.append(x)

        

    def pop(self):
        """
        :rtype: int
        """
        if not self.s2:
            while self.s1:
                self.s2.append(self.s1.pop())
        
        return self.s2.pop()
        

    def peek(self):
        """
        :rtype: int
        """
        if not self.s2:
            while self.s1:
                self.s2.append(self.s1.pop())
        return self.s2[-1]
        

    def empty(self):
        """
        :rtype: bool
        """
        return not (self.s1 or self.s2)