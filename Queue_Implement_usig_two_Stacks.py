#Time Complexity : O(N) for pop O(1) for pop
#Space Complexity :O(N)
#Did this code successfully run on Leetcode : Yes
#Any problem you faced while coding this : took a lot of time in pop


class MyQueue(object):

    def __init__(self):
        """
        Initialize your data structure here.
        """
        # list a is the main stack anf list b is secondary stack
        self.a = []
        self.b = []

    def push(self, x):
        """
        Push element x to the back of queue.
        :type x: int
        :rtype: None
        """
        #append the incoming value to the main stack
        self.a.append(x)
            
    def pop(self):
        """
        Removes the element from in front of queue and returns that element.
        :rtype: int
        """
        # First pop all from main stack and add to secondary stack 
        # then pop the last element added from the secondary stack and store in variable h
        # then pop all the elements from secondary to main stack
        # return variable h
        while (len(self.a)!=0): 
            self.b.append(self.a.pop())
        h = self.b.pop()
        while (len(self.b)!=0):
            self.a.append(self.b.pop())
        return(h)
        
        

    def peek(self):
        """
        Get the front element.
        :rtype: int
        """
        # return the front element which is 0th index element from main stack
        return(self.a[0])

    def empty(self):
        """
        Returns whether the queue is empty.
        :rtype: bool
        """
        #if len of main stack is not emplty return false else return true
        if  len(self.a)!=0:
            return False
        else:
            return True


# Your MyQueue object will be instantiated and called as such:
# obj = MyQueue()
# obj.push(x)
# param_2 = obj.pop()
# param_3 = obj.peek()
# param_4 = obj.empty()