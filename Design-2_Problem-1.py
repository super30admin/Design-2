# Time Complexity :O(n)
# Space Complexity :O(n)
# Did this code successfully run on Leetcode :Yes       
# Any problem you faced while coding this :No

#Approach:- Keep One Stack as Queue and Other to Convert LIFO to FIFO that means to append a element to Queue first 
#we must pop all elements from Stack 1 to Stack 2 then append Stack 1 with new element and pop all element from Stack 2 and push to Stack 1 



class MyQueue(object):

    def __init__(self):
        self.S1=[]
        self.S2=[]
        

    def push(self, x):
        while(self.S1!=[]):
            self.S2.append(self.S1[-1])
            self.S1=self.S1[:-1]
        self.S1.append(x)
        while(self.S2!=[]):
            self.S1.append(self.S2[-1])
            self.S2=self.S2[:-1]

        

    def pop(self):
        """
        :rtype: int
        """
        l=self.S1[-1]
        self.S1=self.S1[:-1]
        return(l)

    def peek(self):
        """
        :rtype: int
        """
        return(self.S1[-1])

    def empty(self):
        """
        :rtype: bool
        """
        return(self.S1==[])