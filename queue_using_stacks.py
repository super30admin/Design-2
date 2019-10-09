"""
Approach push data in to stack 1 . pop data from stack 2. if stack to is empty then pop data from stack 1 to stack 2
and then pop

"""
class MyQueue(object):
    
    stack_1 = []
    stack_2 = []
    
    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.stack_1 = []
        self.stack_2 = []
    
    def push(self, x):
        """
        Push element x to the back of queue.
        :type x: int
        :rtype: None
        O(1)
        """
        self.stack_1.append(x)
    
    
    
    def pop(self):
        """
        Removes the element from in front of queue and returns that element.
        :rtype: int
        O(1) on avg O(n) if stack 2 is empty ese O(1)
        """
        if self.empty() :
            return None
        
        if self.stack_2 :
            return self.stack_2.pop()
        
        while self.stack_1 :
            self.stack_2.append(self.stack_1.pop())
        
        return self.stack_2.pop()
    
    
    
    def peek(self):
        """
        Get the front element.
        :rtype: int
        O(1) on avg O(n) if stack 2 is empty ese O(1)
        """
        if self.empty() :
            return None
        
        if self.stack_2 :
            return self.stack_2[-1]
        
        while self.stack_1 :
            self.stack_2.append(self.stack_1.pop())
        
        return self.stack_2[-1]
    
    def empty(self):
        """
        Returns whether the queue is empty.
        :rtype: bool
        """
        return (len(self.stack_1) == 0) and (len(self.stack_2) == 0)



# Your MyQueue object will be instantiated and called as such:
# obj = MyQueue()
# obj.push(x)
# param_2 = obj.pop()
# param_3 = obj.peek()
# param_4 = obj.empty()